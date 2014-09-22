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
		
		System.out.println(boom2.recQuickSort(0, 7, 0).toString());
		
		System.out.println(boom2.toString());
	}

}
