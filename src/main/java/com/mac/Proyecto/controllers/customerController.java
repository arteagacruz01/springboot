package com.mac.Proyecto.controllers;

import com.mac.Proyecto.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class customerController {

    private List<Customer> custoners = new ArrayList<>(Arrays.asList(
            new Customer(1234, "Mauricio", "mau", "Muaricio123"),
            new Customer(1235, "Zuli",  "tuza", "3e3e3"),
            new Customer( 1236,  "Edaly",  "Amayrani", "4f4f"),
            new Customer( 1237,  "Olivia",  "Oli",  "4f4mf4")
    ));

   // @GetMapping("/clientes")
    @GetMapping
   // @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<Customer>>  getCustoners() {

        return ResponseEntity.ok(custoners);
    }

    //@GetMapping("clientes/{username}")
    @GetMapping("/{username}")
   // @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<?>  getCliente(@PathVariable String username){
        for(Customer c : custoners){
            if (c.getUsername().equalsIgnoreCase(username)){
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado: " + username) ;
    }
    //@PostMapping("/clientes")
    @PostMapping
   // @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?>  ostCliente(@RequestBody Customer customer){
        custoners.add(customer);

       URI location = ServletUriComponentsBuilder
       .fromCurrentRequest()
       .path("/{userame}")
       .buildAndExpand(customer.getUsername())
       .toUri();
       // return ResponseEntity.created(location).build();
       return ResponseEntity.created(location).body(customer);
        // return ResponseEntity.status(HttpStatus.CREATED).body("Agregado correctamente: " + customer.getName());
    }

    //@PutMapping("/clientes")
     @PutMapping
   // @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> putCliente(@RequestBody Customer customer){

        for(Customer c : custoners){

            if(c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return  ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
    //@DeleteMapping("/clientes/{id}")
    @DeleteMapping("/{id}")
   // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?>  deleteCliente(@PathVariable int id){
        for (Customer c : custoners){
            if(c.getID() == id){
                custoners.remove(c);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //@PatchMapping("/clientes")
    //@PatchMapping
    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<?> atchCliente(@RequestBody Customer customer){
        for (Customer c : custoners){
            if(c.getID() == customer.getID()){

                if(customer.getName() != null){
                    c.setName(customer.getName());
                }
                if(customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }
                return  ResponseEntity.ok("modificado: " + c.getUsername());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado" + customer.getID());
    }
}
