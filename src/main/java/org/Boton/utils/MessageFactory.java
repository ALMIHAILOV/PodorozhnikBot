package org.Boton.utils;

import org.Boton.Constants;
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
}
