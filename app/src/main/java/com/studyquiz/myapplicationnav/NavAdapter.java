package com.studyquiz.myapplicationnav;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NavAdapter extends RecyclerView.Adapter<NavAdapter.NavQuestionViewHolder> {
    //this context we use to inflate the layout
    private Context mCtx;



    // List to show test head

    private List<NavQuestion> NavQuestionList;

    public NavAdapter(Context mCtx, List<NavQuestion> navQuestionList) {
        this.mCtx = mCtx;
        NavQuestionList = navQuestionList;
    }

    @NonNull
    @Override
    public NavQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.navquestion,null);
        return new NavQuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavQuestionViewHolder navQuestionViewHolder,final int position) {

        final NavQuestion navQuestion = NavQuestionList.get(position);
        navQuestion.setqNumber(String.valueOf(position+1));

        //binding the data with view holder view

        navQuestionViewHolder.navQuestionBtn.setText(navQuestion.getqNumber());

        navQuestionViewHolder.navQuestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mCtx, "Btn pressed"+position+1, Toast.LENGTH_SHORT).show();

                MainActivity.viewPager.setCurrentItem(position);
                MainActivity.drawer.closeDrawer(Gravity.RIGHT);

                //Toast.makeText("Btn pressed",MainActivity.class,Toast.LENGTH_SHORT).show();

                //Intent intent = new Intent(mCtx,MainActivity.class);
                //intent.putExtra("paperNumber", String.valueOf(position +1));



                //mCtx.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return NavQuestionList.size();
    }


    //getting the test head list and context with constructor


    public class NavQuestionViewHolder extends RecyclerView.ViewHolder {

        Button navQuestionBtn;
        public NavQuestionViewHolder(@NonNull View itemView) {
            super(itemView);

            navQuestionBtn = itemView.findViewById(R.id.nav_Question);
        }
    }

}
