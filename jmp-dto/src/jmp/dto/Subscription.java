package jmp.dto;

import java.time.LocalDate;

public class Subscription {
    private String bankcard;
    private LocalDate startDate;

    public String getBankcard() {
        return bankcard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Subscription(String bankcard, LocalDate startDate) {
        this.bankcard = bankcard;
        this.startDate = startDate;
    }

    public Subscription() {
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "bankcard='" + bankcard + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
