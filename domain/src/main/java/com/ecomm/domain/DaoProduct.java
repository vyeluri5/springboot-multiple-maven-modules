package com.ecomm.domain;

import com.ecomm.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class DaoProduct
{
	private static List<Product> products = new ArrayList<Product>();
	private static Integer productCount = 3;

	static {
		products.add(new Product(1, "T-Shirt with stripes", "long sleeve t-shirt"));
		products.add(new Product(2, "Blue T-Shirt with stripes", "long sleeve t-shirt"));
		products.add(new Product(3, "Red T-Shirt with stripes", "long sleeve t-shirt"));
	}

	public  List<Product> findAll()
	{
		return products;
	}

	public Product save(Product prod)
	{
//		if (prod.getId() == null)
//		{
//			prod.setId(++productCount);
//		}

		products.add(prod);

		return prod;
	}

	public Product findOne(int id)
	{
//		Stream<Product> product = products.stream()
//				.filter(p -> p.getId() == id);
//
//		return product.count() == 0 ? null : product.collect(Collectors.toList()).get(0);

		for (Product i : products)
		{
//			if (i.getId() == id)
//			{
//				return i;
//			}
		}
		return null;
	}

	public Product deleteById(int id)
	{
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext())
		{
//			Product prod = iterator.next();
//			if (prod.getId() == id)
//			{
//				iterator.remove();
//				return prod;
//			}
		}
		return null;
	}
}
