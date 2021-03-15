package org.Boton.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_telegram_id")
    private User user;
    private Date date;
    private int expense;

    public Statistic(User user, Date date, int expense) {
        this.user = user;
        this.date = date;
        this.expense = expense;
    }

    public Statistic() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
