package org.Boton.services;


import org.Boton.Constants;

public class TopUpBalance {
    public static String topUpBalance(long userTelegramId, String value) {
        UserService userService = new UserService();
        System.out.println(value);
        userService.topUpBalance(Integer.parseInt(value.substring(5)), userTelegramId);
        System.out.println(Integer.parseInt(value.substring(5)));
        return Constants.TOP_UP_BALANCE + Integer.parseInt(value.substring(5));
    }
}
