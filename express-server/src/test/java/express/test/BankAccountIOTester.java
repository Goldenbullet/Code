package express.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import express.data.bankAccountData.BankAccountIO;
import express.po.BankAccountPO;
import junit.framework.TestCase;

public class BankAccountIOTester extends TestCase {

	@Test
	public void test() {
		/*try{
		BankAccountIO bank=new BankAccountIO();
		assertEquals(null,bank.getAllBankAccount());
		BankAccountPO account1=new BankAccountPO("S快递公司",0,0,1000);
		BankAccountPO account2=new BankAccountPO("S快递公司南京分公司",0,0,15000);
		BankAccountPO account3=new BankAccountPO("S快递公司北京分公司",0,0,10000);
		bank.createBankAccount(account1);
		bank.createBankAccount(account2);
		bank.createBankAccount(account3);
		assertEquals(account1,bank.getAllBankAccount().get(0));
		assertEquals(account2,bank.getAllBankAccount().get(1));
		assertEquals(account3,bank.getAllBankAccount().get(2));
		bank.deleteBankAccount("S快递公司南京分公司");
		bank.writeAllBankAccount();
		assertEquals(account1.getName(),bank.getAllBankAccount().get(0).getName());
		assertEquals(account3.getName(),bank.getAllBankAccount().get(1).getName());
		bank.changeBankAccount(account2, 0);
		bank.writeAllBankAccount();
		assertEquals(account2.getName(),bank.getAllBankAccount().get(0).getName());
		BankAccountPO account2=new BankAccountPO("S快递公司南京分公司",0,0,15000, null);
		assertEquals(account2.getName(),bank.getAllBankAccount().get(0).getName());
		BankAccountPO account3=new BankAccountPO("S快递公司上海分公司",0,0,10000, null);
		BankAccountPO account1=new BankAccountPO("S快递公司",0,0,1000, null);
		bank.createBankAccount(account1);
		bank.changeBankAccount(account3, null);
		assertEquals(account3.getName(),bank.getAllBankAccount().get(1).getName());
		assertEquals(account1.getName(),bank.getAllBankAccount().get(2).getName());
		bank.writeAllBankAccount();
		}catch(RemoteException e){
			
		}*/
	}
}
