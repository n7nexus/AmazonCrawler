package com.stmlabs.denis.amazoncrawler.database.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.stmlabs.denis.amazoncrawler.database.models.Region;

import java.util.List;


public interface RegionRepository extends CrudRepository<Region, Integer>{
    @Query(value = "select r.value from Region r")
    List<String> getRegionNames();
}
