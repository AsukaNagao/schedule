package jp.ac.ohara.schedule.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.schedule.model.Allschedule;
import jp.ac.ohara.schedule.repository.Allschedulerepository;
 
@Service
@Transactional
public class Allscheduleservice {
 
	@Autowired
	private Allschedulerepository repository;
 
	/**
	 * スケジュール帳一覧の取得
	 * @return List<Allschedule>
	 */
	public List<Allschedule> getScheduleList() {
	    List<Allschedule> entityList = this.repository.findAll();
	    return entityList;
	}

 
	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  Schedule
	 */
	public Allschedule get(@NonNull Long index) {
		Allschedule schedule = this.repository.findById(index).orElse(new Allschedule());
		return schedule;
	}
 
	/**
	 * スケジュール帳一覧の取得
	 * @param ScheduleBook schedule
	 */
	public void save(@NonNull Allschedule schedule) {
		this.repository.save(schedule);
	}
 
	/**
	 * スケジュール帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}


}