package org.Boton.utils;

import org.Boton.Constants;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardFactory {
    public static ReplyKeyboard choiceTypeTransport() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(Constants.BUS);
        button1.setCallbackData("");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(Constants.UNDERGROUND);
        button2.setCallbackData("");
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(Constants.MINIBUS_TAXI1);
        button3.setCallbackData("");
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText(Constants.MINIBUS_TAXI2);
        button4.setCallbackData("");
        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText(Constants.TOP_UP_BALANCE);
        button5.setCallbackData("");

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
}

