//Represents insurance policies

package com.VMABB.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Policy {
	int client_id;
	
	@Id
	private int proposalId;
	private String policyHoldername;
	private String policyType;
	private String status;
	private int policyId;
	
	public Policy(int i, String string, String string2) {
	    this.client_id=i;
	    this.policyType=string;
	    this.policyHoldername=string2;
	    }
	
	public Policy(int proposalId, String policyHoldername, String policyType, String status, int policyId) {
		super();
		this.proposalId = proposalId;
		this.policyHoldername = policyHoldername;
		this.policyType = policyType;
		this.status = status;
		this.policyId = policyId;
	}
	
	public int getProposalId() {
		return proposalId;
	}
	public int getclient_Id() {
		return client_id;
	}
	
	
	
	
	
	public void setclient_Id(int client_id) {
		this.client_id = client_id;	
	}

	
	
	
	
	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}
	
	
	
	public String getPolicyHoldername() {
		return policyHoldername;
	}
	public void setPolicyHoldername(String policyHoldername) {
		this.policyHoldername = policyHoldername;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPolicyId() {
		return policyId;
	}


	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}


	

}
