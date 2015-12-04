package express.data.documentData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import express.dataService.documentDataService.BusinessSaleArrivalDocumentDataService;
import express.po.ArrivalDocBusinessHallPO;

public class ArrivalDocBusinessHallIO extends UnicastRemoteObject implements BusinessSaleArrivalDocumentDataService{

	public ArrivalDocBusinessHallIO() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createArrivalDoc(ArrivalDocBusinessHallPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrivalDocBusinessHallPO getArrivalDoc(String OrderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeAllArrivalDoc() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ArrivalDocBusinessHallPO> getArrivalDoclist() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
