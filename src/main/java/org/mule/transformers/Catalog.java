package org.mule.transformers;

public class Catalog {
private String	catalogitem;
public String	gift="0";
public String	giftcharge="0.0";
private String		sku;
private String		quantity;
private String		unitPrice;
private String		lineTax;
private String		initialprice;
public Catalog(String catalogitem, String quantity,String unitPrice, String lineTax){
	this.catalogitem = catalogitem;
	
	this.lineTax = lineTax;
	this.quantity = quantity;
	this.unitPrice = unitPrice;
	
	this.sku = this.catalogitem;
	this.initialprice = this.unitPrice;
}

public void setCatalogitem(String catalogitem ){
	this.catalogitem=catalogitem;
}
public String getCatalogitem(){
	return catalogitem;
}

public void setSku(String sku ){
	this.sku=sku;
}

public String getSku(){
	return sku;
}

public void setUnitPrice(String unitPrice){
	this.unitPrice=unitPrice;
}

public String getUnitPrice(){
	return unitPrice;
}

public void setLineTax(String lineTax){
	this.lineTax=lineTax;
}

public String getLineTax(){
	return lineTax;
}

public void setInitialprice(String initialprice){
	this.initialprice=initialprice;
}

public String getInitialprice(){
	return initialprice;
}


public void setQuantity(String quantity ){
	this.quantity=quantity;
}

public String getQuantity(){
	return quantity;
}



}
