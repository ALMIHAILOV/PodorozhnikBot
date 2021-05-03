package org.PodorozhnikBot.services;

import org.PodorozhnikBot.Constants;
import org.PodorozhnikBot.utils.MessageFactory;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.Map;
import java.util.TimerTask;
import java.util.function.Consumer;
import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;


public class Bot extends AbilityBot {
    private static final Map<String, String> getenv = System.getenv();

    public Bot() {
        this(getenv.get("BOT_TOKEN"), getenv.get("BOT_USERNAME"));
    }

    private Bot(String botToken, String botUsername) {
        super(botToken, botUsername);
    }

    MessageFactory messageFactory = new MessageFactory(sender);

    @Override
    public long creatorId() {
        return Long.parseLong(getenv.get("CREATOR_ID"));
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
                .action(ctx -> messageFactory.viewChangeBalanceKeyboard(ctx.user().getId(), ctx.chatId()))
                .build();
    }

    public Ability viewHistory() {
        return Ability.builder()
                .name("history")
                .info("View history data")
                .privacy(PUBLIC)
                .locality(ALL)
                .input(0)
                .action(ctx -> messageFactory.viewHistoryKeyboard(ctx.user().getId(), ctx.chatId()))
                .build();
    }

    public Ability topUpBalance() {
        TopUpBalance topUpBalance = new TopUpBalance();
        return Ability.builder()
                .name("add")
                .info("Top up card's balance")
                .privacy(PUBLIC)
                .locality(ALL)
                .input(0)
                .action(ctx -> silent.sendMd(topUpBalance.topUpBalance(ctx.user().getId(), ctx.update().getMessage().getText()), ctx.chatId()))
                .build();
    }

    public Ability viewCurrentBalance() {
        UserService userService = new UserService();

        return Ability.builder()
                .name("balance")
                .info("View current balance")
                .privacy(PUBLIC)
                .locality(ALL)
                .input(0)
                .action(ctx -> messageFactory.viewBalance(userService.currentBalance(ctx.user().getId()),ctx.chatId()))
                .build();
    }

    public Ability settings() {
        return Ability.builder()
                .name("settings")
                .info("Settings")
                .privacy(PUBLIC)
                .locality(ALL)
                .input(0)
                .action(ctx -> messageFactory.settings(ctx.user().getId(), ctx.chatId()))
                .build();
    }

    public Ability viewWebSite() {
        ViewPodorozhnikWebSite viewPodorozhnikWebSite = new ViewPodorozhnikWebSite();
        return Ability.builder()
                .name("site")
                .info("view Web Site")
                .privacy(PUBLIC)
                .locality(ALL)
                .input(0)
                .action(ctx -> silent.sendMd(viewPodorozhnikWebSite.viewSite(ctx.user().getId()), ctx.chatId()))
                .build();
    }

    public Reply reply() {
        Consumer<Update> action = upd -> messageFactory.replyToButtons(upd.getCallbackQuery().getMessage().getChatId(),upd.getCallbackQuery().getMessage().getChatId(),upd.getCallbackQuery().getData());
        return Reply.of(action, Flag.CALLBACK_QUERY);
    }


}
