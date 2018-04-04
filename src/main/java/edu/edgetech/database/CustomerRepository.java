package edu.edgetech.database;


import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer,Integer>{

    //new method to find customer by their lastname
    //it returns a list
  List<Customer> findByLastname(String lastName);

}