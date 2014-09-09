public class boom {

	private SpelObject[] boompje;
	private int i = 0;

	boom() {
		this.boompje = new SpelObject[8];
		this.addToBoom(new SpelObject(900, 100));
		this.addToBoom(new SpelObject(100, 100));
		this.addToBoom(new SpelObject(950, 50));
		this.addToBoom(new SpelObject(50, 750));
		this.addToBoom(new SpelObject(110, 90));
		this.addToBoom(new SpelObject(60, 800));
		this.addToBoom(new SpelObject(40, 800));
		this.addToBoom(new SpelObject(700, 850));

	}

	public void addToBoom(SpelObject so) {
		this.boompje[this.i] = so;
		this.i++;
	}

	public void swap(int pos1, int pos2) {
		SpelObject temp = this.boompje[pos1];
		this.boompje[pos1] = this.boompje[pos2];
		this.boompje[pos2] = temp;
	}

	public void sort(int start, int eind, int dim) {
		int mediaanpos = getMediaanPos(start, eind, dim);
		System.out.println(mediaanpos);
		System.out.println(this.boompje[mediaanpos].toString());

		double mediaan = this.boompje[mediaanpos].getPos(dim);

		// http://www.algolist.net/Algorithms/Sorting/Quicksort

	}

	private int getMediaanPos(int start, int eind, int dim) {
		SpelObject obj1 = this.boompje[start];
		SpelObject obj2 = this.boompje[eind];
		SpelObject obj3 = this.boompje[(start + eind) / 2];

		if (obj1.getPos(dim) == obj2.getPos(dim)
				|| obj1.getPos(dim) == obj3.getPos(dim)
				|| obj1.getPos(dim) < obj2.getPos(dim)
				&& obj1.getPos(dim) > obj3.getPos(dim)
				|| obj1.getPos(dim) < obj3.getPos(dim)
				&& obj1.getPos(dim) > obj2.getPos(dim)) {
			return start;
		} else if (obj2.getPos(dim) == obj3.getPos(dim)
				|| obj2.getPos(dim) < obj1.getPos(dim)
				&& obj2.getPos(dim) > obj3.getPos(dim)
				|| obj2.getPos(dim) < obj3.getPos(dim)
				&& obj2.getPos(dim) > obj1.getPos(dim)) {
			return eind;
		} else {
			return (start + eind) / 2;
		}
	}

	public String toString() {

		String r = "{ ";

		for (int i = 0; i < this.boompje.length; i++) {
			if (i > 0)
				r += ", ";
			r += this.boompje[i].toString();
		}

		r += " }";

		return r;
	}
}
