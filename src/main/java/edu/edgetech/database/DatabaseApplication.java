package edu.edgetech.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) { SpringApplication.run(DatabaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return (args) -> {
            repository.save(new Customer("Bob","Willey"));
            repository.save(new Customer("John","Robb"));
            repository.save(new Customer("Kathy","Brinks"));
            repository.save(new Customer("Stone","White"));
            repository.save(new Customer("Laura","Faires"));
            Customer cst = new Customer("Bryan","John");
            repository.save(cst);

            for(Customer cust: repository.findAll()){
                System.out.println(cust);
            }
            System.out.println();
            repository.deleteById(3);
            repository.delete(cst);
            cst.setLastname("Hikari");
            repository.save(cst);
            for(Customer cust: repository.findByLastname("Hikari")){
                System.out.println(cust);
            }
        };

    }


}
