package com.store.models;

public class SaleRecord {
	private StoreItem item;

	public StoreItem getItem() {
		return item;
	}

	public void setItem(StoreItem item) {
		this.item = item;
	}

	public SaleRecord(StoreItem item) {
		super();
		this.item = item;
	}
	
}
