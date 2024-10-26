package com.example.order.service;


import com.example.order.dto.OrderDto;
import com.example.order.model.OrderModel;
import com.example.order.repository.OrderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDto> getAllOrders(){
        List<OrderModel> orderList=orderRepo.findAll();
        return modelMapper.map(orderList,new TypeToken<List<OrderDto>>(){}.getType());
    }

    public OrderDto getUserById(Integer userId){
        OrderModel user=orderRepo.findUserById(userId);
        return modelMapper.map(user,OrderDto.class);
    }

    public OrderDto saveOrder(OrderDto orderDto){
        orderRepo.save(modelMapper.map(orderDto,OrderModel.class));
        return orderDto;
    }

    public OrderDto updateOrder(OrderDto orderDto){
        orderRepo.save(modelMapper.map(orderDto,OrderModel.class));
        return orderDto;
    }

    public String deleteOrder(Integer orderId){
        orderRepo.deleteById(orderId);
        return "Order Deleted Successfully";
    }


}
