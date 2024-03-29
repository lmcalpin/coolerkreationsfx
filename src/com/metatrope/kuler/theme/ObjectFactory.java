//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.11.04 at 10:23:28 AM EDT 
//


package com.metatrope.kuler.theme;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.metrowine.kuler package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ThemeItem_QNAME = new QName("http://kuler.adobe.com/kuler/API/rss/", "themeItem");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.metrowine.kuler
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ThemeItem }
     * 
     */
    public ThemeItem createThemeItem() {
        return new ThemeItem();
    }

    /**
     * Create an instance of {@link ThemeAuthor }
     * 
     */
    public ThemeAuthor createThemeAuthor() {
        return new ThemeAuthor();
    }

    /**
     * Create an instance of {@link Swatch }
     * 
     */
    public Swatch createSwatch() {
        return new Swatch();
    }

    /**
     * Create an instance of {@link ThemeSwatches }
     * 
     */
    public ThemeSwatches createThemeSwatches() {
        return new ThemeSwatches();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ThemeItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://kuler.adobe.com/kuler/API/rss/", name = "themeItem")
    public JAXBElement<ThemeItem> createThemeItem(ThemeItem value) {
        return new JAXBElement<ThemeItem>(_ThemeItem_QNAME, ThemeItem.class, null, value);
    }

}
