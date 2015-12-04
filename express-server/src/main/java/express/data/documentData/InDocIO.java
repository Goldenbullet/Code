package express.data.documentData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import express.dataService.documentDataService.InDocDataService;

public class InDocIO extends UnicastRemoteObject implements InDocDataService{

	protected InDocIO() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
