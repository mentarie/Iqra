package proyek.android.iqra.model;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TesBacaModel{
	private Integer idIqraRefer, numberColor, imageSource, rekamLine, rekamIcon, idUserRefer;
	private Double accuracy;
	private String number, bacaanId;

	public TesBacaModel(Integer idIqraRefer, String number, Integer numberColor, Integer imageSource, Double accuracy, Integer rekamLine, Integer rekamIcon, String bacaanId, Integer idUserRefer){
		this.idIqraRefer = idIqraRefer;
		this.number = number;
		this.numberColor = numberColor;
		this.imageSource = imageSource;
		this.accuracy = accuracy;
		this.rekamLine = rekamLine;
		this.rekamIcon = rekamIcon;
		this.bacaanId = bacaanId;
		this.idUserRefer = idUserRefer;
	}

	public Integer getId(){
		return idIqraRefer;
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
	public Double getRekamHasil(){
		return accuracy;
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
	public Integer getUserId(){
		return idUserRefer;
	}

	public void setRekamHasil(double hasil){
		this.accuracy = hasil;
	}
}
