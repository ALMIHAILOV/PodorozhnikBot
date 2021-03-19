package org.Boton.dao;

import org.Boton.model.User;

public interface UserDAO {

    boolean findByTelegramId(long userTelegramId);

    void add(User user);

    void remove(User user);

    void update(User user);

    void changeBalance(int topUpAmount, long userTelegramId);

    int currentBalance(long userTelegramId);
}
