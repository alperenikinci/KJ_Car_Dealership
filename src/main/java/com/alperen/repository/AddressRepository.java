package com.alperen.repository;

import com.alperen.entity.Address;
import com.alperen.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    boolean existsByStreetAndCityAndApartmentNoAndPostalCodeAndCountryId(
            String street, String city, String apartmentNo, String postalCode, Long countryId);
    Optional<Address> findByStreetAndCityAndApartmentNoAndPostalCodeAndCountryId(
            String street, String city, String apartmentNo, String postalCode, Long countryId);
}
