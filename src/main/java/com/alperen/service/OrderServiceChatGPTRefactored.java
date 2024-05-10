//package com.alperen.service;
//
//import com.alperen.dto.request.OrderRequestDto;
//import com.alperen.dto.request.PaymentRequestDto;
//import com.alperen.entity.*;
//import com.alperen.entity.enums.EStatus;
//import com.alperen.entity.superclasses.Car;
//import com.alperen.exception.CarDealershipException;
//import com.alperen.exception.ErrorType;
//import com.alperen.mapper.*;
//import com.alperen.repository.OrderRepository;
//import com.alperen.utility.ServiceManager;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class OrderServiceChatGPTRefactored extends ServiceManager<Order, Long> {
//    private final OrderRepository orderRepository;
//    private final CustomerService customerService;
//    private final AddressService addressService;
//    private final Address_CustomerService addressCustomerService;
//    private final CarService carService;
//    private final CreditCardInfoService creditCardInfoService;
//    private final PaymentInfoService paymentInfoService;
//
//
//    public OrderService2(OrderRepository orderRepository, CustomerService customerService, AddressService addressService, Address_CustomerService addressCustomerService, CarService carService, CreditCardInfoService creditCardInfoService, PaymentInfoService paymentInfoService) {
//        super(orderRepository);
//        this.orderRepository = orderRepository;
//        this.customerService = customerService;
//        this.addressService = addressService;
//        this.addressCustomerService = addressCustomerService;
//        this.carService = carService;
//        this.creditCardInfoService = creditCardInfoService;
//        this.paymentInfoService = paymentInfoService;
//    }
//
//    public Order newOrder(OrderRequestDto dto) {
//        Optional<Car> car = carService.findByCarCode(dto.getCarType(), dto.getCarCode());
//        if (car.isEmpty() || !car.get().getStatus().equals(EStatus.ON_SHOWROOM)) {
//            throw new CarDealershipException(ErrorType.CAR_NOT_FOUND);
//        }
//
//        if (dto.getPaymentAmount() < car.get().getPrice() / 10) {
//            throw new CarDealershipException(ErrorType.CAR_NOT_FOUND, "Minimum down payment amount required: " + (car.get().getPrice() / 10));
//        }
//
//        carService.updateCarStatus(car.get());
//        Address address = getOrCreateAddress(dto);
//        Customer customer = getOrCreateCustomer(dto);
//        Order order = createOrder(dto, car.get(), address, customer);
//        PaymentInfo paymentInfo = createPaymentInfo(dto, order);
//
//        return order;
//    }
//
//    private Address getOrCreateAddress(OrderRequestDto dto) {
//        Address address = AddressMapper.INSTANCE.fromOrderRequestToAddress(dto);
//        if (!addressService.doesAddressExist(address)) {
//            addressService.save(address);
//        } else {
//            address = addressService.findDuplicateAddress(address).get();
//        }
//        return address;
//    }
//
//    private Customer getOrCreateCustomer(OrderRequestDto dto) {
//        Customer customer = CustomerMapper.INSTANCE.fromOrderRequestToCustomer(dto);
//        if (!customerService.doesCustomerExist(customer)) {
//            customerService.save(customer);
//        } else {
//            customer = customerService.findByCustomerCitizenshipId(customer.getCustomerCitizenshipId()).get();
//        }
//        customer.setIsCustomerVerified(true);
//        return customer;
//    }
//
//    private Order createOrder(OrderRequestDto dto, Car car, Address address, Customer customer) {
//        Order order = OrderMapper.INSTANCE.fromOrderRequestToOrder(dto);
//        order.setRemainingAmount(car.getPrice() - dto.getPaymentAmount());
//        order.setIsDownPaymentCompleted(true);
//        order.setAddressCustomerId(getOrCreateAddressCustomer(address, customer).getId());
//
//        if (order.getRemainingAmount() <= 0) {
//            order.setIsPaymentCompleted(true);
//            car.setStatus(EStatus.SOLD);
//        } else {
//            car.setStatus(EStatus.PENDING_FOR_FULL_PAYMENT);
//        }
//
//        save(order);
//        return order;
//    }
//
//    private Address_Customer getOrCreateAddressCustomer(Address address, Customer customer) {
//        Address_Customer addressCustomer = Address_Customer.builder().addressId(address.getId()).customerId(customer.getId()).build();
//        if (!addressCustomerService.doesAddressCustomerExists(addressCustomer)) {
//            addressCustomerService.save(addressCustomer);
//        } else {
//            addressCustomer = addressCustomerService.findByAddressIdAndCustomerId(address.getId(), customer.getId()).get();
//        }
//        return addressCustomer;
//    }
//
//    private PaymentInfo createPaymentInfo(OrderRequestDto dto, Order order) {
//        PaymentInfo paymentInfo = PaymentInfoMapper.INSTANCE.fromOrderRequestToPaymentInfo(dto);
//        paymentInfo.setOrderId(order.getId());
//        paymentInfo.setCreditCardId(getOrCreateCreditCardInfo(dto).getId());
//        paymentInfoService.save(paymentInfo);
//        return paymentInfo;
//    }
//
//    private CreditCardInfo getOrCreateCreditCardInfo(OrderRequestDto dto) {
//        CreditCardInfo creditCardInfo = CreditCardInfoMapper.INSTANCE.fromOrderRequestToCreditCardInfo(dto);
//        if (!creditCardInfoService.doesCreditCardInfoExists(creditCardInfo)) {
//            creditCardInfoService.save(creditCardInfo);
//        } else {
//            creditCardInfo = creditCardInfoService.findDuplicateCreditCardInfo(creditCardInfo).get();
//        }
//        return creditCardInfo;
//    }
//
//    public Order orderPayment(PaymentRequestDto dto) {
//        Optional<Order> orderOptional = orderRepository.findByCarCode(dto.getCarCode());
//        if (orderOptional.isEmpty()) {
//            throw new CarDealershipException(ErrorType.ORDER_NOT_FOUND);
//        }
//
//        Order order = orderOptional.get();
//        Car car = carService.findByCarCode(order.getCarType(), order.getCarCode()).get();
//
//        if (order.getRemainingAmount() <= 0) {
//            throw new CarDealershipException(ErrorType.PAYMENT_ALREADY_COMPLETED);
//        }
//
//        double remainingAmount = order.getRemainingAmount() - dto.getPaymentAmount();
//        CreditCardInfo creditCardInfo = getOrCreateCreditCardInfo(dto);
//
//        if (remainingAmount <= 0) {
//            handlePaymentCompletion(order, car);
//        } else {
//            order.setRemainingAmount(remainingAmount);
//        }
//
//        save(order);
//        createPaymentInfo(dto, order);
//        return order;
//    }
//
//    private void handlePaymentCompletion(Order order, Car car) {
//        double repaymentAmount = Math.abs(order.getRemainingAmount());
//        order.setRemainingAmount(0);
//        order.setIsPaymentCompleted(true);
//        car.setStatus(EStatus.SOLD);
//        carService.updateCarStatus(car);
//        handleDelivery(order);
//    }
//
//    private void handleDelivery(Order order) {
//        Optional<Address_Customer> addressCustomer = addressCustomerService.findById(order.getAddressCustomerId());
//        if (addressCustomer.isEmpty()) {
//            throw new CarDealershipException(ErrorType.ADDRESS_NOT_FOUND);
//        }
//
//        Optional<Address> address = addressService.findById(addressCustomer.get().getAddressId());
//        if (address.isPresent()) {
//            if (address.get().getIsAddressVerified()) {
//                order.setIsDeliveryCompleted(true);
//            } else {
//                //TODO: Wait for address verification and send notification to the user
//            }
//        } else {
//            throw new CarDealershipException(ErrorType.ADDRESS_NOT_FOUND);
//        }
//    }
//
//}
