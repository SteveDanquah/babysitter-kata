package com.bbs.entities;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class BabySitter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id; 
	
	public String Name; 
	public int startTime;
	public int bedTime; 
	public int endTime;
	public int nightlyCharge;
	
	
	public BabySitter() {
		
	}
	
	
	public BabySitter(String name, int startTime, int bedTime, int endTime, int nightlyCharge) {
		super();
		Name = name;
		this.startTime = startTime;
		this.bedTime = bedTime;
		this.endTime = endTime;
		this.nightlyCharge = nightlyCharge;
	}


	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getNightlyCharge() {
		return nightlyCharge;
	}

	public void setNightlyCharge(int nightlyCharge) {
		this.nightlyCharge = nightlyCharge;
	}

	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getBedTime() {
		return bedTime;
	}
	public void setBedTime(int bedTime) {
		this.bedTime = bedTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	} 
	
	
	
}
