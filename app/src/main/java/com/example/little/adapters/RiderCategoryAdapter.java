package com.example.little.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.little.views.OtpActivity;
import com.example.little.R;
import com.example.little.models.RiderCategoryModel;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.Telephony.Mms.Part.TEXT;

public class RiderCategoryAdapter extends RecyclerView.Adapter<RiderCategoryAdapter.MyViewHolder> {

    private Context context;

    private ArrayList<RiderCategoryModel> data;

    private LayoutInflater inflater;

    private int previousPosition = 0;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SHARED_PREFS2 = "sharedPrefs";
    public static final String RIDER = "rider";
    public static final String HAS_CAR = "car";
    public static final String COUNTRY = "";


    public RiderCategoryAdapter(Context context, ArrayList<RiderCategoryModel> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_rider, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    public void setRiderCategoryList(ArrayList<RiderCategoryModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {

        myViewHolder.title.setText(data.get(position).title);
        myViewHolder.description.setText(data.get(position).description);
        myViewHolder.img.setImageResource(data.get(position).img);

        previousPosition = position;

        final int currentPosition = position;
        final RiderCategoryModel infoData = data.get(position);


        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rider_category;

                if(position == 0){
                    rider_category="driver";
                }else if(position == 1){
                    rider_category="bodaboda";
                }else if(position == 2){
                    rider_category="logistics";
                }else{
                    rider_category="";
                }

                SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(RIDER,rider_category);
                editor.apply();
                Log.i("rider",sharedPreferences.getString(RIDER, ""));

                Toast.makeText(context, "Rider: " + sharedPreferences.getString(TEXT, ""), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, OtpActivity.class);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;
        ImageView img;
        ImageView imgNext;
        CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);

            cardView=(CardView) itemView.findViewById(R.id.cardViewRoot);
            title = (TextView) itemView.findViewById(R.id.txtTitle);
            description = (TextView) itemView.findViewById(R.id.txtDescription);
            img = (ImageView) itemView.findViewById(R.id.imgRider);
            imgNext = (ImageView) itemView.findViewById(R.id.imgNext);



        }
    }


}
