package com.example.invenentory.controller;

import com.example.invenentory.dto.InventoryDto;
import com.example.invenentory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/")
    public List<InventoryDto> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{inventoryId}")
    public InventoryDto getInventoryById(@PathVariable int inventoryId){
        return inventoryService.getInventoryById(inventoryId);
    }

    @PostMapping("/")
    public InventoryDto createInventory(@RequestBody InventoryDto inventoryDto){
        return inventoryService.saveInventory(inventoryDto);
    }

    @PutMapping("/")
    public InventoryDto updateOrder(@RequestBody InventoryDto inventoryDto){
        return inventoryService.updateInventory(inventoryDto);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable int inventoryId){
        return inventoryService.deleteInventory(inventoryId);
    }
}
