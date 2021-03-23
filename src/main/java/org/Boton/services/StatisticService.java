package org.Boton.services;

import org.Boton.dao.StatisticsDAOImp;
import org.Boton.model.Statistic;

import java.util.Date;
import java.util.List;

public class StatisticService {
    private StatisticsDAOImp statisticsDAOImp = new StatisticsDAOImp();

    public StatisticService() {

    }

    public void add(Statistic statistic) {
        statisticsDAOImp.add(statistic);
    }

    public List view(long userTelegramId, Date startDate, Date endDate) {
        return statisticsDAOImp.view(userTelegramId,startDate,endDate);
    }
}
