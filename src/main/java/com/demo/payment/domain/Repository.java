package com.demo.payment.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Payment, Long>{
    
}
