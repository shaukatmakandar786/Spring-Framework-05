package com.shaukat.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {

	private String sid;
	private String sname;
	private Address saddr;
	private List<String> squal;
	private Set<String> scourses;
	private Map<String,String> scourses_And_Faculty;
	private Properties scourse_And_Cost;
	
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Address getSaddr() {
		return saddr;
	}
	public void setSaddr(Address saddr) {
		this.saddr = saddr;
	}
	public List<String> getSqual() {
		return squal;
	}
	public void setSqual(List<String> squal) {
		this.squal = squal;
	}
	public Set<String> getScourses() {
		return scourses;
	}
	public void setScourses(Set<String> scourses) {
		this.scourses = scourses;
	}
	public Map<String, String> getScourses_And_Faculty() {
		return scourses_And_Faculty;
	}
	public void setScourses_And_Faculty(Map<String, String> scourses_And_Faculty) {
		this.scourses_And_Faculty = scourses_And_Faculty;
	}
	public Properties getScourse_And_Cost() {
		return scourse_And_Cost;
	}
	public void setScourse_And_Cost(Properties scourse_And_Cost) {
		this.scourse_And_Cost = scourse_And_Cost;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddr=" + saddr + ", squal=" + squal + ", scourses="
				+ scourses + ", scourses_And_Faculty=" + scourses_And_Faculty + ", scourse_And_Cost=" + scourse_And_Cost
				+ "]";
	}
	
	
}
