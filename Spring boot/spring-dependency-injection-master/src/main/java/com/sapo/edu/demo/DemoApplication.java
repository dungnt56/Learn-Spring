package com.sapo.edu.demo;

import com.sapo.edu.demo.model.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Account: ");
//        String accountNo = scanner.next();
//        System.out.print("Pin: ");
//        String pin = scanner.next();
//        System.out.println("Balance: ");
//        BigDecimal balance = scanner.nextBigDecimal();

        Customer customer = new Customer("ABC", "1234", new BigDecimal(5000000));
//        Customer customer = new Customer(accountNo, pin, balance);

        //Demo function
        Atm bidvAtm = new BidvAtm();
        bidvAtm.printCurrentMoney();
        bidvAtm.displayCustomerInfo(customer);
        bidvAtm.withDraw(customer, new BigDecimal(200000));
        bidvAtm.printCurrentMoney();
        bidvAtm.withDraw(customer, new BigDecimal(10000000));
        bidvAtm.printCurrentMoney();
        bidvAtm.deposit(customer,new BigDecimal(1000000));
        bidvAtm.printCurrentMoney();
    }
}
