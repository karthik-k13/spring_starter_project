package com.mkr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkr.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
