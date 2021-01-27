package com.example.MySpringProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MySpringProject.Repositories.BookRepository;

@Controller
public class BooksController {
	
	private final BookRepository bookRepository;
	
		
	public BooksController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model)
	{
		
		model.addAttribute("books",bookRepository.findAll());
		return "list";
	}

}
