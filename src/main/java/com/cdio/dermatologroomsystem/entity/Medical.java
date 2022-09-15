package com.cdio.dermatologroomsystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MEDICAL")
public class Medical {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int medicalId;
	private String medicalName;
	private String medicalImage;
	private String medicalSymptom;

	@OneToMany(mappedBy = "adminId")
	List<Admin> AdminList = new ArrayList<>();

	public Medical() {
	}

	public Medical(String medicalId , String medicalName , String medicalImage , String medicalSymptom , List<Admin> adminList) {
		this.medicalId = medicalId;
		this.medicalName = medicalName;
		this.medicalImage = medicalImage;
		this.medicalSymptom = Medical.this.medicalSymptom;
		AdminList = adminList;
	}

	public String getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(String medicalId) {
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

	public List<Admin> getAdminList() {
		return AdminList;
	}

	public void setAdminList(List<Admin> adminList) {
		AdminList = adminList;
	}
}
