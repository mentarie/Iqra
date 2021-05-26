package proyek.android.iqra.apihelper.allsubmissiondata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import proyek.android.iqra.apihelper.submission.SubmissionModel;

public class AllSubmissionResponse{
	private List<SubmissionModel> data;

	public List<SubmissionModel> getData(){
		return data;
	}

	public class Data{
		@Expose
		@SerializedName("id_iqra_refer")
		private String id_iqra_refer;
		@Expose
		@SerializedName("id_user_refer")
		private String id_user_refer;
		@Expose
		@SerializedName("accuracy")
		private String accuracy;

		public  String getAccuracy(){
			return accuracy;
		}

		public String getId_user_refer() {
			return id_user_refer;
		}

		public String getId_iqra_refer() {
			return id_iqra_refer;
		}
	}
}