package org.Boton.services;


import org.Boton.Constants;
import org.Boton.model.Statistic;

import java.util.Date;

public class TopUpBalance {
    public String topUpBalance(long userTelegramId, String value) {
        try{
            UserService userService = new UserService();
            StatisticService statisticService = new StatisticService();
            userService.changeBalance(Integer.parseInt(value.substring(5)), userTelegramId);
            Date date = new Date();
            Statistic statistic = new Statistic(userTelegramId, date.getTime(), Integer.parseInt(value.substring(5)), Constants.TOP_UP);
            statisticService.add(statistic);
            int currentBalance = userService.currentBalance(userTelegramId);
            return Constants.TOP_UP_BALANCE + Integer.parseInt(value.substring(5)) + " рублей. " + Constants.BALANCE +
                    currentBalance;
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.EXCEPTION;
        }

    }
}
