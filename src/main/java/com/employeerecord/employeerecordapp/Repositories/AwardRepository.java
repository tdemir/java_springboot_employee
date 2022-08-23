package com.employeerecord.employeerecordapp.Repositories;

import com.employeerecord.employeerecordapp.Entities.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<Award,Long> {
    @Query("Select a from Award a where a.yearVal = :year and a.monthVal = :month")
    List<Award> findByYearAndMonth(@Param("year") int year, @Param("month") int month);
}
