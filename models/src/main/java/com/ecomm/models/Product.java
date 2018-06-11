package com.ecomm.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Required;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

/**
 * This class represents the product entity
 */
@ApiModel(description = "This represents Product entity")
//@JsonFilter("ProductFilter")
@Entity
public class Product extends BaseEntity
{
	@Size(min=5, max=200, message = "name should be between 5 to 200")
	@ApiModelProperty(notes = "name should be between 5 to 200" )
	private String name;

	@Size(min=5, max=500, message = "description should be between 5 to 500")
	@ApiModelProperty(notes = "description should be between 5 to 500" )
	private String description;

	public Product()
	{

	}

	public Product(Integer _id, String name, String description)
	{
		this.setId(_id);
		this.name = name;
		this.description = description;
	}

	public String getName()
	{
		return name;
	}

	@Required
	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	@Required
	public void setDescription(String description)
	{
		this.description = description;
	}


	@Override
	public String toString()
	{
		return "Product{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				", description=" + description +
				'}';
	}

}
