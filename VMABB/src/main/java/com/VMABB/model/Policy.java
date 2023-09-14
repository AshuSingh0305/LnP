//Represents insurance policies

package com.VMABB.model;

public class Policy {
	int client_id;
	String policyHoldername;
	String policyType;
	public Policy(int i, String string, String string2) {
	    this.client_id=i;
	    this.policyType=string;
	    this.policyHoldername=string2;
	    }
	public int getclient_Id() {
		return client_id;
	}
	public void setclient_Id(int id) {
		this.client_id = id;
		
	}
	public String getpolicyHoldername() {
		return policyHoldername;
	}
	public void setpolicyHoldername(String policyHoldername) {
		this.policyHoldername = policyHoldername;
	}
	public String getpolicyType() {
		return policyType;
	}
	public void setpolicyType(String policyType) {
		this.policyType = policyType;
	}


	

}
