package com.mpj.service;

import com.mpj.pojo.Person;

public interface PersonService {
	public Person getRandom();
	public Person getById(Long id);
	public void save(Person person);
}
