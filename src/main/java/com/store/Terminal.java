package com.store;

import java.util.List;

import com.store.models.StoreItem;

public interface Terminal {
	public Double getTotal();
	public void scan(String productCode);
	public void scan(String[] productCodes);
	public void setPricing(List<StoreItem> items);
}
