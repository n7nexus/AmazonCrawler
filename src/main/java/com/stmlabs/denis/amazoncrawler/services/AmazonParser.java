package com.stmlabs.denis.amazoncrawler.services;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AmazonParser {

    static String title = "";

    public static String getTitle() {

        try {
            final WebClient webClient = new WebClient();

            final HtmlPage page = webClient.getPage("https://aws.amazon.com/ru/s3/pricing/");

            //Document doc = Jsoup.connect("https://aws.amazon.com/ru/s3/pricing/").get();
            //title = doc.title();
        } catch (Exception e) {

        }
        return title;
    }

}
