package org.PodorozhnikBot.services;

import org.PodorozhnikBot.dao.StatisticsDAOImp;
import org.PodorozhnikBot.model.Statistic;

import java.util.Date;
import java.util.List;

public class StatisticService {
    private StatisticsDAOImp statisticsDAOImp = new StatisticsDAOImp();

    public StatisticService() {

    }

    public void add(Statistic statistic) {
        statisticsDAOImp.add(statistic);
    }

    public List<Statistic> view(long userTelegramId, Date startDate, Date endDate) {
        return statisticsDAOImp.view(userTelegramId,startDate,endDate);
    }
}
