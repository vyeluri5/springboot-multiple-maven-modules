package com.ecomm.web;

import com.ecomm.models.Item;
import com.ecomm.models.Product;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController extends BaseController
{

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-intl")
//	public String helloWorldIntl(@RequestHeader(name="Accept-Language", required = false) Locale locale)
	public String helloWorldIntl()
	{
		return messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
	}

	/**
	 * Method returns <see>MappingJacksonValue</see> object with filtered fields
	 * @return String
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-filter")
	public MappingJacksonValue helloWorldFilter()
	{
		Product product = new Product();
		product.setName("This is test product name");
		product.setDescription("Description of test product");
		product.setId(1);

		// We want to exclude ID in return path
		filterProvider = SimpleBeanPropertyFilter.filterOutAllExcept("name", "description");

		filter = new SimpleFilterProvider().addFilter("ProductFilter", filterProvider);

		mapping = new MappingJacksonValue(product);
		mapping.setFilters(filter);

		return mapping;
	}

	@RequestMapping(method = RequestMethod.GET, path = "v1/item")
	public MappingJacksonValue helloWorldV1()
	{
		Item item = new Item();
		item.setName("This is t-shirt item");
		item.setPrice(10.40);

		// We want to exclude Price in return path
		filterProvider = SimpleBeanPropertyFilter.filterOutAllExcept("name" );

		filter = new SimpleFilterProvider().addFilter("ItemFilter", filterProvider);

		mapping = new MappingJacksonValue(item);
		mapping.setFilters(filter);

		return mapping;
	}

	@RequestMapping(method = RequestMethod.GET, path = "v2/item")
	public MappingJacksonValue helloWorldV2()
	{
		Item item = new Item();
		item.setName("This is t-shirt item");
		item.setPrice(10.40);

		// We want to exclude Price in return path
		filterProvider = SimpleBeanPropertyFilter.filterOutAllExcept("name", "price");

		filter = new SimpleFilterProvider().addFilter("ItemFilter", filterProvider);

		mapping = new MappingJacksonValue(item);
		mapping.setFilters(filter);

		return mapping;
	}

	@RequestMapping(method = RequestMethod.GET, path = "item", headers = "X-API-Version=1")
	public MappingJacksonValue helloWorldHeaderV1()
	{
		Item item = new Item();
		item.setName("This is t-shirt item");
		item.setPrice(10.40);

		// We want to exclude Price in return path
		filterProvider = SimpleBeanPropertyFilter.filterOutAllExcept("name" );

		filter = new SimpleFilterProvider().addFilter("ItemFilter", filterProvider);

		mapping = new MappingJacksonValue(item);
		mapping.setFilters(filter);

		return mapping;
	}

	@RequestMapping(method = RequestMethod.GET, path = "item", headers = "X-API-Version=2")
	public MappingJacksonValue helloWorldHeaderV2()
	{
		Item item = new Item();
		item.setName("This is t-shirt item");
		item.setPrice(10.40);

		// We want to exclude Price in return path
		filterProvider = SimpleBeanPropertyFilter.filterOutAllExcept("name", "price");

		filter = new SimpleFilterProvider().addFilter("ItemFilter", filterProvider);

		mapping = new MappingJacksonValue(item);
		mapping.setFilters(filter);

		return mapping;
	}

}
