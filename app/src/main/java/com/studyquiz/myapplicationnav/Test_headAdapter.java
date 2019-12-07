package com.studyquiz.myapplicationnav;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Test_headAdapter extends RecyclerView.Adapter<Test_headAdapter.Test_headViewHolder> {
    //this context we use to inflate the layout
    private Context mCtx;

    // List to show test head

    private List<Test_head> Test_headList;

    //getting the test head list and context with constructor


    public Test_headAdapter(Context mCtx, List<Test_head> test_headList) {
        this.mCtx = mCtx;
        Test_headList = test_headList;
    }

    @NonNull
    @Override
    public Test_headViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.test,null);
        return new Test_headViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Test_headViewHolder holder, final int position) {
        Test_head test_head = Test_headList.get(position);

        //binding the data with view holder view
        holder.textViewTitle.setText(test_head.getTitle());
        holder.textViewdesc.setText(test_head.getDesc());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mCtx,MainActivity.class);
                intent.putExtra("paperNumber", String.valueOf(position +1));



                mCtx.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {

        return Test_headList.size();
    }

    public class Test_headViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle,textViewdesc;
        CardView cardView;
        public Test_headViewHolder(@NonNull View itemView) {

            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewdesc = itemView.findViewById(R.id.textViewdesc);
            cardView = itemView.findViewById(R.id.cardView);
        }

    }
}
