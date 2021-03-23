package org.PodorozhnikBot.services;

import org.PodorozhnikBot.model.User;

import static org.PodorozhnikBot.Constants.*;

public class CreateUser{
    public static String createUser(String user_first_name, long user_telegram_id, long user_chat_id) {
        try {
            UserService userService = new UserService();
            if(userService.findUser(user_telegram_id)) {
                User user = new User(user_first_name, user_telegram_id, user_chat_id);
                userService.addUser(user);
                return USER_CREATED;
            }
            else {
                return USER_ALREADY_EXIST;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return EXCEPTION;
        }

    }
}
