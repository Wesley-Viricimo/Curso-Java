package com.cursonelioalves.repositories;

import com.cursonelioalves.entities.OrderItem;
import com.cursonelioalves.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
