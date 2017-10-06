package com.store;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.store.BaseTerminal;
import com.store.Terminal;
import com.store.models.StoreItem;

public class AppTest {
	
	List<StoreItem> items;
	
	public AppTest(){
		//Preparing mock Items
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
		this.items = items;
	}

	@BeforeClass
	public static void startUp() {
		System.out.println("Starting Test for Terminal");
	}

	@AfterClass
	public static void shutDown() {
		System.out.println("Tests Completed.");
	}

	@Test
	public void testCaseOne() {
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
		Assert.assertEquals(t1.getTotal(), Double.valueOf(32.4d));
	}
	
	@Test
	public void testCaseTwo() {
		Terminal t = new BaseTerminal();
		t.setPricing(items);
		//Scanning a set of codes together
		t.scan(new String[] {"C","C","C","C","C","C","C"});
		Assert.assertEquals(t.getTotal(), Double.valueOf(7.25d));
	}
	
	@Test
	public void testCaseThree() {
		Terminal t = new BaseTerminal();
		t.setPricing(items);
		t.scan(new String[] {"A","B","C","D"});
		Assert.assertEquals(t.getTotal(), Double.valueOf(15.4d));
	}

}
