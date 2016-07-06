package com.euler.entities;

import java.io.Serializable;

public class Mission implements Serializable {
	
	private static final long serialVersionUID = 8482887602612781250L;
	
	private Integer missionId;
	private Integer seed;
	
	public Integer getMissionId() {
		return missionId;
	}
	
	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}
	
	public Integer getSeed() {
		return seed;
	}
	public void setSeed(Integer seed) {
		this.seed = seed;
	}
	
}


