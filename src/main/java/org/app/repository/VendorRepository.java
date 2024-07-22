package org.app.repository;

import java.util.List;

import org.app.model.VendorModel;

public interface VendorRepository {

	public boolean isAddNewVendor(VendorModel model);
	public List<VendorModel> getAllVendor();
	public boolean isDeleteVendor(int id);
}
