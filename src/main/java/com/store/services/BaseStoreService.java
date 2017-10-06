package com.store.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.store.models.StoreItem;

public class BaseStoreService implements StoreService {
	private Map<String, StoreItem> store;

	@Override
	public StoreItem getItemByProductCode(String productCode) {
		return this.store.get(productCode);
	}
	
	@Override
	public void init(List<StoreItem> storeItems) {
		this.store = storeItems.stream()
				.collect(Collectors.toMap(x -> x.getProductCode(), x -> x));
	}

}
