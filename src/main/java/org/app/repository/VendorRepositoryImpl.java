package org.app.repository;

import java.util.ArrayList;
import java.util.*;

import org.app.model.VendorModel;

public class VendorRepositoryImpl extends DBParent implements VendorRepository {

	List<VendorModel>list;
	@Override
	public boolean isAddNewVendor(VendorModel model) {
		
		try
		{
			stmt=conn.prepareStatement("insert into vendor values('0',?)");
			stmt.setString(1, model.getName());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);		
			return false;
		}
	}

	@Override
	public List<VendorModel> getAllVendor() {
		
		try
		{
			list=new ArrayList<VendorModel>();
			stmt=conn.prepareStatement("select * from vendor");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				VendorModel model=new VendorModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				this.list.add(model);
			}
			return (list==null)?null:list;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return null;
		}
		
	}

	@Override
	public boolean isDeleteVendor(int id) {
		
		try
		{
			stmt=conn.prepareStatement("delete from vendor where vid=?;");
			stmt.setInt(1,id);
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.print("Error is "+e);
			return false;
		}
		
	}

}
