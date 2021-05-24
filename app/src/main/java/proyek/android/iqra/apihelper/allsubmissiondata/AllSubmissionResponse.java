package proyek.android.iqra.apihelper.allsubmissiondata;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllSubmissionResponse{
//	private ExampleModel[] data;
//
//	public ExampleModel[] getData(){
//		return data;
//	}

	@SerializedName("data")
	private ArrayList<DataItem> data;

	public void setData(ArrayList<DataItem> data){
		this.data = data;
	}

	public ArrayList<DataItem> getData(){
		return data;
	}
}