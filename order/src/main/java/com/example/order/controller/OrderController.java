package com.example.order.controller;


import com.example.order.dto.OrderDto;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public OrderDto getOrderById(@PathVariable int orderId){
        return orderService.getUserById(orderId);
    }

    @PostMapping("/")
    public OrderDto createOrder(@RequestBody OrderDto orderDto){
        return orderService.saveOrder(orderDto);
    }

    @PutMapping("/")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto){
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable int orderId){
        return orderService.deleteOrder(orderId);
    }



}
