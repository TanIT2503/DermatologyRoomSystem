package com.cdio.dermatologroomsystem.dto;

import com.cdio.dermatologroomsystem.entity.Admin;

import java.util.ArrayList;
import java.util.List;

public class MedicalDto {
	private int medicalId;
	private String medicalName;
	private String medicalImage;
	private String medicalSymptom;

	public MedicalDto() {
	}

	public MedicalDto(int medicalId, String medicalName, String medicalImage, String medicalSymptom) {
		this.medicalId = medicalId;
		this.medicalName = medicalName;
		this.medicalImage = medicalImage;
		this.medicalSymptom = medicalSymptom;
	}

	public int getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}

	public String getMedicalName() {
		return medicalName;
	}

	public void setMedicalName(String medicalName) {
		this.medicalName = medicalName;
	}

	public String getMedicalImage() {
		return medicalImage;
	}

	public void setMedicalImage(String medicalImage) {
		this.medicalImage = medicalImage;
	}

	public String getMedicalSymptom() {
		return medicalSymptom;
	}

	public void setMedicalSymptom(String medicalSymptom) {
		this.medicalSymptom = medicalSymptom;
	}
}
