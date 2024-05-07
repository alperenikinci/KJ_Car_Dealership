package com.alperen.service;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.entity.Address;
import com.alperen.entity.Address_Customer;
import com.alperen.entity.Customer;
import com.alperen.entity.Order;
import com.alperen.mapper.AddressMapper;
import com.alperen.mapper.CustomerMapper;
import com.alperen.mapper.OrderMapper;
import com.alperen.repository.OrderRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceManager<Order,Long> {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final AddressService addressService;
    private final Address_CustomerService addressCustomerService;


    public OrderService(OrderRepository orderRepository, CustomerService customerService, AddressService addressService, Address_CustomerService addressCustomerService) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.addressService = addressService;
        this.addressCustomerService = addressCustomerService;
    }

    public Order newOrder(OrderRequestDto dto){
        Address address = AddressMapper.INSTANCE.fromOrderRequestToAddress(dto);
        Customer customer = CustomerMapper.INSTANCE.fromOrderRequestToCustomer(dto);
        customerService.save(customer);
        address.setCountryId(1L);
        addressService.save(address); //TODO Address,countryId düzenlenecek.
        addressCustomerService.save(Address_Customer.builder()
                .addressId(address.getId()).customerId(customer.getId()).build());
        Order order = OrderMapper.INSTANCE.fromOrderRequestToOrder(dto);
        order.setCustomerId(customer.getId());
        order.setAddressId(customer.getId());
        return save(order);
    }

    //4 electric, 2 hybrid, 10 ICE car.
}
