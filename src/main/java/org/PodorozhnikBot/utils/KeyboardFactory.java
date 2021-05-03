package org.PodorozhnikBot.utils;

import org.PodorozhnikBot.Constants;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardFactory {
    public static ReplyKeyboard choiceTypeTransport(long userTelegramId) {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(Constants.BUS);
        button1.setCallbackData(Constants.BUS);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(Constants.UNDERGROUND);
        button2.setCallbackData(Constants.UNDERGROUND);
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(Constants.MINIBUS_TAXI1);
        button3.setCallbackData(Constants.MINIBUS_TAXI1);
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText(Constants.MINIBUS_TAXI2);
        button4.setCallbackData(Constants.MINIBUS_TAXI2);

        rowInline1.add(button1);
        rowInline1.add(button2);
        rowInline2.add(button3);
        rowInline2.add(button4);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);

        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }

    public static ReplyKeyboard viewHistory(long userTelegramId) {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(Constants.TODAY);
        button1.setCallbackData(Constants.TODAY);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(Constants.WEEK);
        button2.setCallbackData(Constants.WEEK);
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(Constants.MONTH);
        button3.setCallbackData(Constants.MONTH);
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText(Constants.YEAR);
        button4.setCallbackData(Constants.YEAR);

        rowInline1.add(button1);
        rowInline1.add(button2);
        rowInline2.add(button3);
        rowInline2.add(button4);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);

        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }

    public static ReplyKeyboard settings(String textButton) {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(textButton);
        button1.setCallbackData(textButton);

        rowInline1.add(button1);

        rowsInline.add(rowInline1);

        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }
}

