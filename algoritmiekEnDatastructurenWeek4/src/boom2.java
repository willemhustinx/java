import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

public class boom2 {

	private SpelObject[] boompje;
	private int i = 0;

	boom2() {
		
	}
	
	public SpelObject[] getArray()
	{
		return this.boompje;
	}
	
	public void setArray(SpelObject[] a) {
		this.boompje = a;
		
	}
	
	public void fill(int amount)
	{
		this.boompje = new SpelObject[amount];
		
		Random r = new Random();
		
		for(int j = 0; j < amount; j++ )
		{
			this.addToBoom(new SpelObject(r.nextDouble() * (Double.MAX_VALUE - 1), r.nextDouble() * (Double.MAX_VALUE - 1)));
		}
	}
	
	public ArrayList<SpelObject> searchArray(double x, double y)
    {
		
		ArrayList<SpelObject> found = new ArrayList<SpelObject>();
        for (int i = 0; i < boompje.length; i++)
        {
            if (boompje[i].getPos(0) == x && boompje[i].getPos(1) == y)
            {
                found.add(boompje[i]);
            }
        }
        return found;
    }
	

	public void addToBoom(SpelObject so) {
		this.boompje[this.i] = so;
		this.i++;
	}

	public Node recQuickSort(int left, int right, int dim) {

		Node newnode;

		int size = right - left + 1;

		if (size <= 1) {
			newnode = new EndNode(null, this.boompje[left]);
			return newnode; // no sort necessary
		} else if (size == 2) { // 2-sort left and right
			newnode = new SplitNode(null);
			if (this.boompje[left].getPos(dim + 1) > this.boompje[right]
					.getPos(dim + 1))
				swap(left, right);

			((SplitNode) newnode).setLeftChild(new EndNode(null,
					this.boompje[left]));
			((SplitNode) newnode).setRightChild(new EndNode(null,
					this.boompje[right]));

			return newnode;
		} else // quicksort if large
		{
			newnode = new SplitNode(null);

			SpelObject median = medianOf3(left, right, dim);
			double medianValue = median.getPos(dim);

			int partition = partitionIt(left, right, medianValue, dim);

			((SplitNode) newnode).setLeftChild(recQuickSort(left,
					partition - 1, dim + 1));

			((SplitNode) newnode).setRightChild(recQuickSort(partition, right,
					dim + 1));
		}

		// System.out.println(newnode.toString());
		return newnode;
	} // end recQuickSort()

	public SpelObject medianOf3(int left, int right, int dim) {
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

	public void manualSort(int left, int right, int dim) {
		int size = right - left + 1;
		if (size <= 1)
			return; // no sort necessary
		else { // 2-sort left and right
			if (this.boompje[left].getPos(dim) > this.boompje[right]
					.getPos(dim))
				swap(left, right);
			return;
		}

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

	public String toString(int start, int eind) {
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
