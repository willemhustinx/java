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
	
	public void recQuickSort(int left, int right, int dim) {
		int size = right - left + 1;
		if (size <= 2) // manual sort if small
			manualSort(left, right, dim);
		else // quicksort if large
		{
			SpelObject median = medianOf3(left, right, dim);
			double medianValue = median.getPos(dim);
			int partition = partitionIt(left, right, medianValue, dim);
			recQuickSort(left, partition - 1, dim + 1);
			//System.out.println("right: \n" + this.toString(partition + 1, right));
			recQuickSort(partition, right, dim + 1);
		}
	} // end recQuickSort()
	
	public SpelObject medianOf3(int left, int right, int dim)
	{
		int center = (left + right) / 2;
		
		if (this.boompje[left].getPos(dim) > this.boompje[center].getPos(dim))
			swap(left, center);
		if (this.boompje[left].getPos(dim) > this.boompje[right].getPos(dim))
			swap(left, right);
		if (this.boompje[center].getPos(dim) > this.boompje[right].getPos(dim))
			swap(center, right);
		swap(center, right - 1); // put pivot on right
		
		return this.boompje[right - 1];
	}

	public void swap(int dex1, int dex2) // swap two elements
	{
		SpelObject temp = this.boompje[dex1]; // A into temp
		this.boompje[dex1] = this.boompje[dex2]; // B into A
		this.boompje[dex2] = temp; // temp into B
	}
	
	public int partitionIt(int left, int right, double pivot, int dim) {
		int leftPtr = left; // right of first elem
		int rightPtr = right - 1; // left of pivot
		while (true) {
			while (this.boompje[++leftPtr].getPos(dim) < pivot)
				// find bigger
				; // (nop)
			while (this.boompje[--rightPtr].getPos(dim) > pivot)
				// find smaller
				;
			if (leftPtr >= rightPtr) // if pointers cross,
				break;
			else
				// not crossed, so
				swap(leftPtr, rightPtr); // swap elements
		} // end while(true)
		swap(leftPtr, right - 1); // restore pivot
		return leftPtr; // return pivot location
	} // end partitionIt()
	
	public void manualSort(int left, int right, int dim)
	{
		int size = right - left + 1;
		if (size <= 1)
			return; // no sort necessary
		else if(size == 2)
		{ // 2-sort left and right
			if (this.boompje[left].getPos(dim) > this.boompje[right].getPos(dim))
				swap(left, right);
			return;
		}
		/*
		else // size is 3
		{ // 3-sort left, center, & right
			if (this.boompje[left].getPos(dim) > this.boompje[right - 1].getPos(dim))
				swap(left, right - 1); // left, center
			if (this.boompje[left].getPos(dim) > this.boompje[right].getPos(dim))
				swap(left, right); // left, right
			if (this.boompje[right - 1].getPos(dim) > this.boompje[right].getPos(dim))
				swap(right - 1, right); // center, right
		}
		*/
		
	} // end manualSort()
	

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
	
	public String toString(int start, int eind)
	{
		String r = "{ ";

		for (int i = start; i <= eind; i++) {
			if (i > start)
				r += ", ";
			r += this.boompje[i].toString();
		}

		r += " }";

		return r;
	}
}
