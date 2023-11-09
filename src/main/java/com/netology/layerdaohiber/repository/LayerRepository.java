package com.netology.layerdaohiber.repository;

import com.netology.layerdaohiber.dao.PersonDAO;
import com.netology.layerdaohiber.dao.PersonKeyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LayerRepository extends JpaRepository<PersonDAO, PersonKeyId> {
    List<PersonDAO> findAllByCityOfLiving(String city);
    List<PersonDAO> findById_AgeLessThanOrderById_AgeAsc(int age);

    Optional<PersonDAO> findById_NameAndId_Surname(String name, String surname);

}
