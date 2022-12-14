package com.example.spring_boot_ms.dto;

import com.example.spring_boot_ms.model.Status;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class PaymentDto {
    private Long id;
    private BigDecimal value;
    private String name;
    private String number;
    private String expiration;
    private String code;
    private Status status;
    private Long wayToPayment;
    private Long requestId;
}
