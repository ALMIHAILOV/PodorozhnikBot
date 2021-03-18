package org.Boton.services;

import org.Boton.Constants;
import org.Boton.utils.MessageFactory;
import org.checkerframework.checker.units.qual.A;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.function.Consumer;

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

    public Ability addTrip() {
        return Ability.builder()
                .name("trip")
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

    public Ability topUpBalance() {
        return Ability.builder()
                .name("add")
                .info("Top up card's balance")
                .privacy(PUBLIC)
                .locality(ALL)
                .input(0)
                .action(ctx -> TopUpBalance.topUpBalance(ctx.user().getId(), ctx.update().getMessage().getReplyToMessage().getText()))
                .build();
    }

    public Reply reply() {
        Consumer<Update> action = upd -> messageFactory.replyToButtons(userIds().get(upd),upd.getMessage().getChatId(),upd.getCallbackQuery().getData());
        return Reply.of(action, Flag.CALLBACK_QUERY);
    }
}
