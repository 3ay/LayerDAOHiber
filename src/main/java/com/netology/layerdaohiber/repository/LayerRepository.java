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
    @Query("select p from PersonDAO p where p.cityOfLiving =:city")
    List<PersonDAO> getPersonsByCityOfLiving(@Param("city") String city);
    @Query("select p from PersonDAO p where p.id.age < :age order by p.id.age asc")
    List<PersonDAO> getPersonsWithLessAge(@Param("age") int age);

    @Query("select p from PersonDAO p where p.id.name = :name and p.id.surname = :surname")
    Optional<PersonDAO> getPersonsByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
