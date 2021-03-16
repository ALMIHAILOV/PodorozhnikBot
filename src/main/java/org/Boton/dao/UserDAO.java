package org.Boton.dao;

import org.Boton.model.User;

public interface UserDAO {

    User findByTelegramId(int user_telegram_id);

    void add(User user);

    void remove(User user);

    void update(User user);
}
