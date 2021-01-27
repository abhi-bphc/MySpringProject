package com.example.MySpringProject.BootStrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.MySpringProject.Repositories.AuthorRepository;
import com.example.MySpringProject.Repositories.BookRepository;
import com.example.MySpringProject.Repositories.PublisherRepository;
import com.example.MySpringProject.domain.Author;
import com.example.MySpringProject.domain.Books;
import com.example.MySpringProject.domain.Publisher;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	@Autowired
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository=publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Publisher publisher=new Publisher();
		publisher.setAddress("Kadru");
		publisher.setCity("Ranchi");
		publisher.setState("Jharkhand");
		publisher.setZip("834002");
		
		publisherRepository.save(publisher);
		
		System.out.println("The no of publishers are:"+ publisherRepository.count());	
		
		Author Abhilash=new Author("Abhilash", "Sarkar");
		Books ddd=new Books("My Fav Book", "123123");
		
				
		Abhilash.getBooks().add(ddd);
		ddd.getAuthors().add(Abhilash);
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		authorRepository.save(Abhilash);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		
		
		Author rod=new Author("Rod","Johnson");
		Books noEJB=new Books("J2ee Developer","1267272");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
		
		System.out.println("Started in BootStrap");
		System.out.println(bookRepository.count());		
		System.out.println("Publisher number of Books: " + publisher.getBooks().size());
		
	}	

}
