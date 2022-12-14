package com.example.spring_boot_ms.service;

import com.example.spring_boot_ms.dto.PaymentDto;
import com.example.spring_boot_ms.model.Payment;
import com.example.spring_boot_ms.model.Status;
import com.example.spring_boot_ms.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PaymentDto> getAll(Pageable pagination){
        return repository.findAll(pagination).map(p -> modelMapper.map(p, PaymentDto.class));
    }

    public PaymentDto getById(Long id){
        Payment payment = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(payment, PaymentDto.class);
    }

    public PaymentDto createPayment(PaymentDto dto){
        Payment payment = modelMapper.map(dto, Payment.class);
        payment.setStatus(Status.CREATED);
        repository.save(payment);
        return modelMapper.map(payment, PaymentDto.class);
    }

    public PaymentDto attPayment(Long id, PaymentDto dto){
        Payment payment = modelMapper.map(dto, Payment.class);
        payment.setId(id);
        payment = repository.save(payment);
        return modelMapper.map(payment, PaymentDto.class);
    }

    public void deletePayment(Long id){
        repository.deleteById(id);
    }
}
