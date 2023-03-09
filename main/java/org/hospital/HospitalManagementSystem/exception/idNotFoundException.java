package org.hospital.HospitalManagementSystem.exception;

public class idNotFoundException extends RuntimeException {
	public String getMessage() {
		return "ID is Invalid";
	}
}
