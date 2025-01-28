package com.project.admin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ApprovalPojo {
	
	private Double interestRate;
	
	private Integer loanTenure;
	
	private String repaymentsSchedule;
	
	private String status;

}
