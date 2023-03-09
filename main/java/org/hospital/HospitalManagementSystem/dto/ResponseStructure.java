package org.hospital.HospitalManagementSystem.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T body;
	private String message;
	private int code;

}
