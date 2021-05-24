package proyek.android.iqra.apihelper;

import java.util.List;

public class CobaResponse{
	private List<SResponse.Data> android;

	public void setAndroid(List<SResponse.Data> android){
		this.android = android;
	}

	public List<SResponse.Data> getAndroid(){
		return android;
	}
}