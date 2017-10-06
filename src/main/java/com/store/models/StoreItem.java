package com.store.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreItem {
	private String productCode;
	private Double basePrice;
	private Map<Long, Double> priceByQuantity = new HashMap<Long, Double>();

	public Map<Long, Double> getPriceByQuantity() {
		return priceByQuantity;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public String getProductCode() {
		return productCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productCode == null) ? 0 : productCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreItem other = (StoreItem) obj;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setPriceByQuantity(Map<Long, Double> priceByQuantity) {
		this.priceByQuantity = priceByQuantity;
	}
	
	/**
	 * Calculate a price-per-item and add it to the priceByQuantityMap
	 * @param quantity Quantity for which the price-per-item is calculated
	 * @param price Price for the given quantity, used to calculate price-per-item
	 */
	public void addPriceQuantityMapping(Long quantity, Double price) {
		Double ratio = price / quantity;
		priceByQuantity.put(quantity, ratio);
	}

	public void addPriceQuantityMapping(Integer quantity, Double price) {
		Double ratio = price / quantity;
		priceByQuantity.put(quantity.longValue(), ratio);
	}
}
