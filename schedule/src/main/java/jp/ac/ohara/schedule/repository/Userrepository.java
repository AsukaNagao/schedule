package jp.ac.ohara.schedule.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.schedule.model.User;
 
@Repository
public interface Userrepository extends JpaRepository<User, Long> {
}