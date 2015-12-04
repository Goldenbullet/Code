package express.dataService.documentDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import express.po.PaymentDocPO;

public interface PaymentDocDataService extends Remote{

	public boolean createPaymentDoc(PaymentDocPO payment) throws RemoteException;
	
	public boolean changePaymentDoc(PaymentDocPO payment,int index) throws RemoteException;
	
	public PaymentDocPO getPaymentDoc(String id) throws RemoteException;
	
	public ArrayList<PaymentDocPO> getAllPaymentDoc() throws RemoteException;
	
	public boolean writeAllPaymentDoc() throws RemoteException;
}
