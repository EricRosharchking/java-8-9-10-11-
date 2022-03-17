package jmp.cloud.bank.impl;

import jmp.bank.api.Bank;
import jmp.dto.*;


public class BankImpl implements Bank {

    //TODO: 1.implement it with method reference
    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return bankCardType ==
                BankCardType.CREDIT ? new CreditBankCard(Bank.generateCardNumber(), user)
                : bankCardType == BankCardType.DEBIT ? new DebitBankCard(Bank.generateCardNumber(), user)
                : new DebitBankCard(Bank.generateCardNumber(), user);
    }
}
