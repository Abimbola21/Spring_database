package edu.edgetech.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;

@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) { SpringApplication.run(DatabaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return (args) -> {
            //save new customer records to the database
            repository.save(new Customer("Bob","Willey"));
            repository.save(new Customer("John","Robb"));
            repository.save(new Customer("Kathy","Brinks"));
            repository.save(new Customer("Stone","White"));
            repository.save(new Customer("Laura","Faires"));
            Customer cst = new Customer("Bryan","John");
            repository.save(cst);

            //find all customers and print them
            for(Customer cust: repository.findAll()){
                System.out.println(cust);
            }
            System.out.println();

            //delete customer with id #3
            //but catch the error if the id does not exist
            try {
                repository.deleteById(3);
                repository.delete(cst);
            }
            catch (EmptyResultDataAccessException ex){
                System.out.println(ex);
            }
            cst.setLastname("Hikari");
            repository.save(cst);

            //testing my new method findByLastname created in the CustomerRepository
            for(Customer cust: repository.findByLastname("Hikari")){
                System.out.println(cust);
            }
        };

    }


}
