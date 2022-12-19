package com.example.spring_boot_ms.controller;

import com.example.spring_boot_ms.dto.PaymentDto;
import com.example.spring_boot_ms.model.Payment;
import com.example.spring_boot_ms.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @GetMapping
    public Page<PaymentDto> list(@PageableDefault(size =10)Pageable pagination){
        return service.getAll(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getById(@PathVariable @NotNull Long id){
        PaymentDto dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/gate")
    public String returnGate(@Value("${local.server.port}") String gate){
        return String.format("Requisição respondida pela instancia executando na porta %s", gate);
    }

    @PostMapping
    public ResponseEntity<PaymentDto> register(@RequestBody @Valid PaymentDto dto, UriComponentsBuilder uriBuilder){
        PaymentDto paymentDto = service.createPayment(dto);
        URI address = uriBuilder.path("/payment/{id}").buildAndExpand(paymentDto.getId()).toUri();

        return ResponseEntity.created(address).body(paymentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> attPayment(@PathVariable @NotNull Long id, @RequestBody @Valid PaymentDto dto){
        PaymentDto updated = service.attPayment(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentDto> deleteById(@PathVariable @NotNull Long id){
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
