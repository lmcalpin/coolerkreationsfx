//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.11.04 at 10:23:28 AM EDT 
//


package com.metatrope.kuler.theme;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for swatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="swatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="swatchHexColor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="swatchColorMode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="swatchChannel1" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="swatchChannel2" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="swatchChannel3" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="swatchChannel4" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="swatchIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "swatch", propOrder = {
    "swatchHexColor",
    "swatchColorMode",
    "swatchChannel1",
    "swatchChannel2",
    "swatchChannel3",
    "swatchChannel4",
    "swatchIndex"
})
public class Swatch {

    @XmlElement(required = true)
    protected String swatchHexColor;
    @XmlElement(required = true)
    protected String swatchColorMode;
    @XmlElement(required = true)
    protected BigDecimal swatchChannel1;
    @XmlElement(required = true)
    protected BigDecimal swatchChannel2;
    @XmlElement(required = true)
    protected BigDecimal swatchChannel3;
    @XmlElement(required = true)
    protected BigDecimal swatchChannel4;
    protected int swatchIndex;

    /**
     * Gets the value of the swatchHexColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwatchHexColor() {
        return swatchHexColor;
    }

    /**
     * Sets the value of the swatchHexColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwatchHexColor(String value) {
        this.swatchHexColor = value;
    }

    /**
     * Gets the value of the swatchColorMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwatchColorMode() {
        return swatchColorMode;
    }

    /**
     * Sets the value of the swatchColorMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwatchColorMode(String value) {
        this.swatchColorMode = value;
    }

    /**
     * Gets the value of the swatchChannel1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSwatchChannel1() {
        return swatchChannel1;
    }

    /**
     * Sets the value of the swatchChannel1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSwatchChannel1(BigDecimal value) {
        this.swatchChannel1 = value;
    }

    /**
     * Gets the value of the swatchChannel2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSwatchChannel2() {
        return swatchChannel2;
    }

    /**
     * Sets the value of the swatchChannel2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSwatchChannel2(BigDecimal value) {
        this.swatchChannel2 = value;
    }

    /**
     * Gets the value of the swatchChannel3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSwatchChannel3() {
        return swatchChannel3;
    }

    /**
     * Sets the value of the swatchChannel3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSwatchChannel3(BigDecimal value) {
        this.swatchChannel3 = value;
    }

    /**
     * Gets the value of the swatchChannel4 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSwatchChannel4() {
        return swatchChannel4;
    }

    /**
     * Sets the value of the swatchChannel4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSwatchChannel4(BigDecimal value) {
        this.swatchChannel4 = value;
    }

    /**
     * Gets the value of the swatchIndex property.
     * 
     */
    public int getSwatchIndex() {
        return swatchIndex;
    }

    /**
     * Sets the value of the swatchIndex property.
     * 
     */
    public void setSwatchIndex(int value) {
        this.swatchIndex = value;
    }

}
