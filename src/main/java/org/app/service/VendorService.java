package org.app.service;

import java.util.List;

import org.app.model.VendorModel;

public interface VendorService {

	public boolean isAddNewVendor(VendorModel model);
	public List<VendorModel> getAllVendor();
	public boolean isDeleteVendor(int id);
}
