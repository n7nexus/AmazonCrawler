package com.stmlabs.denis.amazoncrawler.database.repos;

import org.springframework.data.repository.CrudRepository;
import com.stmlabs.denis.amazoncrawler.database.models.MonitoringParameters;

public interface MonitoringParametersRepository extends CrudRepository<MonitoringParameters, Integer> {
}
