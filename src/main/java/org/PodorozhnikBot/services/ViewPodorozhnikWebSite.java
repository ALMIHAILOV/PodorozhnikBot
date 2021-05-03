package org.PodorozhnikBot.services;

import org.PodorozhnikBot.Constants;

public class ViewPodorozhnikWebSite {
    public String viewSite(long userTelegramId) {
        UserService userService = new UserService();
        int cardNumber = userService.viewCardNumber(userTelegramId);
        return Constants.VIEW_WEB_TXT + cardNumber;
    }
}
