package trains;

public class TrainDatabase {
	private ITrainDatabase root, last;
	private int size;

	public TrainDatabase() {
		this.root = new ITrainDatabase();
		this.last = this.root;
	}

	public TrainDatabase(Train train) {
		this.root = new ITrainDatabase();
		this.root.next.setTrain(train);
		this.size = 1;
	}

	public void add(Train train) {
		ITrainDatabase element = new ITrainDatabase(null, this.last, train);
		this.last.setNext(element);
		this.last = element;
		this.size++;
	}

	public Train getFirst() {
		return this.root.next.getTrain();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public Train remove(int index) {
		if (size < index || index < 0) {
			return null;
		} else {
			ITrainDatabase temp = this.root;
			for (int i = 0; i < index; i++) {
				temp = this.root;
			}
			if (temp != this.root) {
				temp.getPrevious().setNext(temp.getNext());
			} else {
				this.root = this.root.next;
			}
			temp.getNext().setPrevious(temp.getPrevious());
			return temp.getTrain();
		}
	}
}
