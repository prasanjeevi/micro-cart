package com.cloudnative.productcatalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    
    @Query(value="SELECT P.*,COUNT(1) AS 'sale' FROM product P, orders O WHERE P.id=O.product_id GROUP BY P.id ORDER BY 'sale' DESC LIMIT 3", nativeQuery = true)
    Iterable<Product> topProducts();

    @Query(value="SELECT P.*,MAX(ordered_on) AS 'last_purchase' FROM product P, orders O WHERE P.id=O.product_id GROUP BY product_id ORDER BY 'last_purchase' DESC LIMIT 3", nativeQuery = true)
    Iterable<Product> recentProducts();
}
