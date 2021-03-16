package org.Boton.services;

import org.Boton.Constants;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;


import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class Bot extends AbilityBot {
    public Bot() {
        this(Constants.BOT_TOKEN, Constants.BOT_USERNAME);
    }

    private Bot(String botToken, String botUsername) {
        super(botToken, botUsername);
    }

    @Override
    public long creatorId() {
        return Constants.CREATOR_ID;
    }

    public Ability start() {
        return Ability.builder()
                .name("start")
                .info("Create new user")
                .privacy(PUBLIC)
                .locality(ALL)
                .input(0)
                .action(ctx -> silent.sendMd(CreateUser.createUser(ctx.user().getFirstName(), ctx.user().getId(), ctx.chatId()), ctx.chatId()))
                .build();
    }

}
