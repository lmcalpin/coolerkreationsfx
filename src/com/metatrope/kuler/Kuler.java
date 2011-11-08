package com.metatrope.kuler;

import com.metatrope.kuler.rss.Rss;
import com.metatrope.kuler.rss.RssItem;
import com.metatrope.kuler.theme.ThemeItem;
import com.metatrope.utils.CheckedExceptionsAreStupidException;
import com.metatrope.utils.WebService;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Kuler {
    private static final JAXBContext JC;
    
    private static final String API_KEY;
    private static final String TAG_SERVICE_URL = "http://kuler.adobe.com/kuler/API/rss/search.cfm";
    
    static {
        try {
            JC = JAXBContext.newInstance(Rss.class.getPackage().getName());
            Properties properties = new Properties();
            properties.load(Kuler.class.getResourceAsStream("/coolerkreator.properties"));
            API_KEY = properties.getProperty("apikey");
        } catch (JAXBException e) {
            throw new CheckedExceptionsAreStupidException(e); // seriously, they are
        } catch (IOException e) {
            throw new CheckedExceptionsAreStupidException(e); // seriously, they are
        }        
    }
    
    public static List<ThemeItem> findThemesForTag(String tag) {
        try {
            String response = WebService.get(appendApiKey(TAG_SERVICE_URL + "?searchQuery=tag:" + tag));
            Unmarshaller u = JC.createUnmarshaller();
            Rss rss = (Rss)u.unmarshal(new StringReader(response));
            List<ThemeItem> themes = new ArrayList<ThemeItem>();
            for (RssItem rssItem : rss.getChannel().getItems()) {
                themes.add(rssItem.getThemeItem());
            }
            return themes;
        } catch (JAXBException e) {
            throw new CheckedExceptionsAreStupidException(e); // seriously, they are
        }

    }
    
    private static String appendApiKey(String baseURL) {
        return baseURL + "&key=" + API_KEY;        
    }
}
