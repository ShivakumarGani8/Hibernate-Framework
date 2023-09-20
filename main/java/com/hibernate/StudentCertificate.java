package com.hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class StudentCertificate {
	private String certificateId;
	private String certificateName;
	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	public String getcertificateName() {
		return certificateName;
	}
	public void setcertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	
	public StudentCertificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentCertificate(String certificateId, String certificateName) {
		super();
		this.certificateId = certificateId;
		this.certificateName = certificateName;
	}
	
	
}
