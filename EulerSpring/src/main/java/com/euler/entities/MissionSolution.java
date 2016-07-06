package com.euler.entities;

import java.io.Serializable;

public class MissionSolution implements Serializable {
	
	private static final long serialVersionUID = -8174109530184224078L;
	
	private Mission mission;
	private Integer answer;
	
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	
	public String toString() {
		return "seed: " + mission.getSeed() + ", missionId: " + mission.getMissionId() + ", answer: " + answer;
	}
}
