package com.example.little.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.little.models.ProgressStepsModel;
import com.example.little.models.RiderDocsModel;

import java.util.ArrayList;

public class RiderDocsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<RiderDocsModel>> data= new MutableLiveData<>();
    private MutableLiveData<RiderDocsModel> riderDoc =new MutableLiveData<>();

    String[] docType={
            "Drivers Licence","National ID(front)","Good Conduct","PSV Badge"
    };

    String[] docDescription ={
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates"
    };

//    public RiderDocsData(){
//
//    }
    public LiveData<ArrayList<RiderDocsModel>> getData(String rider){
        int docsLength;
        if(rider.equals("driver")){
            docsLength=4;
        }else{
            docsLength=3;
        }

        ArrayList<RiderDocsModel> sampleData= new ArrayList<>();

        for(int i=0;i<docsLength;i++){
            RiderDocsModel current =new RiderDocsModel();

            current.docType=docType[i];
            current.docDescription=docDescription[i];
            sampleData.add(current);
        }
        data.setValue(sampleData);

        return data;
    }


    public  LiveData<RiderDocsModel> getDocData(int docPosition){
        RiderDocsModel current =new RiderDocsModel();
        current.docType=docType[docPosition];
        current.docDescription=docDescription[docPosition];
        riderDoc.setValue(current);
        return riderDoc;
    }
}
