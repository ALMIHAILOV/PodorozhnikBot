package org.Boton.utils;

import org.Boton.Constants;
import org.Boton.services.ChangeBalance;
import org.Boton.services.ViewStatistics;
import org.telegram.abilitybots.api.sender.MessageSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MessageFactory {
    private final MessageSender sender;

    public MessageFactory(MessageSender sender) {
        this.sender = sender;
    }

    public void changeBalance (long userTelegramId, long chatId) {
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

    public void viewHistory(long userTelegramId, long chatId) {
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

    public void replyToButtons(long userTelegramId, long chatId, String buttonCommand) {
        switch (buttonCommand) {
            case Constants.BUS -> ChangeBalance.changeBalance(userTelegramId, chatId, Constants.BUS_COST);

            case Constants.UNDERGROUND -> ChangeBalance.changeBalance(userTelegramId, chatId, Constants.UNDERGROUND_COST);

            case Constants.MINIBUS_TAXI1 -> ChangeBalance.changeBalance(userTelegramId, chatId, Constants.MINIBUS_TAXI1_COAST);

            case Constants.MINIBUS_TAXI2 -> ChangeBalance.changeBalance(userTelegramId, chatId, Constants.MINIBUS_TAXI2_COAST);

            case Constants.TODAY -> ViewStatistics.viewStatistics(userTelegramId, chatId, Constants.TODAY);

            case Constants.WEEK -> ViewStatistics.viewStatistics(userTelegramId, chatId, Constants.WEEK);

            case Constants.MONTH -> ViewStatistics.viewStatistics(userTelegramId, chatId, Constants.MONTH);

            case Constants.YEAR -> ViewStatistics.viewStatistics(userTelegramId, chatId, Constants.YEAR);

        }
    }
}
