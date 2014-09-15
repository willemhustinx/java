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
	
	/*
	public void sort(int start, int eind, int dim) {
		int index = this.partition(start, eind, dim);
		System.out.println("index: " + index);

		if (start < index - 1) {
			System.out.println("partition left: " + this.toString(start, index - 1));
			this.partition(start, index - 1, dim + 1);
		}
		if (index < eind) {
			System.out.println("partition right: " + this.toString(index - 1, eind));
			this.partition(index - 1, eind, dim + 1);
		}

	}
	*/
	
	/*
	int partition(int start, int eind, int dim) {

		int mediaanpos = getMediaanPos(start, eind, dim);
		System.out.println(mediaanpos);
		System.out.println(this.boompje[mediaanpos].toString());
		
		double mediaan = this.boompje[mediaanpos].getPos(dim);
		System.out.println("mediaan: " + this.boompje[mediaanpos].getPos(dim)  + " dim: " + (dim % 2));
		
		int i = start;
		int j = eind;
		SpelObject temp;

		while (i <= j) {
			while (this.boompje[i].getPos(dim) < mediaan) {
				i++;
				System.out.println("i + 1: " + i);
			}
			while (this.boompje[j].getPos(dim) > mediaan) {
				j--;
				System.out.println("j + 1: " + j);
			}
			if (i <= j) {
				temp = this.boompje[i];
				System.out.println("wissel " + this.boompje[i].toString()
						+ " en " + this.boompje[j].toString());
				this.boompje[i] = this.boompje[j];
				this.boompje[j] = temp;
				
				i++;
				System.out.println("i + 1: " + i);
				j--;
				System.out.println("j + 1: " + j);
				System.out.println(this.toString());
			}
		}
		
		return i;
	}
	*/
	
	/*
	// http://www.algolist.net/Algorithms/Sorting/Quicksort
	int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}

	*/
	
	public void recQuickSort(int left, int right, int dim) {
		int size = right - left + 1;
		if (size <= 3) // manual sort if small
			manualSort(left, right, dim);
		else // quicksort if large
		{
			SpelObject median = medianOf3(left, right, dim);
			double medianValue = median.getPos(dim);
			System.out.println("mediaan value: " + medianValue);
			int partition = partitionIt(left, right, medianValue, dim);
			System.out.println("left: \n" + this.toString(left, partition -1));
			System.out.println("right: \n" + this.toString(partition + 1, right));
			recQuickSort(left, partition - 1, dim + 1);
			//System.out.println("right: \n" + this.toString(partition + 1, right));
			recQuickSort(partition + 1, right, dim + 1);
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
		if (size == 2)
		{ // 2-sort left and right
			if (this.boompje[left].getPos(dim) > this.boompje[right].getPos(dim))
				swap(left, right);
			return;
		}
		else // size is 3
		{ // 3-sort left, center, & right
			if (this.boompje[left].getPos(dim) > this.boompje[right - 1].getPos(dim))
				swap(left, right - 1); // left, center
			if (this.boompje[left].getPos(dim) > this.boompje[right].getPos(dim))
				swap(left, right); // left, right
			if (this.boompje[right - 1].getPos(dim) > this.boompje[right].getPos(dim))
				swap(right - 1, right); // center, right
		}
	} // end manualSort()
	
	/*
	private int getMediaanPos(int start, int eind, int dim) {
		SpelObject obj1 = this.boompje[start];
		SpelObject obj2 = this.boompje[eind];
		SpelObject obj3 = this.boompje[(start + eind) / 2];
		
		System.out.println(this.toString());
		System.out.println("optie 1: " + start + " optie 2: " + eind + " optie 3: " + (start + eind) / 2 + " dim: " + (dim % 2));

		System.out.println("optie 1: " + obj1.getPos(dim) + " optie 2: " + obj2.getPos(dim) + " optie 3: " + obj3.getPos(dim) + " dim: " + (dim % 2));

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
	*/

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
