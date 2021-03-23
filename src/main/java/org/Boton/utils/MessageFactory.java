package org.Boton.utils;

import org.Boton.Constants;
import org.Boton.model.Statistic;
import org.Boton.services.GetDate;
import org.Boton.services.StatisticService;
import org.Boton.services.UserService;
import org.telegram.abilitybots.api.sender.MessageSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Date;
import java.util.List;

public class MessageFactory {
    private final MessageSender sender;

    public MessageFactory(MessageSender sender) {
        this.sender = sender;
    }

    public void viewChangeBalanceKeyboard(long userTelegramId, long chatId) {
        try {
            SendMessage message = new SendMessage();
            message.setText(Constants.CHOOSE_CHANGE);
            message.setChatId(Long.toString(chatId));
            message.setReplyMarkup(KeyboardFactory.choiceTypeTransport(userTelegramId));
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void viewHistoryKeyboard(long userTelegramId, long chatId) {
        try {
            SendMessage message = new SendMessage();
            message.setText(Constants.CHOOSE_HISTORY);
            message.setChatId(Long.toString(chatId));
            message.setReplyMarkup(KeyboardFactory.viewHistory(userTelegramId));
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void viewBalance(int currentBalance, long chatId) {
        try {
            SendMessage message = new SendMessage();
            message.setText(Constants.BALANCE + currentBalance + "рублей");
            message.setChatId(Long.toString(chatId));
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void replyToButtons(long userTelegramId, long chatId, String buttonCommand) {
        switch (buttonCommand) {
            case Constants.BUS -> reducingBalance(userTelegramId, chatId, Constants.BUS_COST, Constants.BUS);

            case Constants.UNDERGROUND -> reducingBalance(userTelegramId, chatId, Constants.UNDERGROUND_COST, Constants.UNDERGROUND);

            case Constants.MINIBUS_TAXI1 -> reducingBalance(userTelegramId, chatId, Constants.MINIBUS_TAXI1_COAST, Constants.MINIBUS_TAXI1);

            case Constants.MINIBUS_TAXI2 -> reducingBalance(userTelegramId, chatId, Constants.MINIBUS_TAXI2_COAST, Constants.MINIBUS_TAXI2);

            case Constants.TODAY -> getStatistics(userTelegramId, chatId, Constants.TODAY);

            case Constants.WEEK -> getStatistics(userTelegramId, chatId, Constants.WEEK);

            case Constants.MONTH -> getStatistics(userTelegramId, chatId, Constants.MONTH);

            case Constants.YEAR -> getStatistics(userTelegramId, chatId, Constants.YEAR);
        }
    }

    private void reducingBalance(long userTelegramId, long chatId, int value, String transportType) {
        UserService userService = new UserService();
        StatisticService statisticService = new StatisticService();
        Date date = new Date();
        Statistic statistic = new Statistic(userTelegramId, date.getTime(), value, transportType);
        statisticService.add(statistic);
        userService.changeBalance(value, userTelegramId);
        int currentBalance = userService.currentBalance(userTelegramId);
        viewBalance(currentBalance, chatId);
    }

    private void getStatistics(long userTelegramId, long chatId, String period) {
        List<Statistic> statisticList;

        GetDate getDate = new GetDate();
        StatisticService statisticService = new StatisticService();

        Date startDate = getDate.getStartDate(period);
        Date endDate = getDate.getEndDate();
        statisticList = statisticService.view(userTelegramId, startDate, endDate);
        viewStatistics(chatId, statisticList);
    }

    private void viewStatistics(long chatId, List<Statistic> statisticList) {
        int expense = 0;
        int byBus = 0;
        int byUnderground = 0;
        int byTaxi1 = 0;
        int byTaxi2 = 0;

        for (Statistic statistic : statisticList) {
            expense = expense + statistic.getExpense();
            switch (statistic.getTransportType()) {
                case Constants.BUS -> byBus = byBus + 1;
                case Constants.UNDERGROUND -> byUnderground = byUnderground + 1;
                case Constants.MINIBUS_TAXI1 -> byTaxi1 = byTaxi1 + 1;
                case Constants.MINIBUS_TAXI2 -> byTaxi2 = byTaxi2 + 1;
            }
        }
        try {
            SendMessage message = new SendMessage();
            message.setText(Constants.EXPENSE_FOR_PERIOD + expense + "\n" +
                            Constants.BY_BUS + byBus + "\n" + Constants.BY_UNDERGROUND + byUnderground + "\n" +
                            Constants.BY_MINIBUS_TAXI1 + byTaxi1 + "\n" + Constants.BY_MINIBUS_TAXI2 + byTaxi2 + "\n");
            message.setChatId(Long.toString(chatId));
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }




}
