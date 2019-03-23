package Projectbackend.dao;

import Projectbackend.pojo.Supplier;
import Projectbackend.pojo.User;

public interface SupplierDAO {
	public boolean AddSupplier(Supplier supplier);
	public boolean DeleteSupplier(Supplier supplier);
	public boolean UpdateSupplier(Supplier supplier);
	public String getSupplierpass(String email);
	public boolean CheckSupplierLogin(String email,String Pass);
	public Supplier SupplierDetails(String email);
	public boolean ExistSupplierEmail(String email);

}
