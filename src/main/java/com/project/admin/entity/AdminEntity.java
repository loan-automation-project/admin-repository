package com.project.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "admin_table")
public class AdminEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	private Long adminId;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name="admin_Status")
	private String adminStatus;
	
	@Column(name="approved_loans")
	private int approvedLoans;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public int getApprovedLoans() {
		return approvedLoans;
	}

	public void setApprovedLoans(int approvedLoans) {
		this.approvedLoans = approvedLoans;
	}
	
	
	
	
}
