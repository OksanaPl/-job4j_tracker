package ru.job4j;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы, в которой можно
 * произвести следующие действия:
 * 1. Регистрировать (добавить) Пользователя.
 * 2. Удалять Пользователя из системы.
 * 3. Добавлять Пользователю банковский счет.
 * 4. Переводить деньги с одного счета на другой.
 * @author Oksana Plavinskaya.
 * @version 1.0.
 */
public class BankService {
    /**
     * Данные всех Пользователей с привязанными к ним счетами,
     * содержатся в HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает Пользователя, если такого Пользователя нет,
     * то добавляет его в систему
     * @param user Пользователь, которого добавляют в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает параметр Паспорт находит по нему Пользователя
     * и удаляет его.
     * @param passport находят по нему Пользователя.
     * @return если возвращаемый объект не null, то удаление произошлло.
     */
    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        if (users.containsKey(user)) {
            users.remove(user);
            return true;
        }
        return false;
    }

    /**
     * Метод добавляет новый счет к Пользователю, если его нет.
     * @param passport находит по этому параметру Пользователя
     * и список его счетов.
     * @param account новый счет, который добавляется в список счетов
     * Пользователя, если такого счета нет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = getAccounts(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод ищет Пользователя по номеру паспорта.
     * @param passport - номер паспорта по которому ищем Пользователя.
     * @return возвращает Пользователя, или null если Пользователь
     * не найден.
     */

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет Пользователя по реквизитам.
     * @param passport находит Пользователя по номеру паспорта
     * и получает список его счетов.
     * @param requisite ищет в списке счетов Пользователя нужный,
     * по реквизитам.
     * @return возвращает Пользователя или null, если Пользователь
     * не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счета на другой.
     * @param srcPassport паспорт Пользователя со счета которого переводят
     * деньги.
     * @param srcRequisite реквизиты счета Пользователя, с которого
     * переводят деньги.
     * @param destPassport паспорт Пользователя на счет которого переводят
     * деньги.
     * @param destRequisite реквизиты счета Пользователя, на который
     * переводят деньги.
     * @param amount количество денег на счету, с которого переводят
     * @return взвращает false, если счёт, с которого переводят деньги
     * не найден или на нем не хватает денег.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null || srcAccount.getBalance() < amount) {
            return false;
        }
        destAccount.setBalance(destAccount.getBalance() + amount);
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        return true;
    }

    /**
     * Метод возвращает список счетов Пользователя.
     * @param user Пользователь.
     * @return список счетов Пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
