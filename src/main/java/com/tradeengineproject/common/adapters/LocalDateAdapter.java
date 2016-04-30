package com.tradeengineproject.common.adapters;

import javax.xml.bind.DatatypeConverter;
import java.time.LocalDate;
import java.util.Date;

public class LocalDateAdapter
{

    public static LocalDate unmarshal(String stringDate) {
        Date date = DatatypeConverter.parseDate(stringDate).getTime();
        return LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
    }

    public static String marshal(LocalDate localDate) {
        return localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth();
    }
}
