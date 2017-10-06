package com.store.services;

import java.util.List;

import com.store.models.StoreItem;

public interface StoreService {
	public StoreItem getItemByProductCode(String productCode);
	public void init(List<StoreItem> items);
}
