package com.stmlabs.denis.amazoncrawler.controllers;

import com.stmlabs.denis.amazoncrawler.database.repos.CollectedParametersRepository;
import com.stmlabs.denis.amazoncrawler.database.repos.MonitoringParametersRepository;
import com.stmlabs.denis.amazoncrawler.database.repos.ParserRepository;
import com.stmlabs.denis.amazoncrawler.database.repos.RegionRepository;
import com.stmlabs.denis.amazoncrawler.pojo.OutputJson;
import com.stmlabs.denis.amazoncrawler.services.AmazonCrawlerService;
import com.stmlabs.denis.amazoncrawler.utils.impl.ContentByDate;
import com.stmlabs.denis.amazoncrawler.utils.impl.ContentByParserId;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class CrawlerController {

    @Autowired
    private ParserRepository parserRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private MonitoringParametersRepository monitoringParametersRepository;

    @Autowired
    private CollectedParametersRepository collectedParametersRepository;

    @Autowired
    private AmazonCrawlerService amazonCrawlerService;

    @Autowired
    private BeanFactory beanFactory;

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

    @RequestMapping(value = "/getOutputJson", params = "date")
    public ResponseEntity<List<OutputJson>> getOutputJsonByDate(@RequestParam Date date) {
        return ResponseEntity.ok(amazonCrawlerService.getOutputJson(beanFactory.getBean(ContentByDate.class, date)));
    }

    @RequestMapping(value = "/getOutputJson", params = "parserId")
    public ResponseEntity<List<OutputJson>> getOutputJsonByParserID(@RequestParam int parserId) {
        return ResponseEntity.ok(amazonCrawlerService.getOutputJson(beanFactory.getBean(ContentByParserId.class, parserId)));
    }

}
