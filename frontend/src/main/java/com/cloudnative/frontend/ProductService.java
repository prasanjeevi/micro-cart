package com.cloudnative.frontend;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


public class ProductService {

  @Autowired
	@LoadBalanced
  protected RestTemplate restTemplate;
  
  @HystrixCommand(fallbackMethod = "getProductsCached")
  public List<Product> getProducts() {
    System.out.println("Get Products");
    return Arrays.asList(restTemplate.getForObject("http://PRODUCT-CATALOG/products",
      Product[].class));
  }

  @HystrixCommand(fallbackMethod = "getProductsCached")
  public List<Product> getTopProducts() {
    System.out.println("Get top Products");
    return Arrays.asList(restTemplate.getForObject("http://PRODUCT-CATALOG/products/top",
      Product[].class));
  }

  @HystrixCommand(fallbackMethod = "getProductsCached")
  public List<Product> getRecentProducts() {
    System.out.println("Get recent Products");
    return Arrays.asList(restTemplate.getForObject("http://PRODUCT-CATALOG/products/recent",
      Product[].class));
  }

  public Product getProduct(String id) {
    System.out.println("Get Product by ID");
    return restTemplate.getForObject("http://PRODUCT-CATALOG/products/" + id, Product.class);
  }

  public List<Product> getProductsCached() {
    System.out.println("Get Product Fallback");
    List<Product> products = new ArrayList<Product>();
    Product product1 = new Product("iPhone 7", 30, new BigDecimal(200));
    product1.setId("1");
    products.add(product1);
    return products;
  }

  public void placeOrder(Order order) {
    System.out.println("Post Order request");
    restTemplate.postForObject("http://ORDER/orders", order, Order.class);
  }
}