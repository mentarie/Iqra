package proyek.android.iqra.apihelper.submission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubmissionModel {
	@SerializedName("id_iqra_refer")
	@Expose
	private Integer idIqraRefer;
	private String createdAt;
	private Double accuracy;
	private String actualResult;
	private Integer iD;
	private Integer id;
	private Object deletedAt;
	private String updatedAt;
	private Integer idUserRefer;
	private String expectedResult;

	public SubmissionModel(Integer id, Integer idIqraRefer, Integer idUserRefer, Double accuracy, String actualResult, String expectedResult){
		this.id = id;
		this.idUserRefer = idUserRefer;
		this.idIqraRefer = idIqraRefer;
		this.accuracy = accuracy;
		this.actualResult = actualResult;
		this.expectedResult = expectedResult;
	}

	public void setIdIqraRefer(int idIqraRefer){
		this.idIqraRefer = idIqraRefer;
	}

	public int getIdIqraRefer(){
		return idIqraRefer;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setAccuracy(double accuracy){
		this.accuracy = accuracy;
	}

	public double getAccuracy(){
		return accuracy;
	}

	public void setActualResult(String actualResult){
		this.actualResult = actualResult;
	}

	public String getActualResult(){
		return actualResult;
	}

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setIdUserRefer(int idUserRefer){
		this.idUserRefer = idUserRefer;
	}

	public int getIdUserRefer(){
		return idUserRefer;
	}

	public void setExpectedResult(String expectedResult){
		this.expectedResult = expectedResult;
	}

	public String getExpectedResult(){
		return expectedResult;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"id_iqra_refer = '" + idIqraRefer + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			",accuracy = '" + accuracy + '\'' + 
			",actual_result = '" + actualResult + '\'' + 
			",iD = '" + iD + '\'' + 
			",id = '" + id + '\'' + 
			",deletedAt = '" + deletedAt + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			",id_user_refer = '" + idUserRefer + '\'' + 
			",expected_result = '" + expectedResult + '\'' + 
			"}";
		}
}