package com.migi.restaurantapi.services;

import com.migi.restaurantapi.models.Item;
import com.migi.restaurantapi.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> all(){
        List<Item> listOfItems = new ArrayList<>();
        Iterable<Item> items = itemRepository.findAll();

        items.forEach(listOfItems::add);
        return listOfItems;
    }

    public Optional<Item> find(Long id){
        return itemRepository.findById(id);
    }

    public Item create(Item item){
        return itemRepository.save(item);
    }

    public Optional<Item> update(Long id, Item item){
        return itemRepository.findById(id).map(oldItem -> {
            item.setId(id);
            return itemRepository.save(item);
        });
    }

    public void delete(Long id){
        itemRepository.deleteById(id);
    }
}
