package jp.ac.ohara.schedule.model;
 
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

	@Data
	@Entity
	@Table(name = "users")
	
	public class User{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private long id;
		
		@Column(length = 8, nullable = true)
		private String number;
 
		@Column(length = 64, nullable = false)
		private String name;
 
		@Column(length = 64,nullable = false)
		private String password;
		
		@Column(nullable = false)
		private Date birthday;
		
		@Column(length = 32, nullable = true)
		private String phone;
	
		}
