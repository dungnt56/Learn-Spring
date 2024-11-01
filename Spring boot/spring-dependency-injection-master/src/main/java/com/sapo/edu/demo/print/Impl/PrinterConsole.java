package com.sapo.edu.demo.print.Impl;

import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.print.Printer;

public class PrinterConsole implements Printer {
    @Override
    public void printCustoner(Customer customer) {
        System.out.println("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
