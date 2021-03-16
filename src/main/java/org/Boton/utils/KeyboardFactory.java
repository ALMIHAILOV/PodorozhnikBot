package org.Boton.utils;

import org.Boton.Constants;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardFactory {
    public static ReplyKeyboard withTodayTomorrowButtons() {
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        rowInline1.add(new InlineKeyboardButton().setText(Constants.UNDERGROUND).setCallbackData("Constants.UNDERGROUND"));
        rowInline1.add(new InlineKeyboardButton().setText(Constants.BUS).setCallbackData(Constants.BUS));
        rowsInline.add(rowInline1);
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        rowInline2.add(new InlineKeyboardButton().setText(Constants.MINIBUS_TAXI1).setCa)
        inlineKeyboard.setKeyboard(rowsInline);
        return inlineKeyboard;
    }
}
}
