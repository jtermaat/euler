package com.euler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.euler.entities.Mission;
import com.euler.entities.MissionSolution;

@RestController
public class MissionReceivingController {

    @RequestMapping(value="/messages", method=RequestMethod.POST)
    public ResponseEntity<MissionSolution> missionHandler(@RequestBody Mission mission) {
    	
    	if (isValidMissionId(mission.getMissionId())) {
    		Integer answer = EulerEvaluator.getEulerSolution(mission.getSeed());
    		MissionSolution solution = new MissionSolution();
    		solution.setMission(mission);
    		solution.setAnswer(answer);
    		return new ResponseEntity<MissionSolution>(solution, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<MissionSolution>(HttpStatus.CONFLICT);
    	}
    }

	private boolean isValidMissionId(Integer missionId) {
		return true;
		// TODO: Should this be a database check?  Ask Dicky.
	}

}