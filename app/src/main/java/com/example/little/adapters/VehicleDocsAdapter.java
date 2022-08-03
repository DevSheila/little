package com.example.little.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.little.R;
import com.example.little.views.SampleVehicleActivity;
import com.example.little.models.VehicleDocsModel;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.little.adapters.RiderCategoryAdapter.RIDER;
import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;

public class VehicleDocsAdapter extends RecyclerView.Adapter<VehicleDocsAdapter.MyViewHolder>{

    private Context context;

    private ArrayList<VehicleDocsModel> data;

    private LayoutInflater inflater;

    private int previousPosition = 0;

    public VehicleDocsAdapter(Context context, ArrayList<VehicleDocsModel> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void setVehicleDocList(ArrayList<VehicleDocsModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @Override
    public VehicleDocsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_vehicle_docs, parent, false);

        VehicleDocsAdapter.MyViewHolder holder = new VehicleDocsAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(VehicleDocsAdapter.MyViewHolder myViewHolder, final int position) {

        myViewHolder.title.setText(data.get(position).docType);

        previousPosition = position;

        final int currentPosition = position;

        myViewHolder.vehicleDocsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Document:"+ position, Toast.LENGTH_SHORT).show();

                SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                String rider=sharedPreferences.getString(RIDER, "");
                Log.i("rider",sharedPreferences.getString(RIDER, ""));

//                Intent intent2 = new Intent(context, SampleActivity.class);
//                VehicleDocsData vehicleDocs= new VehicleDocsData();
//
//                intent2.putExtra("docType",vehicleDocs.getDocData(rider,position).docType);
//                intent2.putExtra("docDescription",vehicleDocs.getDocData(rider,position).docDescription);
//                context.startActivity(intent2);
                Intent intent2 = new Intent(context, SampleVehicleActivity.class);

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
        LinearLayout vehicleDocsLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            vehicleDocsLayout=(LinearLayout) itemView.findViewById(R.id.vehicleDocsLayout);
            title = (TextView) itemView.findViewById(R.id.txtName);


        }
    }


}
