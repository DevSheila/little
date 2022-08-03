package com.example.little.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.little.R;
import com.example.little.models.ProgressStepsModel;

import java.util.ArrayList;
import java.util.List;

public class ProgressStepsViewModel extends ViewModel {


    private MutableLiveData<ArrayList<ProgressStepsModel>> data;

    public LiveData<ArrayList<ProgressStepsModel>> getData(){
        data= new MutableLiveData<>();
        int[] img = {
                R.drawable.cab,
                R.drawable.boda,
                R.drawable.logistics,
                R.drawable.cab,
        };

        String[] title={
                "Step1","Step2","Step3","Ste4"
        };

        String[] description ={
                "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam",
                "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam",
                "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam",
                "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam",

        };
        String[] status={
                "complete","pending","approved"," "
        };

        ArrayList<ProgressStepsModel> sampleData= new ArrayList<>();

        for(int i=0;i<title.length;i++){
            ProgressStepsModel current =new ProgressStepsModel();
            current.img=img[i];
            current.title=title[i];
            current.status=status[i];
            current.description=description[i];
            sampleData.add(current);
        }
        data.setValue(sampleData);
        return data;
    }
}
