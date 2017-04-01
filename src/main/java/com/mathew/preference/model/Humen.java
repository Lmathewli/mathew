package com.mathew.preference.model;

import com.mathew.preference.dao.SleepAble;

public class Humen implements SleepAble {

    @Override
    public void sleep() {
        System.out.println("睡啦");
    }

}
