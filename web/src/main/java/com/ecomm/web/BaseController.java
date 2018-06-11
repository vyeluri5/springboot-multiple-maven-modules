package com.ecomm.web;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import org.springframework.http.converter.json.MappingJacksonValue;

public class BaseController
{
	protected SimpleBeanPropertyFilter filterProvider;
	protected FilterProvider filter;
	protected MappingJacksonValue mapping;

	public BaseController()
	{

	}


}
