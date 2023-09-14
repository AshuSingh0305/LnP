//Represents insurance policies

package com.VMABB.model;

public class Policy {
	int id;
	String name;
	String toi;
	public Policy(int i, String string, String string2) {
	    this.id=i;
	    this.toi=string;
	    this.name=string2;
	    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getToi() {
		return toi;
	}
	public void setToi(String toi) {
		this.toi = toi;
	}


	

}
