package com.d288.awilliams.dao;

import com.d288.awilliams.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:4200")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
