package com.ecomm.web;

import com.ecomm.domain.ProductRepository;
import com.ecomm.exceptions.ProductNotFoundException;
import com.ecomm.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController extends GenericRestController<Product>
{
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(method = RequestMethod.GET, path = "jpa/products")
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "jpa/products/{id}")
	public Resource<Product> getProduct(@PathVariable int id)
	{
		Optional<Product> product = productRepository.findById(id);

		if (!product.isPresent())
			throw new ProductNotFoundException("No such product exists!");

		//Return all-products resource

		Resource<Product> productsResource = new Resource<Product>(product.get());

		ControllerLinkBuilder linkBuilder =
				ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllProducts());

		productsResource.add(linkBuilder.withRel("getallproducts"));

		return productsResource;
	}

	@PostMapping(path = "/jpa/products")
	public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product)
	{
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(productRepository.save(product).getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/jpa/products/{id}")
	public void deleteProduct(@PathVariable int id)
	{
		productRepository.deleteById(id);
	}
}
