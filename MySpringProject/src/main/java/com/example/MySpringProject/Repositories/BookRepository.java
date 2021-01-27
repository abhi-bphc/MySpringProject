package com.example.MySpringProject.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.MySpringProject.domain.Books;

public interface BookRepository extends CrudRepository<Books, Long>{

}
