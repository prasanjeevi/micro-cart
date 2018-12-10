package com.cloudnative.frontend;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
  
  @Autowired
  ProductService productService;

  @RequestMapping("/")
  public String home(Model model) {
    model.addAttribute("products", productService.getProducts());
    model.addAttribute("topProducts", productService.getTopProducts());
    model.addAttribute("recentProducts", productService.getRecentProducts());
    return "index";
  }

  @RequestMapping("/product/{id}")
  public String productDetail(@PathVariable String id, Model model) {
    model.addAttribute("product", productService.getProduct(id).getId());
    return "product";
  }

  @PostMapping("/order")
  public String placeOrder(@ModelAttribute Product product, Model model) {
      Order order = new Order(product.getId(), "guest");
      String message = "Order # " + order.getId() + " placed for product # " + order.getProductId();
      model.addAttribute("message", message);
      System.out.println(message);
      productService.placeOrder(order);
      return "acknowledge";
  }

  @RequestMapping("/demo")
  public String demo() {
    return "demo";
  }
}