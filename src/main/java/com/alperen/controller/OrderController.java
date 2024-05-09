package com.alperen.controller;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.entity.ElectricCar;
import com.alperen.entity.Order;
import com.alperen.entity.superclasses.Car;
import com.alperen.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/newOrder")
    public ResponseEntity<Order> newOrder(@RequestBody @Valid OrderRequestDto dto){
    return ResponseEntity.ok(orderService.newOrder(dto));
    }


}
