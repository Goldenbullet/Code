package express.dataService.documentDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import express.po.OutDocPO;

public interface OutDocDataService extends Remote{
	public boolean crateOutDoc(OutDocPO po) throws RemoteException ;
	public OutDocPO getOutDocPO(String deliveryNumber) throws RemoteException;
	public ArrayList<OutDocPO> getOutDocPOlist() throws RemoteException;
}
