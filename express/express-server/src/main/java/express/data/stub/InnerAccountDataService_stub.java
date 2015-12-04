package express.data.stub;

import java.util.ArrayList;

import express.dataService.innerAccountDataService.InnerAccountDataService;
import express.po.BankAccountPO;
import express.po.InDocPO;
import express.po.InnerAccountPO;
import express.po.OrganizationPO;
import express.po.UserInfoPO;
import express.po.VehicleInfoPO;

public class InnerAccountDataService_stub implements InnerAccountDataService{
	UserInfoPO user;
	OrganizationPO organization;
	InDocPO inDoc;
	VehicleInfoPO vehicle;
	BankAccountPO bankAccount;
	String id;
	ArrayList<UserInfoPO> userInfo=new ArrayList<UserInfoPO>();
	ArrayList<OrganizationPO> organizationInfo=new ArrayList<OrganizationPO>();
	ArrayList<InDocPO> inDocList=new ArrayList<InDocPO>();
	ArrayList<VehicleInfoPO> vehicleInfo=new ArrayList<VehicleInfoPO>();
	ArrayList<BankAccountPO> bankAccountInfo=new ArrayList<BankAccountPO>();
	
	public InnerAccountDataService_stub(UserInfoPO user,OrganizationPO organization,
			InDocPO inDoc,VehicleInfoPO vehicle,BankAccountPO bankAccount,String id){
		this.user=user;
		this.organization=organization;
		this.inDoc=inDoc;
		this.vehicle=vehicle;
		this.bankAccount=bankAccount;
		this.id=id;
		userInfo.add(user);
		organizationInfo.add(organization);
		inDocList.add(inDoc);
		vehicleInfo.add(vehicle);
		bankAccountInfo.add(bankAccount);
	}

	@Override
	public boolean createInnerAccount(InnerAccountPO innerAccount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<InnerAccountPO> getAllInnerAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InnerAccountPO getInnerAccount(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeAllBankAccount() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
