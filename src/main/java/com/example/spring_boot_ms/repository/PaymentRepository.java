package com.example.spring_boot_ms.repository;

import com.example.spring_boot_ms.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
