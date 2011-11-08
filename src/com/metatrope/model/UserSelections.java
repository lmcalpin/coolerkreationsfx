package com.metatrope.model;

import com.metatrope.utils.MathUtil;

import javafx.scene.paint.Color;

/**
 * Holds the values the user selects to customize the generated artwork. 
 * 
 * @author Lawrence McAlpin
 */
public class UserSelections {
    public String theme;
    public Color[] colors;
    
    public Color randomColor() {
        return colors[MathUtil.randomInt(0, colors.length - 1)];
    }
}
