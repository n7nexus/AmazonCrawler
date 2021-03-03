package com.stmlabs.denis.amazoncrawler.utils;

import com.stmlabs.denis.amazoncrawler.Content;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

public class ContentQueryBuilder {
    @Autowired
    private static SessionFactory sessionFactory;

    public static Query<Content> getContentQueryByParserIdAndRegion(int parserId, String region) {
        Session session = sessionFactory.openSession();

        Query<Content> query = session.createQuery("select new com.stmlabs.denis.amazoncrawler.Content(m.id, m.pid, m.value, m.monitoringParameter.name)"
                + " from CollectedParameters m where m.parser.id = :parserId and m.region.value = :region");
        query.setParameter("parserId", parserId);
        query.setParameter("region", region);

        return query;
    }

    public static Query<Content> getContentQueryByDateAndRegion(Date date, String region) {
        Session session = sessionFactory.openSession();

        Query<Content> query = session.createQuery("select new com.stmlabs.denis.amazoncrawler.Content(m.id, m.pid, m.value, m.monitoringParameter.name)"
                + " from CollectedParameters m where m.parser.date = :date and m.region.value = :region");
        query.setParameter("date", date);
        query.setParameter("region", region);

        return query;
    }
}
