package org.PodorozhnikBot.services;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class GetDateTest {

    @AfterEach
    void tearDown() {
    }

    @Test
    void getEndDate() {
        Date date = new Date();
        GetDate getDate = new GetDate();
        Date testDate = getDate.getEndDate();

        Assert.assertEquals(testDate, date);

    }

    @Test
    void getStartDate() {

    }
}