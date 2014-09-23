import java.awt.List;
import java.util.ArrayList;

public class bspBoom {
	public static void main(String[] args) {
		new bspBoom();
	}

	public bspBoom() {

		boom boom = new boom();

		System.out.println(boom.toString());
		
		boom.recQuickSort(0, 7, 0);
		
		System.out.println(boom.toString());
		
		
		boom2 boom2 = new boom2();
		
		System.out.println(boom2.toString());
		
		Node temp = boom2.recQuickSort(0, 7, 0);
		
		System.out.println(temp.toString());
		
		System.out.println(temp.lowerBound(0));
		System.out.println(temp.lowerBound(1));
		System.out.println(temp.upperBound(0));
		System.out.println(temp.upperBound(1));
		
		ArrayList<SpelObject> object = new ArrayList<SpelObject>();
		temp.zoek(300.0, 850.0, object);
		
		System.out.println(object.toString());
		
		System.out.println(boom2.toString());
	}

}
