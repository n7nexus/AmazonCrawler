package com.stmlabs.denis.amazoncrawler.database.repos;

import com.stmlabs.denis.amazoncrawler.pojo.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import com.stmlabs.denis.amazoncrawler.database.models.CollectedParameters;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface CollectedParametersRepository extends JpaRepository<CollectedParameters, Integer> {

    @Query(value = "select new com.stmlabs.denis.amazoncrawler.pojo.Content(m.id, m.pid, m.value, m.monitoringParameter.name) from CollectedParameters m where m.parser.date = :date and m.region.value = :region")
    public List<Content> getContentByDateAndRegion(@Param("date") Date date, @Param("region") String region);

    @Query(value = "select new com.stmlabs.denis.amazoncrawler.pojo.Content(m.id, m.pid, m.value, m.monitoringParameter.name) from CollectedParameters m where m.parser.id = :parserId and m.region.value = :region")
    public List<Content> getContentByParserIdAndRegion(@Param("parserId") Integer parserId, @Param("region") String region);
}
