package com.zaf3r.tacocloud.repository;

import com.zaf3r.tacocloud.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByZip(String deliveryZip);
}
