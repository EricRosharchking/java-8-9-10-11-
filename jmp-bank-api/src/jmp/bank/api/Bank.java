package jmp.bank.api;

import jmp.dto.BankCard;
import jmp.dto.BankCardType;
import jmp.dto.User;

import java.util.Arrays;
import java.util.Random;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);

    static String generateCardNumber() {
        final var stringBuilder = new StringBuilder();
        new Random().ints(0, 11)
                .limit(15)
                .forEach(stringBuilder::append);
        stringBuilder.append(getCheckSum(stringBuilder.toString()));
        return stringBuilder.toString();
    }

    /**
     * Luhn's algorithm to prevent mistyped number, not for security checks
     *
     * @param payload: the payload String
     * @return the CheckSum digit of the given String
     */
    private static int getCheckSum(String payload) {
        var checkSum = 0;
        for (var i = payload.length() - 1; i >= 0; i -= 2) {
            var evenDigit = (payload.charAt(i) - '0') * 2;
            checkSum += ((evenDigit / 10) + (evenDigit % 10));
            if (i - 1 >= 0) {
                checkSum += (payload.charAt(i - 1) - '0');
            }
        }
//        System.out.println(checkSum);
        return (10 - (checkSum % 10)) % 10;
    }
}
