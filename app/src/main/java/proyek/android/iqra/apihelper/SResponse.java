package proyek.android.iqra.apihelper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import proyek.android.iqra.model.AndroidVersion;

public class SResponse{
	private List<Data> data;

	public List<Data> getData(){
		return data;
	}

	public class Data{
		@Expose
		@SerializedName("id")
		private String id;
		@Expose
		@SerializedName("accuracy")
		private String accuracy;

		public String getId(){
			return id;
		}
		public  String getAccuracy(){
			return accuracy;
		}
	}

}