package com.cdio.dermatologroomsystem.dto;

import com.cdio.dermatologroomsystem.entity.Admin;

import java.util.ArrayList;
import java.util.List;

public class MedicalDto {
	private int medicalId;
	private String medicalName;
	private String medicalImage;
	private String medicalSymptom;
	List<Admin> AdminList = new ArrayList<>();
}
