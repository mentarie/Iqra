package proyek.android.iqra.model;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TesBacaModel{
	private int Id, numberColor, imageSource, rekamHasil, rekamLine, rekamIcon;
	private String number, bacaanId, userId;

	public TesBacaModel(Integer Id, String number, Integer numberColor, Integer imageSource, Integer rekamHasil, Integer rekamLine, Integer rekamIcon, String bacaanId, String userId){
		this.Id = Id;
		this.number = number;
		this.numberColor = numberColor;
		this.imageSource = imageSource;
		this.rekamHasil = rekamHasil;
		this.rekamLine = rekamLine;
		this.rekamIcon = rekamIcon;
		this.bacaanId = bacaanId;
		this.userId = userId;
	}

	public Integer getId(){
		return Id;
	}
	public Integer getRekamLine(){
		return rekamLine;
	}
	public String getNumber(){
		return number;
	}
	public Integer getNumberColor(){
		return numberColor;
	}
	public Integer getRekamHasil(){
		return rekamHasil;
	}
	public Integer getRekamIcon(){
		return rekamIcon;
	}
	public Integer getImageSource(){
		return imageSource;
	}
	public String getBacaanId(){
		return bacaanId;
	}
	public String getUserId(){
		return userId;
	}
}
