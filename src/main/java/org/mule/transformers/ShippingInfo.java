package org.mule.transformers;

public class ShippingInfo {
private	String shippingHandling;
private	String shipMethodCode;
private	String shippingHandlingTax;
	public ShippingInfo(String shippingHandling,String shipMethodCode, String shippingHandlingTax ){
		this.shippingHandling=shippingHandling;
		this.shippingHandlingTax = shippingHandlingTax;
		this.shipMethodCode = shipMethodCode;
	}
	public String getShipMethodCode() {
	    return shipMethodCode;
	}
	
	public String getShippingHandling() {
	    return shippingHandling;
	}
	
	public String getShippingHandlingTax() {
	    return shippingHandlingTax;
	}

}
