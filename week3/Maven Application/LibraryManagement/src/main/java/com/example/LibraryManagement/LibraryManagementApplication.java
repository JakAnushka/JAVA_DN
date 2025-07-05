package com.example.LibraryManagement;

import com.example.LibraryManagement.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties.UiService.LOGGER;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LibraryManagementApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(LibraryManagementApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Starting Library Management Application");

		ApplicationContext context =SpringApplication.run(LibraryManagementApplication.class, args);
		BookService bookService = context.getBean(BookService.class);

		LOGGER.debug("Calling BookService.displayBooks()");
		bookService.displayBooks();

		LOGGER.info("Library Management Application Ended");
	}


}
