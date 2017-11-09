package trains;

public class ITrainDatabase {
	ITrainDatabase next;
	ITrainDatabase previous;
	Train train;

	public ITrainDatabase getNext() {
		return this.next;
	}

	public ITrainDatabase getPrevious() {
		return this.previous;
	}

	public Train getTrain() {
		return this.train;
	}

	public void setNext(ITrainDatabase next) {
		this.next = next;
	}

	public void setPrevious(ITrainDatabase previous) {
		this.previous = previous;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public ITrainDatabase(ITrainDatabase next, ITrainDatabase previous, Train train) {
		this.next = next;
		this.previous = previous;
		this.train = train;
	}

	public ITrainDatabase() {
		this.next = null;
		this.previous = null;
		this.train = null;
	}

}
