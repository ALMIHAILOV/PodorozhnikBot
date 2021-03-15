package org.Boton.dao;

import org.Boton.model.User;

public interface UserDAO {

    public User findByTelegramId(int user_telegram_id);

    public void add(User user);

    public void remove(User user);

    public void update(User user);
}
