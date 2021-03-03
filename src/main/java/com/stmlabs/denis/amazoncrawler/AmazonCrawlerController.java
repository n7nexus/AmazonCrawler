package com.stmlabs.denis.amazoncrawler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stmlabs.denis.amazoncrawler.models.CollectedParameters;
import com.stmlabs.denis.amazoncrawler.models.MonitoringParameters;
import com.stmlabs.denis.amazoncrawler.models.Parser;
import com.stmlabs.denis.amazoncrawler.models.Region;
import com.stmlabs.denis.amazoncrawler.repos.CollectedParametersRepository;
import com.stmlabs.denis.amazoncrawler.repos.MonitoringParametersRepository;
import com.stmlabs.denis.amazoncrawler.repos.ParserRepository;
import com.stmlabs.denis.amazoncrawler.repos.RegionRepository;
import com.stmlabs.denis.amazoncrawler.utils.ContentQueryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AmazonCrawlerController {

    @Autowired
    private ParserRepository parserRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private MonitoringParametersRepository monitoringParametersRepository;

    @Autowired
    private CollectedParametersRepository collectedParametersRepository;

    @GetMapping("/startParser")
    public String startParser() {

        return "Parser is started";
    }

//    @GetMapping("/allParsers")
//    public @ResponseBody
//    Iterable<Parser> allParsers() {
//
//        return parserRepository.findAll();
//    }
//
//    @GetMapping("/allCollectedParameters")
//    public @ResponseBody Iterable<CollectedParameters> allCollectedParameters() {
//
//        return collectedParametersRepository.findAll();
//    }
//
//    @GetMapping("/allRegions")
//    public @ResponseBody Iterable<Region> allRegion() {
//
//        return regionRepository.findAll();
//    }
//
//    @GetMapping("/allMonitoringParameters")
//    public @ResponseBody Iterable<MonitoringParameters> allMonitoringParameters() {
//
//        return monitoringParametersRepository.findAll();
//    }
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/getOutputJson", params = "date")
    public String getOutputJsonByDate(@RequestParam String date) {

        List<OutputJson> outputJsons = new ArrayList<>();
        Session session = sessionFactory.openSession();
        Query<String> regionQuery = session.createQuery("select r.value from Region r");
        List<String> regions = regionQuery.list();

        Date d = Date.valueOf(date);
        for(String region : regions) {
            Query<Content> query = session.createQuery("select new com.stmlabs.denis.amazoncrawler.Content(m.id, m.pid, m.value, m.monitoringParameter.name)"
                    + " from CollectedParameters m where m.parser.date = :date and m.region.value = :region");
            query.setParameter("date", d);
            query.setParameter("region", region);

            List<Content> contents = query.list();

            outputJsons.add(new OutputJson(region, contents));
        }

        final StringWriter sw = new StringWriter();
        final ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(sw, outputJsons);
        } catch (IOException e) {

        }
        System.out.println(sw.toString());
        return sw.toString();//"Output Json by Parser ID: " + parserId;
    }

    @RequestMapping(value = "/getOutputJson", params = "parserId")
    public String getOutputJsonByParserID(@RequestParam int parserId) {
        List<OutputJson> outputJsons = new ArrayList<>();
        Session session = sessionFactory.openSession();
        Query<String> regionQuery = session.createQuery("select r.value from Region r");
        List<String> regions = regionQuery.list();

        for(String region : regions) {
            Query<Content> query = session.createQuery("select new com.stmlabs.denis.amazoncrawler.Content(m.id, m.pid, m.value, m.monitoringParameter.name)"
                    + " from CollectedParameters m where m.parser.id = :parserId and m.region.value = :region");
            query.setParameter("parserId", parserId);
            query.setParameter("region", region);

            List<Content> contents = query.list();

//            List<Content> contents = ContentQueryBuilder.getContentQueryByParserIdAndRegion(parserId, region).list();

            outputJsons.add(new OutputJson(region, contents));
        }

        final StringWriter sw = new StringWriter();
        final ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(sw, outputJsons);
        } catch (IOException e) {

        }
        System.out.println(sw.toString());
        return sw.toString();//"Output Json by Parser ID: " + parserId;
    }

}
