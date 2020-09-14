package com.investment.manager.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Account extends BaseModel {

    @ManyToOne
    private Bank bank;

    private String agency;

    private String digit;

    private String accountNumber;

    private String accountDigit;

    @ManyToOne
    private User user;
}
