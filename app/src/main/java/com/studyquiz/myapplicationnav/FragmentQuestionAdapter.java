package com.studyquiz.myapplicationnav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentQuestionAdapter extends FragmentStatePagerAdapter {
    public FragmentQuestionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        QuestionFragment questionFragment = new QuestionFragment();
        Bundle bundle = new Bundle();
        position = position+1;
        bundle.putString("message","Question Number"+position);
        questionFragment.setArguments(bundle);

        return questionFragment;
    }

    @Override
    public int getCount() {
        return 25;
    }
}
