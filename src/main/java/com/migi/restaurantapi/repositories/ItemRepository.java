package com.migi.restaurantapi.repositories;

import com.migi.restaurantapi.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
