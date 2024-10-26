package com.example.product.controller;

import com.example.product.dto.ProductDto;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<ProductDto> getAllOrders(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductDto getOrderById(@PathVariable int productId){
        return productService.getProductById(productId);
    }

    @PostMapping("/")
    public ProductDto createOrder(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @PutMapping("/")
    public ProductDto updateOrder(@RequestBody ProductDto productDto){
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/{productId}")
    public String deleteOrder(@PathVariable int productId){
        return productService.deleteProduct(productId);
    }


}
