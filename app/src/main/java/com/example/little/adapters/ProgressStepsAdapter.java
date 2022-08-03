package com.example.little.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.little.views.MainActivity;
import com.example.little.R;
import com.example.little.models.ProgressStepsModel;

import java.util.ArrayList;

public class ProgressStepsAdapter extends RecyclerView.Adapter<ProgressStepsAdapter.MyViewHolder>{

    private Context context;

    private ArrayList<ProgressStepsModel> data;

    private LayoutInflater inflater;

    private int previousPosition = 0;


    public ProgressStepsAdapter(Context context, ArrayList<ProgressStepsModel> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }


    public void setProgresStepsList(ArrayList<ProgressStepsModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ProgressStepsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_progress_steps, parent, false);

        ProgressStepsAdapter.MyViewHolder holder = new ProgressStepsAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProgressStepsAdapter.MyViewHolder myViewHolder, final int position) {

        String status=data.get(position).status;
        if(status.equals("")){

        }else if (status.equals("complete")){
            myViewHolder.stepsView.setColorFilter(context.getResources().getColor(R.color.primary));

            myViewHolder.status.setTextColor(context.getResources().getColor(R.color.primary));
        }else if(status.equals("pending")){
            myViewHolder.stepsView.setColorFilter(context.getResources().getColor(R.color.orange));

            myViewHolder.status.setTextColor(context.getResources().getColor(R.color.orange));

        }else if(status.equals("approved")){
            myViewHolder.stepsView.setColorFilter(context.getResources().getColor(R.color.green));



            myViewHolder.status.setTextColor(context.getResources().getColor(R.color.green));

        }else{
            status="Get started";
        }
        myViewHolder.title.setText(data.get(position).title);
        myViewHolder.description.setText(data.get(position).description);
        myViewHolder.status.setText(status);
        myViewHolder.img.setImageResource(data.get(position).img);


        previousPosition = position;

        final int currentPosition = position;
        final ProgressStepsModel infoData = data.get(position);


        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        ImageView imgNext;
        ImageView stepsView;

        CardView cardView;
        View line;

        TextView title;
        TextView description;
        TextView status;




        public MyViewHolder(View itemView) {
            super(itemView);
            line=(View) itemView.findViewById(R.id.line);
            cardView=(CardView) itemView.findViewById(R.id.cardViewRoot);
            title = (TextView) itemView.findViewById(R.id.txtTitle);
            description = (TextView) itemView.findViewById(R.id.txtDescription);
            status = (TextView) itemView.findViewById(R.id.txtStatus);
            img = (ImageView) itemView.findViewById(R.id.imgRider);
            imgNext = (ImageView) itemView.findViewById(R.id.imgNext);
            stepsView = (ImageView) itemView.findViewById(R.id.steps_indicator);


        }
    }


}
