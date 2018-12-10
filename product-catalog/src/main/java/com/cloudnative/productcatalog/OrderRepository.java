package com.cloudnative.productcatalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query(value="SELECT * FROM orders ORDER BY ordered_on DESC LIMIT 3", nativeQuery = true)
    Iterable<Order> recentOrders();
}
