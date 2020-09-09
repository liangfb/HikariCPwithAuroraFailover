package com.liangfb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.sql.DataSource;
import java.util.Date;
import java.util.List;
import org.springframework.core.env.Environment;
import java.net.InetAddress;

@SpringBootApplication
public class ConnpoolApplication implements CommandLineRunner {


    @Autowired
    DataSource dataSource;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(ConnpoolApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

        java.security.Security.setProperty("networkaddress.cache.ttl" , "60");
        java.security.Security.setProperty("networkaddress.cache.negative.ttl", "0");
        int count = 0;
        while(true) {

            count ++;
            System.out.println("Display all customers..." + new Date());
            System.out.println(InetAddress.getByName(environment.getProperty("mysql.server")));
            List<Customer> list = customerService.findAll();
            list.forEach(x -> System.out.println("Id:" + x.id + " | name:" + x.name + " | email:" + x.email + " | date:" + x.date));
            System.out.println(count + " Done!");
            Thread.sleep(50);
        }
    }


}
