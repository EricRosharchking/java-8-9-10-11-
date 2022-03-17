package jmp.bank.app;

import jmp.bank.api.Bank;
import jmp.cloud.bank.impl.BankImpl;
import jmp.cloud.service.impl.ServiceImpl;
import jmp.dto.*;
import jmp.service.api.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class BankApp {
    private final Bank bank;
    private final Service service;

    public static void main(String[] args) {
        var app = new BankApp();
        var userList = app.getAllUser();
        var user = userList.get(new Random().nextInt(userList.size()));
        System.out.println(Service.isPayableUser(user));
        System.out.println(app.getAverageUserAge());
        var type = new Random().nextInt(2) > 0 ? BankCardType.CREDIT : BankCardType.DEBIT;
        var bankCard = app.createBankCard(user, type);
        app.subscribeBankCard(bankCard);
        var subscriptionOptional = app.getSubscriptionByBankCardNumber(bankCard.getNumber());
        subscriptionOptional.orElseThrow(
                () -> new CloudServiceException("No Subscription Found for card [" + bankCard.getNumber() + "]"));
    }

    public BankApp() {
        bank = new BankImpl();
        service = new ServiceImpl();
    }

    public void subscribeBankCard(BankCard bankCard) {
        service.subscribe(bankCard);
    }

    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return bank.createBankCard(user, bankCardType);
    }

    public List<User> getAllUser() {
        return service.getAllUser();
    }

    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return service.getSubscriptionByBankCardNumber(bankCardNumber);
    }

    public double getAverageUserAge() {
        return service.getAverageUsersAge();
    }
}
