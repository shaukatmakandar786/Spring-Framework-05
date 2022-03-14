package com.shaukat.beans;

import org.springframework.beans.factory.InitializingBean;

public class Course {

	private String cidString;
	private String cnameString;
	private int ccost;
	
	public Course(String cidString, String cnameString, int ccost) {
		super();
		this.cidString = cidString;
		this.cnameString = cnameString;
		this.ccost = ccost;
	}
	@Override
	public String toString() {
		return "Course [cidString=" + cidString + ", cnameString=" + cnameString + ", ccost=" + ccost + "]";
	}
}
