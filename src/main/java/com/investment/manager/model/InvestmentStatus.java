package com.investment.manager.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class InvestmentStatus {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    protected Long id;
		
		@Enumerated(EnumType.STRING)
		Status status;
		
		@ManyToOne
		List<Investment> investments;
		
		@OneToMany
		List<User> user;
		
		@UpdateTimestamp
		@Temporal(TemporalType.TIMESTAMP)
		private Calendar changeDate;

}
