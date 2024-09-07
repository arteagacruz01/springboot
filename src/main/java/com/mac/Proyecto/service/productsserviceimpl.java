package com.mac.Proyecto.service;

import com.mac.Proyecto.domain.product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class productsserviceimpl implements ProductService {


    List<product> products = new ArrayList<>(Arrays.asList(

            new product(1, "Laptop", 800.8, 10),
            new product(2, "celular", 500.7, 30),
            new product(3, "tablet", 300.5, 34),
            new product(4, "reloj", 530.5, 56)

    ));



    @Override
    public List<product> getproduct() {
        return products;
    }
}
