package org.Boton.dao;

import org.Boton.model.Statistic;

import java.util.Date;

public interface StatisticsDAO {

    void add(Statistic statistic);

    String view(long userTelegramId, Date startDate, Date endDate);
}
