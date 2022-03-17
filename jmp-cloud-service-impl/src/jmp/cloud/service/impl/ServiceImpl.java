package jmp.cloud.service.impl;

import jmp.dto.BankCard;
import jmp.dto.Subscription;
import jmp.dto.User;
import jmp.service.api.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServiceImpl implements Service {

    final List<Subscription> allSubscriptionList = new ArrayList<>();
    final List<User> allUserList = new ArrayList<>();

    //TODO: Create simple DB(MySQL) and integrate the service logic with repository logic
    /**
     * Create new Subscription and save into DB if card not already subscribed
     * renew subscription if already subscribed
     * @param bankcard: BankCard to create subscription on
     */
    @Override
    public void subscribe(BankCard bankcard) {
        Subscription subscription = new Subscription(bankcard.getNumber(), LocalDate.now());
        //subscriptionRepo.saveOrUpdate(subscription);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String number) {
//        return Optional.ofNullable(subscriptionRepo.getSubByCardNumber(number));
        return allSubscriptionList.stream()
                .filter(sub -> sub.getBankcard().equals(number))
                .findFirst();
    }

    //TODO: implement this method after DB creation
    @Override
    public List<User> getAllUser() {
        allUserList.addAll(new ArrayList<>());
//        return userRepo.getAllUser();
        return allUserList;
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate) {
        return allSubscriptionList.stream()
                .filter(predicate)
                .collect(Collectors.toUnmodifiableList());
    }
}
