package com.zbhg.mcp.firstProject.controllers;

import com.zbhg.mcp.firstProject.models.ItemEntity;
import com.zbhg.mcp.firstProject.models.ItemRepository;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping(path = "/addItem")
    public @ResponseBody ItemEntity addItem(@RequestBody ItemEntity item) {
        return itemRepository.save(item);
    }

    @GetMapping(path = "/allItems")
    public @ResponseBody Iterable<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping(path = "/findItemById")
    public @ResponseBody Optional<ItemEntity> findItemById(@RequestParam int id) {
        return itemRepository.findById(id);
    }

    @PutMapping(path = "/updateItemById")
    public @ResponseBody Optional<ItemEntity> updateItemById(@RequestParam int id, @RequestBody ItemEntity item) {

        Optional<ItemEntity> optionalItem = itemRepository.findById(id);

        if(optionalItem.isPresent()) {
            ItemEntity existingItem = optionalItem.get();
            existingItem.setDescription(item.getDescription());
            existingItem.setPrice(item.getPrice());
            existingItem.setQuantity(item.getQuantity());
            itemRepository.save(existingItem);
            return Optional.of(existingItem);
        }
        return Optional.ofNullable(item);
    }

    @DeleteMapping(path = "/deleteItemById")
    public @ResponseBody Optional<ItemEntity> deleteItemById(@RequestParam int id) {
        Optional<ItemEntity> itemEntity = itemRepository.findById(id);
        itemRepository.deleteById(id);
        return itemEntity;
    }

}
