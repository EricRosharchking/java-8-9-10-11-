package jmp.service.api;

import jmp.dto.BankCard;
import jmp.dto.Subscription;
import jmp.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Service {
    void subscribe(BankCard bankcard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String number);
    List<User> getAllUser();
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate);

    // use Collectors.toUnmodifiableList() if applicable
    default double getAverageUsersAge() {
        return getAllUser()
                .stream()
                .map(User::getBirthday)
                .mapToLong(birthDay -> birthDay.until(LocalDate.now(), ChronoUnit.YEARS))
                .average()
                .orElse(-1D);
    }

    static boolean isPayableUser(User user) {
        return user != null && LocalDate.now().minusYears(18).isAfter(user.getBirthday());
    }
}
