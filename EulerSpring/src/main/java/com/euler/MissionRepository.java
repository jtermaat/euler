package com.euler;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.euler.entities.Mission;

public interface MissionRepository extends CrudRepository<Mission, Long> {

    List<Mission> findByMissionId(Integer missionId);
}
