package org.Boton.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "users")
@DynamicUpdate(value = true)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user_first_name;
    private long user_telegram_id;
    private long user_chat_id;
    private int available_means;

    public User(String user_first_name, long user_telegram_id, long user_chat_id) {
        this.user_first_name = user_first_name;
        this.user_telegram_id = user_telegram_id;
        this.user_chat_id = user_chat_id;
    }

    public User(long user_telegram_id, int available_means) {
        this.user_telegram_id = user_telegram_id;
        this.available_means = available_means;
    }

    public User() {

    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public long getUser_telegram_id() {
        return user_telegram_id;
    }

    public void setUser_telegram_id(int user_telegram_id) {
        this.user_telegram_id = user_telegram_id;
    }

    public long getUser_chat_id() {
        return user_chat_id;
    }

    public void setUser_chat_id(long user_chat_id) {
        this.user_chat_id = user_chat_id;
    }

    public int getAvailable_means() {
        return available_means;
    }

    public void setAvailable_means(int available_means) {
        this.available_means = available_means;
    }
}
