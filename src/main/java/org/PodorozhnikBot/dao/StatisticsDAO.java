package org.PodorozhnikBot.dao;

import org.PodorozhnikBot.model.Statistic;

import java.util.Date;
import java.util.List;

public interface StatisticsDAO {

    void add(Statistic statistic);

    List<Statistic> view(long userTelegramId, Date startDate, Date endDate);
}
