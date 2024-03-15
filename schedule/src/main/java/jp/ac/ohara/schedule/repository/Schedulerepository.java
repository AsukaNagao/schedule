package jp.ac.ohara.schedule.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.schedule.model.Schedule;
 
@Repository
public interface Schedulerepository extends JpaRepository<Schedule, Long> {
	
}