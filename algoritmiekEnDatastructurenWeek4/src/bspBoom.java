import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

public class bspBoom {
	public static void main(String[] args) {
		new bspBoom();
	}

	public bspBoom() {
		
/*
		boom boom = new boom();
		

		System.out.println(boom.toString());

		boom.recQuickSort(0, 7, 0);

		System.out.println(boom.toString());

		boom2 boom2 = new boom2();
		boom2.fill(8);

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
		*/
		
		
		int times = 10000;
		long Arraystart, Arraystop, treestart, treestop, geentreestart, geentreestop;
		
		int[] values = new int[] { 5, 50, 500 };
        for (int i = 0; i < values.length; i++)
        {
        	boom2 boom2 = new boom2();
    		
        	
    		boom2.fill(values[i]);
    		
    		
    		
    		Random r = new Random(1);
            int pos = r.nextInt(values[i]);
            double x = boom2.getArray()[pos].getPos(0);
            double y = boom2.getArray()[pos].getPos(1);
    		
            Arraystart = System.currentTimeMillis();
            for (int k = 0; k < times; k++)
            {
            	ArrayList<SpelObject> foundArray = boom2.searchArray(x, y);
            }
            Arraystop = System.currentTimeMillis();
            
            SpelObject[] a = boom2.getArray();
            
            geentreestart = System.currentTimeMillis();
            for (int k = 0; k < times; k++)
            {
            	boom2.setArray(a);
                Node temp = boom2.recQuickSort(0, values[i] - 1, 0);
                temp.setBounds();
                ArrayList<SpelObject> object = new ArrayList<SpelObject>();
        		temp.zoek(300.0, 850.0, object);
            }
            geentreestop = System.currentTimeMillis();
            
            boom2.setArray(a);
            Node temp = boom2.recQuickSort(0, values[i] - 1, 0);
            temp.setBounds();
            
            treestart = System.currentTimeMillis();
            for (int k = 0; k < times; k++)
            {
            	ArrayList<SpelObject> object = new ArrayList<SpelObject>();
        		temp.zoek(300.0, 850.0, object);
            }
            treestop = System.currentTimeMillis();
            
            
            
            System.out.println("Amount = " + values[i]);
            System.out.println("ExistingTree = " + (treestop - treestart));
            System.out.println("NonExistingTree = " + (geentreestop - geentreestart));
            System.out.println("array = " + (Arraystop - Arraystart));
            System.out.println();
        }
        
        
		
	}
}
