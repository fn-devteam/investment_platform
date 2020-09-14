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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DynamicUpdate
public class User extends BaseModel {

    private String name;

    private String password;

    @CreatedDate
    private Calendar createdAt;

    @Enumerated(EnumType.STRING)
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Account> accounts;

    @ElementCollection
    @CollectionTable(name = "user_emails", joinColumns = {
            @JoinColumn(name = "id")
    })
    @Column(name = "email")
    private List<String> emails;
}
