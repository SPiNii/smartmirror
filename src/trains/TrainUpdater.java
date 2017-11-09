package trains;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class TrainUpdater extends Thread {
	private volatile TrainDatabase db;
	private URL url;

	public TrainUpdater() {
		this.db = new TrainDatabase();
		try {
			url = new URL("https://efa-api.asw.io/api/v1/station/5006112/departures/?format=json");
		} catch (MalformedURLException e) {
			System.out.println("TrainUpdater: " + e.getMessage());
		}
	}

	public TrainDatabase getTrainDatabase() {
		return this.db;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(url.openStream(), "UTF-8");
			JSONArray arr = new JSONArray(scanner.nextLine());
			scanner.close();

			for (int i = 0; i < arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				db.add(new Train(obj));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
