package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Supplier;


public interface SupplierDAO {
	Supplier get(int id);
	List<Supplier> list();
	boolean add(Supplier supplier);
	boolean update(Supplier supplier);
	boolean delete(Supplier supplier);
	
	List<Supplier> getSuppliersByParam(String param, int count);	
	
	List<Supplier> listActiveSuppliers();	
	
}
