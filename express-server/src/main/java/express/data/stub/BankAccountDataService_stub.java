package express.data.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import express.dataService.bankAccountDataService.BankAccountDataService;
import express.po.BankAccountPO;

public class BankAccountDataService_stub implements BankAccountDataService{
	BankAccountPO bankAccount;
	
	
	public boolean createBankAccount(BankAccountPO bankAccount){
		return true;
	}
	
	public boolean deleteBankAccount(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean changeBankAccount(BankAccountPO bankAccount){
		return true;
	}
	public ArrayList<BankAccountPO> getAllBankAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<BankAccountPO> getBankAccount(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean changeBankAccount(BankAccountPO bankAccount, int index) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean writeAllBankAccount() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeBankAccount(BankAccountPO bankAccount, String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
