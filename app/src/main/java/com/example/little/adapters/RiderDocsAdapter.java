package com.example.little.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.little.R;
import com.example.little.views.SampleActivity;
import com.example.little.models.RiderDocsModel;

import java.io.Serializable;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;

public class RiderDocsAdapter extends RecyclerView.Adapter<RiderDocsAdapter.MyViewHolder> implements Serializable {
    private Context context;

    private ArrayList<RiderDocsModel> data;


    private LayoutInflater inflater;

    private int previousPosition = 0;
    public static final String DOCTYPE = "text";

    public static final int RIDER_DOC_POS= 0;

    public RiderDocsAdapter(Context context, ArrayList<RiderDocsModel> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void setRiderDocList(ArrayList<RiderDocsModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public RiderDocsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_rider_docs, parent, false);

        RiderDocsAdapter.MyViewHolder holder = new RiderDocsAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RiderDocsAdapter.MyViewHolder myViewHolder, final int position) {

        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myViewHolder.title.setText(data.get(position).docType);


        previousPosition = position;

        final int currentPosition = position;
        final RiderDocsModel infoData = data.get(position);
        myViewHolder.riderDocsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Document:"+ position, Toast.LENGTH_SHORT).show();

                SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(String.valueOf(RIDER_DOC_POS),position);
                editor.apply();


                Intent intent2 = new Intent(context, SampleActivity.class);

                intent2.putExtra("position",position);
                context.startActivity(intent2);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView imageView;

        LinearLayout riderDocsLayout;


        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.txtName);
            imageView = (ImageView) itemView.findViewById(R.id.imgProfile);

            riderDocsLayout = (LinearLayout) itemView.findViewById(R.id.riderDocsLayout);



        }
    }


}
