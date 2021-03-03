package com.stmlabs.denis.amazoncrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AmazonParser {

    static String title = "";

    public static String getTitle() {
        try {
            Document doc = Jsoup.connect("https://aws.amazon.com/ru/s3/pricing/").get();
            title = doc.title();
        } catch (Exception e) {

        }
        return title;
    }

}
