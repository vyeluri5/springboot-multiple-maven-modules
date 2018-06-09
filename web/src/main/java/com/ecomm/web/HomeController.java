package com.ecomm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController
{

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-intl")
//	public String helloWorldIntl(@RequestHeader(name="Accept-Language", required = false) Locale locale)
	public String helloWorldIntl()
	{
		return messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
	}
}
