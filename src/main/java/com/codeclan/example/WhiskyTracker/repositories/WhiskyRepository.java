package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskysByYear(int age);

    @Query("select w from Whisky w inner join w.distillery.whiskies whiskies " +
            "where w.distillery.region = ?1 and whiskies.age = ?2")
    List<Whisky> findByDistillery_RegionAndDistillery_Whiskies_Age(int age);

}
