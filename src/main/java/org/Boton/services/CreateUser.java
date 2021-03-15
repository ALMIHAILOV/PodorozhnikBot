package org.Boton.services;

import org.Boton.model.User;

import java.sql.SQLException;

import static org.Boton.Constants.EXCEPTION;
import static org.Boton.Constants.USER_CREATED;

public class CreateUser{
    public static String createUser(String user_first_name, long user_telegram_id, long user_chat_id) {
        UserService userService = new UserService();
        User user = new User(user_first_name, user_telegram_id, user_chat_id);

        userService.addUser(user);
        return USER_CREATED;
    }
}
