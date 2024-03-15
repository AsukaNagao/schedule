package jp.ac.ohara.schedule.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.schedule.model.User;
import jp.ac.ohara.schedule.repository.Userrepository;
 
@Service
@Transactional
public class Userservice {
 
	@Autowired
	private Userrepository repository;
 
	/**
	 * スケジュール帳一覧の取得
	 * @return List<User>
	 */
	public List<User> getScheduleList() {
	    List<User> entityList = this.repository.findAll();
	    return entityList;
	}

 
	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  Schedule
	 */
	public User get(@NonNull Long index) {
		User schedule = this.repository.findById(index).orElse(new User());
		return schedule;
	}
 
	/**
	 * スケジュール帳一覧の取得
	 * @param ScheduleBook schedule
	 */
	public void save(@NonNull User schedule) {
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