package com.stmlabs.denis.amazoncrawler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AmazonParserTest {

    @Test
    void test() {
        try {
            final WebClient webClient = new WebClient();

            final HtmlPage page = webClient.getPage("https://aws.amazon.com/ru/s3/pricing/");

            List<HtmlListItem> date = page.getByXPath("//li[@class='lb-tabs-trigger']");

            HtmlPage p = date.get(0).click();

            String title = p.asXml();
            Document doc = Jsoup.parse(title);
            Elements elements = doc.getAllElements();
            //Document doc = Jsoup.connect("https://aws.amazon.com/ru/s3/pricing/").get();
            //title = doc.title();
        } catch (Exception e) {
            String title = "asd";
        }
    }
}
