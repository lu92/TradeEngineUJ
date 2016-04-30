package com.tradeengineproject.profilereader.repositories;

import com.tradeengineproject.profilereader.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM Customer u WHERE u.firstname = ?1 and u.lastname = ?2 and u.birthday = ?3")
    public Boolean existsByFirstameAndLastnameAndBirthday(String firstname, String lastname, LocalDate birthday);

}
