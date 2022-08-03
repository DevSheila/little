package com.example.little.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.little.models.VehicleDocsModel;

import java.util.ArrayList;

public class VehicleDocsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<VehicleDocsModel> >data= new MutableLiveData<>();
    private MutableLiveData<VehicleDocsModel> vehicleDoc =new MutableLiveData<>();


    String[] driver_docType= {
            "PSV Insurance","NTSA Inspection","report","Logbook","Photo of the car(Front)","Photo of the car(Back)"
    };

    String[] bodaboda_docType= {
            "PSV Insurance","Photo of the bike(Front)","Photo of the bike(Back)"

    };
    String[] logistics_docType={
            "Commercial Insurance","Logbook","Photo of the vehicle(front)","Photo of the vehicle(Back)"
    };
    String[] driver_docDescription ={
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates"
    };
    String[] bodaboda_docDescription ={
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates"
    };

    String[] logistics_docDescription ={
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates",
            "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates"
    };


    public LiveData<ArrayList<VehicleDocsModel>> getData(String rider){
        ArrayList<VehicleDocsModel> sampleData= new ArrayList<>();
        if(rider.equals("driver")){
            for(int i=0;i<driver_docType.length;i++){
                VehicleDocsModel current =new VehicleDocsModel();

                current.docType=driver_docType[i];
                current.docDescription="Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates";
                sampleData.add(current);

            }
            data.setValue(sampleData);
        } else if(rider.equals("bodaboda")){
            for(int i=0;i<bodaboda_docType.length;i++){
                VehicleDocsModel current =new VehicleDocsModel();

                current.docType=bodaboda_docType[i];
                current.docDescription="Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates";
                sampleData.add(current);

            }
            data.setValue(sampleData);
        } else if(rider.equals("logistics")){
            for(int i=0;i<logistics_docType.length;i++){
                VehicleDocsModel current =new VehicleDocsModel();

                current.docType=logistics_docType[i];
                current.docDescription="Lorem ipsum dolor sit, amet consectetur adipisicing elit. Optio veniam repudiandae sint doloribus reprehenderit fugit, temporibus voluptates";
                sampleData.add(current);

            }
            data.setValue(sampleData);
        }else{

        }

        return data;
    }
    public  LiveData<VehicleDocsModel> getDocData(String rider,int docPosition){


        VehicleDocsModel current =new VehicleDocsModel();
        if(rider.equals("driver")){
            current.docType=driver_docType[docPosition];
            current.docDescription=driver_docDescription[docPosition];

            vehicleDoc.setValue(current);

        }else if(rider.equals("bodaboda")){
            current.docType=bodaboda_docType[docPosition];
            current.docDescription=bodaboda_docDescription[docPosition];
            vehicleDoc.setValue(current);


        }else if(rider.equals("logistics")) {
            current.docType=logistics_docType[docPosition];
            current.docDescription=logistics_docDescription[docPosition];
            vehicleDoc.setValue(current);

        }else{

        }
        return vehicleDoc;
    }
}
