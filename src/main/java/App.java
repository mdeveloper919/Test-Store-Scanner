import java.util.Arrays;
import java.util.List;

import com.store.BaseTerminal;
import com.store.Terminal;
import com.store.models.StoreItem;

public class App {
	//Trying out the terminal API
	public static void main(String[] args) {
		/*
		* Dummy Items
		*/
		//Item One
		StoreItem itemOne = new StoreItem();
		itemOne.setProductCode("A");
		itemOne.setBasePrice(2d);
		itemOne.addPriceQuantityMapping(4l, 7d);
		//Item Two
		StoreItem itemTwo = new StoreItem();
		itemTwo.setProductCode("B");
		itemTwo.setBasePrice(12d);
		//Item Three
		StoreItem itemThree = new StoreItem();
		itemThree.setProductCode("C");
		itemThree.setBasePrice(1.25d);
		itemThree.addPriceQuantityMapping(6l, 6d);
		//Item Four
		StoreItem itemFour = new StoreItem();
		itemFour.setProductCode("D");
		itemFour.setBasePrice(0.15d);
		List<StoreItem> items = Arrays.asList(new StoreItem[] {itemOne, itemTwo, itemThree, itemFour});
		
		//Test Case One
		Terminal t1 = new BaseTerminal();
		t1.setPricing(items);
		//Scanning individually
		t1.scan("A");
		t1.scan("B");
		t1.scan("C");
		t1.scan("D");
		t1.scan("A");
		t1.scan("B");
		t1.scan("A");
		t1.scan("A");
		System.out.println("Total Terminal 1: " + t1.getTotal());
		
		//Test Case Two
		Terminal t2 = new BaseTerminal();
		t2.setPricing(items);
		//Scanning a set of codes together
		t2.scan(new String[] {"C","C","C","C","C","C","C"});
		System.out.println("Total Terminal 2: " + t2.getTotal());
		
		Terminal t3 = new BaseTerminal();
		t3.setPricing(items);
		t3.scan(new String[] {"A","B","C","D"});
		System.out.println("Total Terminal 3: " + t3.getTotal());
		
	}

}
