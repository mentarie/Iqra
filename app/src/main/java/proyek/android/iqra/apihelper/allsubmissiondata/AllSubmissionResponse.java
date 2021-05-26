package proyek.android.iqra.apihelper.allsubmissiondata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import proyek.android.iqra.apihelper.submission.SubmissionModel;

public class AllSubmissionResponse{

	@SerializedName("data")
	List<Data> dataList;

	public List<Data> getDataList(){
		return  dataList;
	}

	public class Data{
		@Expose
		@SerializedName("id_iqra_refer")
		private Integer id_iqra_refer;
		@Expose
		@SerializedName("id_user_refer")
		private Integer id_user_refer;
		@Expose
		@SerializedName("accuracy")
		private Double accuracy;

		public  Double getAccuracy(){
			if(accuracy == null) return 0.0;
			return accuracy;
		}

		public Integer getId_user_refer() {
			if(id_user_refer == null) return 0;
			return id_user_refer;
		}

		public Integer getId_iqra_refer() {
			if(accuracy == null) return 0;
			return id_iqra_refer;
		}
	}
}