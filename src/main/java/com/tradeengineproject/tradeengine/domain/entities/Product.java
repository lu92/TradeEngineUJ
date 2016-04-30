package com.tradeengineproject.tradeengine.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

@Entity
public class Product
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String commercialName;
    private Double price;
    private Double tax;

    public class ProductDescription
    {
        private Long productDescriptionId;
        private Map<String, String> description;    //
    }
}
