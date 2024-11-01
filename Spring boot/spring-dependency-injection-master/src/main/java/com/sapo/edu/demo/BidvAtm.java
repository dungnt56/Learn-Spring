package com.sapo.edu.demo;

import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.print.Impl.PrinterFile;
import com.sapo.edu.demo.print.Printer;
import com.sapo.edu.demo.print.Impl.PrinterConsole;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public class BidvAtm implements Atm {
    @Value("${spring.initialMoney}")
    private BigDecimal moneyAtm;

    private Printer printer = new PrinterConsole();

    @Override
    public void withDraw(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) < 0) {
            printer.printMessage("Amount is invalid");
            return;
        }
        if (customer.getBalance().compareTo(amount) < 0) {
            printer.printMessage("Insufficient Balance");
            return;
        }
        if (amount.compareTo(moneyAtm) >= 0) {
            printer.printMessage("ATM is out of money");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.subtract(amount));
        moneyAtm = moneyAtm.subtract(amount);
    }

    @Override
    public void printCurrentMoney() {
        printer.printMessage("Current ATM money is " + moneyAtm.toString());
    }

    @Override
    public void deposit(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) <= 0) {
            printer.printMessage("Amount is invalid");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.add(amount));
        moneyAtm = moneyAtm.add(amount);
    }

    @Override
    public void displayCustomerInfo(Customer customer) {
        printer.printCustoner(customer);
    }
}
