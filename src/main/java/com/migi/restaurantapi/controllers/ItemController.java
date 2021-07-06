package com.migi.restaurantapi.controllers;

import com.migi.restaurantapi.models.Item;
import com.migi.restaurantapi.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping()
    public ResponseEntity<List<Item>> allItems(){
        List<Item> items = itemService.all();
        return ResponseEntity.ok().body(items);
    }

    @PostMapping("")
    public ResponseEntity<Item> saveItem(@Valid @RequestBody Item item){
        Item createdItem = itemService.create(item);
        return ResponseEntity.ok().body(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") Long id){
        Optional<Item> item = itemService.find(id);
        return ResponseEntity.of(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@Valid @PathVariable("id") Long id, @RequestBody Item item){
        Optional<Item> updatedItem = itemService.update(id, item);
        return ResponseEntity.of(updatedItem);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable("id") Long id){
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
