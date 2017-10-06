package com.store.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.store.models.SaleRecord;
import com.store.models.StoreItem;

public class BaseSaleRecordService implements SaleRecordService {
	private final List<SaleRecord> records = new ArrayList<SaleRecord>();

	@Override
	public void recordSales(List<SaleRecord> records) {
		this.records.addAll(records);
	}

	@Override
	public void recordSale(SaleRecord record) {
		records.add(record);
	}

	@Override
	public Double getSalesTotal() {
		Map<StoreItem, Long> itemsByCount = records.stream().collect(
				Collectors.groupingBy(SaleRecord::getItem, Collectors.counting()));
		Double total = 0d;
		for (Map.Entry<StoreItem, Long> entry : itemsByCount.entrySet()) {
			StoreItem item = entry.getKey();
			Long quantity = entry.getValue();
			total = total + getActualPrice(item,quantity);
		}
		return total;
	}

	private Double getActualPrice(StoreItem i, Long quantity) {
		Map<Long,Double> priceByQuantity = i.getPriceByQuantity();
		Double basePrice = i.getBasePrice();
		
		//Get valid subset values (Reverse sorted)
		List<Long> subset = priceByQuantity.keySet().stream()
				.filter(x -> x <= quantity).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		Double total = 0d;
		Long remaining = quantity;
		
		//Calculate for each subset value
		for (Long f : subset) {
			if(remaining<f){
				continue;
			}
			Double price = priceByQuantity.get(f);
			total += price * Math.floor(remaining / f) * f;
			remaining = remaining % f;
		}

		if (remaining > 0) {
			total += basePrice * remaining;
		}

		return total;

	}

}
