package org.Boton.services;

import org.Boton.dao.UserDAOImp;
import org.Boton.model.User;

public class UserService {
    private UserDAOImp userDAOImp = new UserDAOImp();

    public UserService() {
    }

    public boolean findUser(long user_telegram_id) {
        return userDAOImp.findByTelegramId(user_telegram_id);
    }

    public void addUser(User user) {
        userDAOImp.add(user);
    }

    public void removeUser(User user) {
        userDAOImp.remove(user);
    }

    public void updateUser(User user) {
        userDAOImp.update(user);
    }

    public void changeBalance(int topUpAmount, long userTelegramId) {
        userDAOImp.changeBalance(topUpAmount, userTelegramId);
    }

    public int currentBalance(long userTelegramId) {
        return userDAOImp.currentBalance(userTelegramId);
    }
}
