package org.PodorozhnikBot.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "statistic")
@DynamicUpdate(value = true)

public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long userTelegramId;
    private long date;
    private int expense;
    private String transportType;

    public Statistic() {
    }

    public Statistic(long userTelegramId, long date, int expense, String transportType) {
        this.userTelegramId = userTelegramId;
        this.date = date;
        this.expense = expense;
        this.transportType = transportType;
    }

    public long getUserTelegramId() {
        return userTelegramId;
    }

    public void setUserTelegramId(long userTelegramId) {
        this.userTelegramId = userTelegramId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }
}
