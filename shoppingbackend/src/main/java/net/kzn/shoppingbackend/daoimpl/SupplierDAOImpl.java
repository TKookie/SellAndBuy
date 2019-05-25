package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.SupplierDAO;
import net.kzn.shoppingbackend.dto.Supplier;


@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * SINGLE
	 * */
	
	@Override
	public Supplier get(int supplierId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Supplier.class,Integer.valueOf(supplierId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	/*
	 * LIST
	 * */
	
	@Override
	public List<Supplier> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM supplier" , Supplier.class)
						.getResultList();
	}

	/*
	 * INSERT
	 * */
	@Override
	public boolean add(Supplier supplier) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(supplier);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(Supplier supplier) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(supplier);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}

	
	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Supplier supplier) {
		try {
			
			supplier.setActive(false);
			// call the update method
			return this.update(supplier);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}

	@Override
	public List<Supplier> listActiveSuppliers() {
		String selectActiveSuppliers = "FROM Supplier WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveSuppliers, Supplier.class)
						.setParameter("active", true)
							.getResultList();
	}

	
	
	@Override
	public List<Supplier> getSuppliersByParam(String param, int count) {
		
		String query = "FROM supplier WHERE active = true ORDER BY " + param + " DESC";
		
		return sessionFactory
					.getCurrentSession()
					.createQuery(query,Supplier.class)
					.setFirstResult(0)
					.setMaxResults(count)
					.getResultList();
					
		
	}
}
