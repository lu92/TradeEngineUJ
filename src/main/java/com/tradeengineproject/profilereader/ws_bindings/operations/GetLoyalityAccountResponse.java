//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.30 at 10:33:19 PM CEST 
//


package com.tradeengineproject.profilereader.ws_bindings.operations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.tradeengineproject.tradeengine.ws_bindings.LoyalityAccount;
import com.tradeengineproject.tradeengine.ws_bindings.Result;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoyalityAccount" type="{http://ws_bindings.tradeengine.tradeengineproject.com}LoyalityAccount"/>
 *         &lt;element name="Result" type="{http://ws_bindings.tradeengine.tradeengineproject.com}Result"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "loyalityAccount",
    "result"
})
@XmlRootElement(name = "GetLoyalityAccountResponse")
public class GetLoyalityAccountResponse {

    @XmlElement(name = "LoyalityAccount", required = true)
    protected LoyalityAccount loyalityAccount;
    @XmlElement(name = "Result", required = true)
    protected Result result;

    /**
     * Gets the value of the loyalityAccount property.
     * 
     * @return
     *     possible object is
     *     {@link LoyalityAccount }
     *     
     */
    public LoyalityAccount getLoyalityAccount() {
        return loyalityAccount;
    }

    /**
     * Sets the value of the loyalityAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyalityAccount }
     *     
     */
    public void setLoyalityAccount(LoyalityAccount value) {
        this.loyalityAccount = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setResult(Result value) {
        this.result = value;
    }

}
