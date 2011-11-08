package com.metatrope.model.rss;

import com.metatrope.kuler.rss.Rss;
import com.metatrope.kuler.rss.RssItem;
import com.metatrope.utils.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

public class RssTest {
    String responseXml;
    
    @Before
    public void init() throws IOException {
        InputStream input = ClassLoader.getSystemResourceAsStream("response.rss.xml");
        if (input == null) {
            Assert.fail("Test RSS feed not found");
        }
        responseXml = IOUtil.readAsString(input);
    }
    
    @Test
    public void testRssFeedUnmarshal() throws JAXBException {
        Unmarshaller u = JAXBContext.newInstance(Rss.class.getPackage().getName()).createUnmarshaller();
        Rss rss = (Rss) u.unmarshal(new StringReader(responseXml));
        Assert.assertEquals("kuler search results for 'tag:super'", rss.getChannel().getTitle());
        RssItem firstItem = rss.getChannel().getItems().get(0);
        Assert.assertEquals("WipEout HD fury", firstItem.getThemeItem().getThemeTitle());
    }
}
