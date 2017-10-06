package com.store;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.store.models.SaleRecord;
import com.store.models.StoreItem;
import com.store.services.BaseSaleRecordService;
import com.store.services.BaseStoreService;
import com.store.services.SaleRecordService;
import com.store.services.StoreService;

/**
 * Entry point for the API
 * 
 * @author vorcan
 *
 */
public class BaseTerminal implements Terminal {

	private StoreService storeService;
	private SaleRecordService saleRecordService;

	public BaseTerminal() {
		this.storeService = new BaseStoreService();
		this.saleRecordService = new BaseSaleRecordService();
	}

	@Override
	public Double getTotal() {
		return saleRecordService.getSalesTotal();
	}

	@Override
	public void scan(String productCode) {
		StoreItem item = storeService.getItemByProductCode(productCode);
		saleRecordService.recordSale(new SaleRecord(item));
	}

	@Override
	public void scan(String[] productCodes) {
		List<SaleRecord> records = Arrays.stream(productCodes)
				.map(productCode -> new SaleRecord(storeService.getItemByProductCode(productCode))).collect(Collectors.toList());
		saleRecordService.recordSales(records);
	}

	@Override
	public void setPricing(List<StoreItem> items) {
		storeService.init(items);
	}

}
