package com.example.invenentory.service;

import com.example.invenentory.dto.InventoryDto;
import com.example.invenentory.model.InventoryModel;
import com.example.invenentory.repository.InventoryRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<InventoryDto> getAllInventory(){
        List<InventoryModel> orderList=inventoryRepo.findAll();
        return modelMapper.map(orderList,new TypeToken<List<InventoryDto>>(){}.getType());
    }

    public InventoryDto getInventoryById(Integer inventoryId){
        InventoryModel product=inventoryRepo.findUserById(inventoryId);
        return modelMapper.map(product,InventoryDto.class);
    }

    public InventoryDto saveInventory(InventoryDto inventoryDto){
        inventoryRepo.save(modelMapper.map(inventoryDto,InventoryModel.class));
        return inventoryDto;
    }

    public InventoryDto updateInventory(InventoryDto inventoryDto){
        inventoryRepo.save(modelMapper.map(inventoryDto,InventoryModel.class));
        return inventoryDto;
    }

    public String deleteInventory(Integer inventoryId){
        inventoryRepo.deleteById(inventoryId);
        return "Order Deleted Successfully";
    }
}
