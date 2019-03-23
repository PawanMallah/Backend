package Projectbackend.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.cglib.core.Block;



@Table
@Entity
public class Product {
	
	@Id
	@GeneratedValue
	int productId;
	String productName;
	String productDesc;
	String supplierName;
	int price;
	byte[] ProductImage;
	
	public byte[] getProductImage() {
		return ProductImage;
	}
	public void setProductImage(byte[] productImage) {
		ProductImage = productImage;
	}
	public Product()
	{}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
