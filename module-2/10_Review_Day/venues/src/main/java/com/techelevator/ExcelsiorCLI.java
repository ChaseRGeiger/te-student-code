package com.techelevator;

import javax.sql.DataSource;

import com.techelevator.dao.model.Venue;
import com.techelevator.service.ConsoleService;
import com.techelevator.service.ReservationService;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class ExcelsiorCLI {

	private ConsoleService consoleService = new ConsoleService();
	private ReservationService reservationService;

	public ExcelsiorCLI(DataSource datasource) {
		reservationService = new ReservationService(datasource);
	}

	public void run() {

		consoleService.showWelcome();

		List<Venue> venues = reservationService.getListOfVenues();

		consoleService.showListOfVenues(venues);

	}




	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/Venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		ExcelsiorCLI application = new ExcelsiorCLI(dataSource);
		application.run();
	}
}
