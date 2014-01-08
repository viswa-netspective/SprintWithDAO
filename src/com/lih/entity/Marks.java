package com.lih.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="marks")
public class Marks {
	
	public Marks(String name,String avg){
		this.name = name;
		this.avg = Double.parseDouble(avg);
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int studId;
	
	@Column(unique = true)
	String name;
	
	@Column(name="avg")
	double avg;
	
	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double d) {
		this.avg = d;
	}
	
	
}
