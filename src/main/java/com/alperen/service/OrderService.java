package com.alperen.service;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.dto.request.PaymentRequestDto;
import com.alperen.entity.*;
import com.alperen.entity.enums.EStatus;
import com.alperen.entity.superclasses.Car;
import com.alperen.exception.CarDealershipException;
import com.alperen.exception.ErrorType;
import com.alperen.mapper.*;
import com.alperen.repository.OrderRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService extends ServiceManager<Order, Long> {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final AddressService addressService;
    private final Address_CustomerService addressCustomerService;
    private final CarService carService;
    private final CreditCardInfoService creditCardInfoService;
    private final PaymentInfoService paymentInfoService;


    public OrderService(OrderRepository orderRepository, CustomerService customerService, AddressService addressService, Address_CustomerService addressCustomerService, CarService carService, CreditCardInfoService creditCardInfoService, PaymentInfoService paymentInfoService) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.addressService = addressService;
        this.addressCustomerService = addressCustomerService;
        this.carService = carService;
        this.creditCardInfoService = creditCardInfoService;
        this.paymentInfoService = paymentInfoService;
    }

    public Order newOrder(OrderRequestDto dto) {
        Optional<Car> car = carService.findByCarCode(dto.getCarType(), dto.getCarCode());
        //TODO Farkli exceptionlar vermek icin if blogu ikiye ayrilabilir.
        if (!car.isPresent() && !car.get().getStatus().equals(EStatus.ON_SHOWROOM)) {
            throw new CarDealershipException(ErrorType.CAR_NOT_FOUND);
        }
        if (dto.getPaymentAmount() < (car.get().getPrice() / 10)) {
            throw new CarDealershipException(ErrorType.CAR_NOT_FOUND, "Odemeniz gereken minimum kapora tutari : " + (car.get().getPrice() / 10));
        }

        carService.updateCarStatus(car.get());
        Address address = AddressMapper.INSTANCE.fromOrderRequestToAddress(dto);
        Customer customer = CustomerMapper.INSTANCE.fromOrderRequestToCustomer(dto);
        Order order = OrderMapper.INSTANCE.fromOrderRequestToOrder(dto);
        order.setRemainingAmount(car.get().getPrice());
        CreditCardInfo creditCardInfo = CreditCardInfoMapper.INSTANCE.fromOrderRequestToCreditCardInfo(dto);

        customerService.saveAndVerifyCustomerIfNotExists(customer);
        addressService.saveAddressIfNotExists(address);

        Address_Customer addressCustomer = Address_Customer.builder().addressId(address.getId()).customerId(customer.getId()).build();
        addressCustomerService.saveIfNotExists(addressCustomer);

        order.setAddressCustomerId(addressCustomer.getId());
        order.setRemainingAmount(car.get().getPrice() - dto.getPaymentAmount());
        completePaymentAndHandleRepayment(order,car.get());
        order.setIsDownPaymentCompleted(true);
        save(order);

        PaymentInfo paymentInfo = PaymentInfoMapper.INSTANCE.fromOrderRequestToPaymentInfo(dto);
        paymentInfo.setOrderId(order.getId());
        paymentInfo.setCreditCardId(creditCardInfo.getId());
        paymentInfoService.save(paymentInfo);
        return order;
    }


    public Order orderPayment(PaymentRequestDto dto) {
        Optional<Order> orderOptional = orderRepository.findByCarCode(dto.getCarCode());

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            Car car = car = carService.findByCarCode(order.getCarType(), order.getCarCode()).get();
            if (order.getRemainingAmount() > 0) {
                Double remainingAmount = order.getRemainingAmount() - dto.getPaymentAmount();
                CreditCardInfo creditCardInfo = CreditCardInfoMapper.INSTANCE.fromPaymentRequestToCreditCardInfo(dto);
                if (remainingAmount <= 0) {
                    //TODO repayment metodunu calistir. Repayment metodu fazlalık kısmı geri kullanıcıya yatıracak.

                    Double repaymentAmount = Math.abs(remainingAmount); //Repayment metoduna gidecek argüman
                    order.setRemainingAmount(0D);
                    order.setIsPaymentCompleted(true);
                    //TODO true olduğu icin, kullaniciya bilgilendirme maili atmam lazim. Mailde geri yatirilacak tutari da verebilirim.
                    car.setStatus(EStatus.SOLD);
                    carService.updateCarStatus(car);

                    Optional<Address_Customer> addressCustomer = addressCustomerService.findById(order.getAddressCustomerId());
                    if (addressCustomer.isPresent()) {
                        Optional<Address> address = addressService.findById(addressCustomer.get().getAddressId());
                        if (address.isPresent()) {
                            if (address.get().getIsAddressVerified()) {
                                //TODO arac gonderme islemlerini baslat ve mail bildirimi yap.
                                order.setIsDeliveryCompleted(true);
                            } else {
                                //TODO arac gonderme islemlerini beklet, kullaniciya address dogrulama bildirimi yap.
                            }
                        } else {
                            throw new CarDealershipException(ErrorType.ADDRESS_NOT_FOUND);
                            //TODO address verification ekranına aktar.
                        }
                    } else {
                        throw new CarDealershipException(ErrorType.ADDRESS_NOT_FOUND);
                    }

                } else {
                    order.setRemainingAmount(remainingAmount);
                }
                if (!creditCardInfoService.doesCreditCardInfoExists(creditCardInfo)) {
                    creditCardInfoService.save(creditCardInfo);
                } else {
                    creditCardInfo = creditCardInfoService.findDuplicateCreditCardInfo(creditCardInfo).get();
                }
                PaymentInfo paymentInfo = PaymentInfoMapper.INSTANCE.fromPaymentRequestToPaymentInfo(dto);
                paymentInfo.setCreditCardId(creditCardInfo.getId());
                paymentInfo.setOrderId(order.getId());
                paymentInfoService.save(paymentInfo);
                save(order);
            } else {
                throw new CarDealershipException(ErrorType.PAYMENT_ALREADY_COMPLETED);
            }
            return order;
        } else {
            throw new CarDealershipException(ErrorType.ORDER_NOT_FOUND);
        }
    }
    private Order completePaymentAndHandleRepayment(Order order, Car car){
        if (order.getRemainingAmount() <= 0) { //Fazla ödeme durumunda Repayment yapılmalı.
            order.setIsPaymentCompleted(true);
            car.setStatus(EStatus.SOLD);
            //TODO order complete olursa, burada satış işlemlerini tamamlayıcı işlemler gerçekleştirilecek.
        } else {
            car.setStatus(EStatus.PENDING_FOR_FULL_PAYMENT);
        }
        return order;
    }
}
