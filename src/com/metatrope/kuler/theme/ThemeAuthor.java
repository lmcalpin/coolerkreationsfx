//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.11.04 at 10:23:28 AM EDT 
//


package com.metatrope.kuler.theme;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for themeAuthor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="themeAuthor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authorID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="authorLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "themeAuthor", propOrder = {
    "authorID",
    "authorLabel"
})
public class ThemeAuthor {

    protected int authorID;
    @XmlElement(required = true)
    protected String authorLabel;

    /**
     * Gets the value of the authorID property.
     * 
     */
    public int getAuthorID() {
        return authorID;
    }

    /**
     * Sets the value of the authorID property.
     * 
     */
    public void setAuthorID(int value) {
        this.authorID = value;
    }

    /**
     * Gets the value of the authorLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorLabel() {
        return authorLabel;
    }

    /**
     * Sets the value of the authorLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorLabel(String value) {
        this.authorLabel = value;
    }

}
