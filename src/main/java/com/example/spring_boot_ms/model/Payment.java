package com.example.spring_boot_ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotNull
    @Positive
    private BigDecimal paymentValue;
    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    @Size(max = 19)
    private String number;
    @NotBlank
    @Size(max = 7)
    private String expiration;
    @NotBlank
    @Size(max = 3, min = 3)
    private String code;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    private Long requestId;
    @NotNull
    private Long wayToPaymentId;
}
