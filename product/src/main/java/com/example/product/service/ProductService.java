package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.model.ProductModel;
import com.example.product.repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDto> getAllProducts(){
        List<ProductModel> orderList=productRepo.findAll();
        return modelMapper.map(orderList,new TypeToken<List<ProductDto>>(){}.getType());
    }

    public ProductDto getProductById(Integer productId){
        ProductModel product=productRepo.findUserById(productId);
        return modelMapper.map(product,ProductDto.class);
    }

    public ProductDto saveProduct(ProductDto productDto){
        productRepo.save(modelMapper.map(productDto,ProductModel.class));
        return productDto;
    }

    public ProductDto updateProduct(ProductDto productDto){
        productRepo.save(modelMapper.map(productDto,ProductModel.class));
        return productDto;
    }

    public String deleteProduct(Integer productId){
        productRepo.deleteById(productId);
        return "Order Deleted Successfully";
    }



}
