package org.Boton.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "statistic")
@DynamicUpdate(value = true)

public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long userTelegramId;
    private Date date;
    private int expense;
    private String transportType;

    public Statistic() {
    }

    public Statistic(long userTelegramId, Date date, int expense, String transportType) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
