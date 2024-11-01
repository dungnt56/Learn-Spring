package com.sapo.edu.demo.print;

import com.sapo.edu.demo.model.Customer;

public interface Printer {
    void printCustoner(Customer customer);

    void printMessage(String message);
}
