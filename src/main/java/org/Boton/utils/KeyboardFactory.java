package org.Boton.utils;

import org.Boton.Constants;
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
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(Constants.BUS);
        button1.setCallbackData("1");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(Constants.UNDERGROUND);
        button2.setCallbackData("2");
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(Constants.MINIBUS_TAXI1);
        button3.setCallbackData("3");
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText(Constants.MINIBUS_TAXI2);
        button4.setCallbackData("4");
        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText(Constants.TOP_UP_BALANCE);
        button5.setCallbackData("5");

        rowInline1.add(button1);
        rowInline1.add(button2);
        rowInline2.add(button3);
        rowInline2.add(button4);
        rowInline3.add(button5);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);

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
        button1.setCallbackData("1");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(Constants.WEEK);
        button2.setCallbackData("2");
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(Constants.MONTH);
        button3.setCallbackData("3");
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText(Constants.YEAR);
        button4.setCallbackData("4");

        rowInline1.add(button1);
        rowInline1.add(button2);
        rowInline2.add(button3);
        rowInline2.add(button4);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);

        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }
}

