package jp.ac.ohara.schedule.model;
 
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

	@Data
	@Entity
	@Table(name = "schedule")
	
	public class Schedule {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private long id;
		
		@Column(length = 8, nullable = false)
		private String number;
 
		@Column(nullable = false)
		private LocalDateTime datetime;
 
		@Column(length = 64,nullable = false)
		private String title;

		@Column(length = 128, nullable = true)
		private String detail;
		
}