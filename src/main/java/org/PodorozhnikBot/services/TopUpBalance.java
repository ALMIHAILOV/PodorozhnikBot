package org.PodorozhnikBot.services;


import org.PodorozhnikBot.Constants;

public class TopUpBalance {
    public String topUpBalance(long userTelegramId, String value) {
        try{
            UserService userService = new UserService();
            userService.changeBalance(Integer.parseInt(value.substring(5)), userTelegramId);
            int currentBalance = userService.currentBalance(userTelegramId);
            return Constants.TOP_UP_BALANCE + Integer.parseInt(value.substring(5)) + " рублей. " + Constants.BALANCE +
                    currentBalance;
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.EXCEPTION;
        }

    }
}
