package express.data.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import express.dataService.organizationDataService.OrganizationDataService;
import express.po.OrganizationPO;

public class OrganizationDataService_stub implements OrganizationDataService{
	

	@Override
	public ArrayList<OrganizationPO> getAllOrgInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizationPO getOrgInfo(int index) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOrgInfo(int index) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeOrgInfo(OrganizationPO po, int index)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean writeAllOrgInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
