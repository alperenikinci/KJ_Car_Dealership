package com.alperen.service;

import com.alperen.dto.request.OrderRequestDto;
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
        Optional<Car> car = carService.findByCarCode(dto.getCarType(),dto.getCarCode());
        if(car.isPresent() && car.get().getStatus().equals(EStatus.ON_SHOWROOM)){ //TODO Farkli exceptionlar vermek icin if blogu ikiye ayrilabilir.
            if (dto.getPaymentAmount()>=(car.get().getPrice()/10)){
                carService.updateCarStatus(car.get());
                Address address = AddressMapper.INSTANCE.fromOrderRequestToAddress(dto);
                Customer customer = CustomerMapper.INSTANCE.fromOrderRequestToCustomer(dto);
                Order order = OrderMapper.INSTANCE.fromOrderRequestToOrder(dto);
                order.setRemainingAmount(car.get().getPrice());
                CreditCardInfo creditCardInfo = CreditCardInfoMapper.INSTANCE.fromOrderRequestToCreditCardInfo(dto);

                if (!customerService.doesCustomerExist(customer)) {
                    customerService.save(customer);
                } else {
                    customer = customerService.findByCustomerCitizenshipId(customer.getCustomerCitizenshipId()).get();
                }
                customer.setIsCustomerVerified(true);

                if (!addressService.doesAddressExist(address)) {
                    addressService.save(address);
                } else {
                    address = addressService.findDuplicateAddress(address).get();
                }

                Address_Customer addressCustomer = Address_Customer.builder().addressId(address.getId()).customerId(customer.getId()).build();

                if (!addressCustomerService.doesAddressCustomerExists(addressCustomer)) {
                    addressCustomerService.save(addressCustomer);
                } else {
                    addressCustomer = addressCustomerService.findByAddressIdAndCustomerId(address.getId(), customer.getId()).get();
                }

                if (!creditCardInfoService.doesCreditCardInfoExists(creditCardInfo)) {
                    creditCardInfoService.save(creditCardInfo);
                } else {
                    creditCardInfo = creditCardInfoService.findDuplicateCreditCardInfo(creditCardInfo).get();
                }

                order.setAddressCustomerId(addressCustomer.getId());
                order.setRemainingAmount(car.get().getPrice()-dto.getPaymentAmount());
                if (order.getRemainingAmount()==0){
                    order.setIsOrderCompleted(true);
                    car.get().setStatus(EStatus.SOLD);
                    //TODO order complete olursa, burada satış işlemlerini tamamlayıcı işlemler gerçekleştirilecek.
                } else {
                    car.get().setStatus(EStatus.PENDING_FOR_FULL_PAYMENT);
                }
                order.setIsPreOrderCompleted(true);
                save(order);
                PaymentInfo paymentInfo = PaymentInfoMapper.INSTANCE.fromOrderRequestToPaymentInfo(dto);
                paymentInfo.setOrderId(order.getId());
                paymentInfo.setCreditCardId(creditCardInfo.getId());
                paymentInfoService.save(paymentInfo);

                return order;
            } else {
                throw new CarDealershipException(ErrorType.CAR_NOT_FOUND,"Odemeniz gereken minimum kapora tutari : " + (car.get().getPrice()/10));
            }
        } else {
            throw new CarDealershipException(ErrorType.CAR_NOT_FOUND);
        }
    }
}
