package com.example.little.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.little.R;
import com.example.little.models.ProgressStepsModel;
import com.example.little.models.RiderCategoryModel;

import java.util.ArrayList;

public class RiderCategoryViewModel extends ViewModel {

    public static LiveData<ArrayList<RiderCategoryModel>> getData(){
        MutableLiveData<ArrayList<RiderCategoryModel>> data =new MutableLiveData<>();

        int[] img = {
                R.drawable.cab,
                R.drawable.boda,
                R.drawable.logistics,
        };

        String[] title={
                "Driver","Bodaboda","Logistics"
        };

        String[] description ={
                "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam",
                "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam",
                "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam",
        };

        ArrayList<RiderCategoryModel> sampleData= new ArrayList<>();

        for(int i=0;i<title.length;i++){
            RiderCategoryModel current =new RiderCategoryModel();
            current.img=img[i];
            current.title=title[i];
            current.description=description[i];
            sampleData.add(current);
        }
        data.setValue(sampleData);
        return data;
    }
}
