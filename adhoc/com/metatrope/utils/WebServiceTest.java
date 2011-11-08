package com.metatrope.utils;

import com.metatrope.kuler.Kuler;
import com.metatrope.kuler.theme.ThemeItem;

import java.util.List;

import org.junit.Test;

public class WebServiceTest {
    @Test
    public void testKuler() throws Exception {
        List<ThemeItem> themes = Kuler.findThemesForTag("cloudy");
        for (ThemeItem theme : themes) {
            System.out.println(theme.getThemeTitle());
        }
    }
}
