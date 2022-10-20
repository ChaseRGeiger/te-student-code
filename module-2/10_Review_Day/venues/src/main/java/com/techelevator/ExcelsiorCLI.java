package com.techelevator;

import javax.sql.DataSource;

import com.techelevator.service.ConsoleService;
import org.apache.commons.dbcp2.BasicDataSource;

public class ExcelsiorCLI {

	private ConsoleService consoleService = new ConsoleService();


	public ExcelsiorCLI(DataSource datasource) {

	}

	public void run() {

		consoleService.showWelcome();

	}




	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		ExcelsiorCLI application = new ExcelsiorCLI(dataSource);
		application.run();
	}
}
