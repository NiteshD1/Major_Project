package com.studyquiz.myapplicationnav;

import android.media.audiofx.AudioEffect;

public class Test_head {

    private String title;
    private String Desc;

    public Test_head(String title, String desc) {
        this.title = title;
        Desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return Desc;
    }
}
