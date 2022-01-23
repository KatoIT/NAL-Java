package com.company;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    private static final String REGEX = "<h3 class=\"article-title\"> <a data-utm=\"\" href=\"(.*?)\">(.*?)</a> </h3>";

    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            // open the stream and put it into BufferedReader
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            // close scanner
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n+", "");
            // regex
            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println("Article Title:");
                System.out.println("\t"
                        + m.group(2).replaceAll("&quot;+", "\"") + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
