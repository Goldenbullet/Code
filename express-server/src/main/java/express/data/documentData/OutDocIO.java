package express.data.documentData;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import express.data.IOHelper.IOHelper;
import express.dataService.documentDataService.OutDocDataService;
import express.po.OutDocPO;
import express.po.TransferDocPO;

public class OutDocIO extends UnicastRemoteObject implements OutDocDataService{

	public ArrayList<OutDocPO> outDoclist;
	public String filepath="SerializableData/AROutDoc.ser";
	
	
	public OutDocIO() throws RemoteException {
		super();
		outDoclist=new ArrayList<OutDocPO>();
		try{
			IOHelper io=new IOHelper();
			outDoclist=(ArrayList<OutDocPO>) io.readFromDisk(filepath);
		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}	
	}


	@Override
	public boolean crateOutDoc(OutDocPO po) throws RemoteException {
		System.out.println("writing...deliverdoc......");
		outDoclist.add(po);
		return true;
	}


	@Override
	public OutDocPO getOutDocPO(String deliveryNumber) throws RemoteException {
		for(OutDocPO po:outDoclist){
			if(po.getdeliveryNumber().equals(deliveryNumber)){
				return po;
			}
		}
		return null;
	}


	@Override
	public ArrayList<OutDocPO> getOutDocPOlist() throws RemoteException {
		
		return outDoclist;
		
	}

}
