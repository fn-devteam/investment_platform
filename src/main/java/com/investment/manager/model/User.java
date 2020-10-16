package com.investment.manager.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String password;

	@OneToMany(mappedBy = "customer")
	private List<Investment> investment;

	@CreatedDate
	private Calendar createdAt;

	@Enumerated(EnumType.STRING)
	private Profile profile;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Account> accounts;

	@ElementCollection
	@CollectionTable(name = "user_emails", joinColumns = { @JoinColumn(name = "id") })
	@Column(name = "email")
	private List<String> emails;

	@ElementCollection
	@CollectionTable(name = "user_docs", joinColumns = { @JoinColumn(name = "id") })
	@Column(name = "documents")
	private List<String> documents;

	@ElementCollection
	@CollectionTable(name = "user_phones", joinColumns = { @JoinColumn(name = "id") })
	@Column(name = "phones")
	private List<Integer> phones;

}
