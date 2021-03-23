package org.Boton.dao;

import org.Boton.model.Statistic;

import java.util.Date;
import java.util.List;

public interface StatisticsDAO {

    void add(Statistic statistic);

    List view(long userTelegramId, Date startDate, Date endDate);
}
