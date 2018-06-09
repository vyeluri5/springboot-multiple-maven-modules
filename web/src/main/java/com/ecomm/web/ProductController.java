package com.ecomm.web;

import com.ecomm.domain.DaoProduct;
import com.ecomm.exceptions.ProductNotFoundException;
import com.ecomm.models.Product;
import com.ecomm.exceptions.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ecomm.domain", "com.ecomm.exceptions" })
public class ProductController
{
	@Autowired
	private DaoProduct productService;

	@RequestMapping(method = RequestMethod.GET, path = "/products")
	public List<Product> getAllProducts()
	{
		return productService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/products/{id}")
	public Product getProduct(@PathVariable int id)
	{
		Product product = productService.findOne(id);

		if (product == null)
			throw new ProductNotFoundException("No such product exists!");

		return product;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/products")
	public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product)
	{
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(productService.save(product).getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping(path = "/products/{id}")
	public void deleteProduct(@PathVariable int id)
	{
		Product product = productService.deleteById(id);

		if (product == null)
			throw new ProductNotFoundException("No such product exists!");
	}

}
