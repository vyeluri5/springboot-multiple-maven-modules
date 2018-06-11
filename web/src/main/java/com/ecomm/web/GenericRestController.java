package com.ecomm.web;

import com.ecomm.domain.BaseRepository;
import com.ecomm.models.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class GenericRestController<T extends BaseEntity>
{
	@Autowired
	private BaseRepository<T> dao;

	@RequestMapping(method = RequestMethod.GET)
	public List<T> list()
	{
		return dao.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public T create(@RequestBody T entity)
	{
		return dao.save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public T update(@PathVariable(value = "id") Integer id, @RequestBody T entity)
	{
		return dao.save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "id") Integer id)
	{
		dao.deleteById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public T get(@PathVariable(value = "id") Integer id)
	{
		return dao.getOne(id);
	}
}
