package org.Boton.services;

import org.Boton.Constants;
import org.Boton.utils.MessageFactory;
import org.hibernate.sql.Update;
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

    MessageFactory messageFactory = new MessageFactory(sender);

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

    public Ability changeBalance() {
        return Ability.builder()
                .name("add")
                .info("Changes the balance on the card")
                .privacy(PUBLIC)
                .locality(ALL)
                .input(0)
                .action(ctx -> messageFactory.changeBalance(ctx.user().getId(), ctx.chatId()))
                .build();
    }

    public Ability viewHistory() {
        return Ability.builder()
                .name("history")
                .info("View history data")
                .privacy(PUBLIC)
                .locality(ALL)
                .input(0)
                .action(ctx -> messageFactory.viewHistory(ctx.user().getId(), ctx.chatId()))
                .build();
    }


}
