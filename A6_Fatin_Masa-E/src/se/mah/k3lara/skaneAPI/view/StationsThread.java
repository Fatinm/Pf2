package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class StationsThread extends Thread {

	private Parser parser;
	private GUI gui;

	public StationsThread(Parser p, GUI g) {
		this.parser = p;
		this.gui = g;
	}

	public void run() {

		
		gui.areaResult1.setText(null);

		gui.areaResult1.setText("Searching...");

		
		ArrayList<Station> searchStations1 = new ArrayList<Station>();

		searchStations1.addAll(Parser.getStationsFromURL(gui.fieldSearch
				.getText()));
		
		gui.areaResult1.setText(null);
		
		for (Station s : searchStations1) {
			gui.areaResult1.append(s.getStationName() + " number:"
					+ s.getStationNbr() + " latitude: " + s.getLatitude()
					+ " longitude: " + s.getLongitude() + "\n");
		}

	}

}