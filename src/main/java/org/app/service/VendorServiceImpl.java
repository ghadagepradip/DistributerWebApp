package org.app.service;

import java.util.List;

import org.app.model.VendorModel;
import org.app.repository.VendorRepositoryImpl;

public class VendorServiceImpl implements VendorService {

	VendorRepositoryImpl vendorepo = new VendorRepositoryImpl();
	public boolean isAddNewVendor(VendorModel model)
	{
		return vendorepo.isAddNewVendor(model);
	}
	@Override
	public List<VendorModel> getAllVendor() {
		return vendorepo.getAllVendor();
	}
	@Override
	public boolean isDeleteVendor(int id) {
		return vendorepo.isDeleteVendor(id);
	}
}
