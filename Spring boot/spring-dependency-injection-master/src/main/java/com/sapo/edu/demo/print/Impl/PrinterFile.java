package com.sapo.edu.demo.print.Impl;

import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.print.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrinterFile implements Printer {
    Logger logger = LoggerFactory.getLogger(PrinterFile.class);
    @Override
    public void printCustoner(Customer customer) {
        logger.trace("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {
        logger.info(message);
    }
}
