package com.ecomm.models;

import javax.validation.constraints.Size;

/**
 * This class represents the product entity
 */
public class Product
{
	private Integer id;

	@Size(min=5, max=200, message = "name should be between 5 to 200")
	private String name;

	@Size(min=5, max=500, message = "description should be between 5 to 500")
	private String description;

	protected Product()
	{

	}

	public Product(Integer id, String name, String description)
	{
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}


	@Override
	public String toString()
	{
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description=" + description +
				'}';
	}

}
