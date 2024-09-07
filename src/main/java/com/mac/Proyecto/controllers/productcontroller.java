package com.mac.Proyecto.controllers;


import com.mac.Proyecto.domain.product;
import com.mac.Proyecto.service.ProductService;
import com.mac.Proyecto.service.productsserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class productcontroller {

    //ProductService productservice = new productsserviceimpl();
    @Autowired
    private ProductService productservice;

    @GetMapping
    public ResponseEntity<?> getproducts() {

        List<product> products = productservice.getproduct();

        return ResponseEntity.ok(products);
    }

}
