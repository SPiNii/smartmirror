package trains;

public class TrainReader {
	private TrainDatabase db;
	private long lastUpdate;
	private TrainUpdater tUpdater;
	private boolean updated;

	public TrainReader() {
		this.tUpdater = new TrainUpdater();
		this.tUpdater.start();
		this.db = null;
		this.lastUpdate = System.currentTimeMillis();
		try {
			this.tUpdater.join();
			this.db = tUpdater.getTrainDatabase();
		} catch (InterruptedException e) {
			System.out.println("ApiReader Constructor: " + e.getMessage());
		}
	}

	public TrainDatabase getTrains() {
		if (updated && !tUpdater.isAlive()) {
			this.db = tUpdater.getTrainDatabase();
		}
		if (System.currentTimeMillis() - lastUpdate > 10000) {
			System.out.println("Trains are being background updated...");
			update();
			this.lastUpdate = System.currentTimeMillis();
			this.updated = true;
		}
		return this.db;
	}

	private void update() {
		this.db = tUpdater.getTrainDatabase();
		this.tUpdater = new TrainUpdater();
		this.tUpdater.start();
	}

}
