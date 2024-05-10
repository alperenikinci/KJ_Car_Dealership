package com.alperen.controller;

import com.alperen.dto.request.OrderRequestDto;
import com.alperen.dto.request.PaymentRequestDto;
import com.alperen.entity.Order;
import com.alperen.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.alperen.constant.RestApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(ORDER)
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = NEW_ORDER, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Order> newOrder(@RequestBody @ModelAttribute @Valid OrderRequestDto dto){
    return ResponseEntity.ok(orderService.newOrder(dto));
    }

    //TODO cancelOrder yazilmali.
    @PostMapping(ORDER_PAYMENT)
    public ResponseEntity<Order> orderPayment (@RequestBody @Valid PaymentRequestDto dto){
        return ResponseEntity.ok(orderService.orderPayment(dto));
    }

    //@PostMapping("/verify-address-for-delivery")

    //AddressController bunu kullanabilir.
    //@PostMapping("/verify-address")




}
