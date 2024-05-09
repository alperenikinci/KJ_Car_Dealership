package com.alperen.service;

import com.alperen.entity.Address;
import com.alperen.entity.Customer;
import com.alperen.repository.AddressRepository;
import com.alperen.repository.CustomerRepository;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService extends ServiceManager<Address,Long> {

    private final AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository) {
        super(addressRepository);
        this.addressRepository = addressRepository;
    }
    public Boolean doesAddressExist(Address address) {
        return addressRepository.existsByStreetAndCityAndApartmentNoAndPostalCodeAndCountryId(
                address.getStreet(), address.getCity(), address.getApartmentNo(),
                address.getPostalCode(), address.getCountryId());
    }

    public Optional<Address> findDuplicateAddress(Address address) {
        return addressRepository.findByStreetAndCityAndApartmentNoAndPostalCodeAndCountryId(
                address.getStreet(), address.getCity(), address.getApartmentNo(),
                address.getPostalCode(), address.getCountryId());
    }



}
