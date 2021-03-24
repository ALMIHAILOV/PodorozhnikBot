package org.PodorozhnikBot;

public final class Constants {
    //Telegram bot credentials
    //public static final String BOT_USERNAME = "PodorozhnikTelegramBot";
    //public static final String BOT_TOKEN = "1614431601:AAFMB7ptBOLowGEdZ7rx5BGWHW9rEtTuDNI";
    //public static final int CREATOR_ID = 352081004;

    public static final String USER_CREATED = "Регистрация завершена";
    public static final String USER_ALREADY_EXIST = "Пользователь уже зарегистрирован";
    public static final String EXCEPTION = "Ошибка при выполнении запроса";

    public static final String UNDERGROUND = "Метро";
    public static final String BUS = "Наземный транспорт";
    public static final String MINIBUS_TAXI1 = "Маршрутка 45 руб";
    public static final String MINIBUS_TAXI2 = "Маршрутка 50 руб";
    public static final String TOP_UP = "Пополнение баланса";
    public static final String TOP_UP_BALANCE = "Баланс карты пополнен на ";

    public static final String TODAY = "Сегодня";
    public static final String WEEK = "Неделя";
    public static final String MONTH = "Месяц";
    public static final String YEAR = "Год";

    public static final String CHOOSE_CHANGE = "Выберите вид транспорта, на котором была совершена поездка," +
            " или пополнение баланса карты:";
    public static final String CHOOSE_HISTORY = "Выберите, за какое время показать статистику:";

    public static final int BUS_COST = -36;
    public static final int UNDERGROUND_COST = -41;
    public static final int MINIBUS_TAXI1_COAST = -45;
    public static final int MINIBUS_TAXI2_COAST = -50;

    public static final String BALANCE = "Текущий баланс: ";

    public static final String EXPENSE_FOR_PERIOD = "Расход за выбранный период: ";
    public static final String BY_BUS = "На наземном транспорте: ";
    public static final String BY_UNDERGROUND = "На метро: ";
    public static final String BY_MINIBUS_TAXI1 = "На маршрутке за 45 руб: ";
    public static final String BY_MINIBUS_TAXI2 = "На маршрутке за 50 руб: ";

}
