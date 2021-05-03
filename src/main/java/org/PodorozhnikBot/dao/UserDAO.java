package org.PodorozhnikBot.dao;

import org.PodorozhnikBot.model.User;

public interface UserDAO {

    boolean findByTelegramId(long userTelegramId);

    void add(User user);

    void remove(User user);

    void update(User user);

    void changeBalance(int topUpAmount, long userTelegramId);

    int currentBalance(long userTelegramId);

    boolean isReminder(long userTelegramId);

    void changeReminder(long userTelegramId, boolean command);

    int viewCardNumber(long userTelegramId);
}
