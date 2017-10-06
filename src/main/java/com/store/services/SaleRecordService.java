package com.store.services;

import java.util.List;

import com.store.models.SaleRecord;

public interface SaleRecordService {
	public void recordSale(SaleRecord record);
	public void recordSales(List<SaleRecord> record);
	public Double getSalesTotal();
}
