package com.zbhg.mcp.firstProject.controllers;

import com.zbhg.mcp.firstProject.models.Item;
import com.zbhg.mcp.firstProject.models.ItemRepository;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@RestController
public class FirstController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(path = "/")
    public @ResponseBody String sayHello() {
        System.out.println("Starting");
        return "Hello World";
    }

    @PostMapping(path = "/addItem")
    public @ResponseBody String addItem(@RequestBody Item item) {
        itemRepository.save(item);
        return "Saved";
    }

    @GetMapping(path = "/findItemById")
    public @ResponseBody Optional<Item> findItemById(@RequestParam int id) {
        return itemRepository.findById(id);
    }

    @GetMapping(path = "allItems")
    public @ResponseBody Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @DeleteMapping(path = "deleteItemById")
    public @ResponseBody String deleteItemById(@RequestParam int id) {
        itemRepository.deleteById(id);
        return "Deleted";
    }

}
