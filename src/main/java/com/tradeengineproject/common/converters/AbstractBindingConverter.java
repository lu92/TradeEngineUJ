package com.tradeengineproject.common.converters;

public abstract class AbstractBindingConverter<IN, OUT>
{
    abstract OUT convert(IN in);
}
