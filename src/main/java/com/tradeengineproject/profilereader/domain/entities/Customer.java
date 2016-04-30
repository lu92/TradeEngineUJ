package com.tradeengineproject.profilereader.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate birthday;

    @Embedded
    private Address address;

    @OneToOne @PrimaryKeyJoinColumn
    private CreditCard creditCard;

    private String username;
    private String password;
}
