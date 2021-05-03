package org.PodorozhnikBot.services;

import org.PodorozhnikBot.dao.UserDAOImp;
import org.PodorozhnikBot.model.User;

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

    public boolean isReminder(long userTelegramId) {return userDAOImp.isReminder(userTelegramId);}

    public void changeReminder(long userTelegramId, boolean command) {
        userDAOImp.changeReminder(userTelegramId, command);
    }

    public int viewCardNumber(long userTelegramId) {return userDAOImp.viewCardNumber(userTelegramId);}
}
