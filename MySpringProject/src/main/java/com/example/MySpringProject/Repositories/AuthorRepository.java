package com.example.MySpringProject.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.MySpringProject.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
