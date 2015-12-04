package express.data.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import express.dataService.vehicleAndDriverDataService.DriverDataService;
import express.po.DriverInfoPO;
import express.po.VehicleInfoPO;

public class DriverDataService_stub implements DriverDataService {

	private String driverNumber;
	private String businesshallNumber;
	private String name;
	private String year;
	private String month;
	private String date;
	private String ID;
	private String cellPhone;
	private boolean sex;// men are true,women are false
	private int deadline;
	
	public ArrayList<DriverInfoPO> List=new ArrayList<DriverInfoPO>();

	public DriverDataService_stub(String Number1,String Number2,
			            String n,String y,String m,String d,
			            String id,String cell,boolean is,int ddl){
		 this.driverNumber=Number1;
		 this.businesshallNumber=Number2;
		 this.name=n;
		 this.year=y;
		 this.month=m;
		 this.date=d;
		 this.ID=id;
		 this.cellPhone=cell;
		 this.sex=is;
		 this.deadline=ddl;

		 
	}
	public boolean createDriverInfo(DriverInfoPO po){
		if (po.getname()=="Lu Hailong"){
			return true;
		}
		else {
			return false;
		}
	}
	public ArrayList<DriverInfoPO> getDriverInfoList(){
		System.out.println("We have got DriverInfoList");
		return List;
	}
	public DriverInfoPO getDriverInfo(int index){
		System.out.println("We have got a DriverInfo");
		return List.get(index);
	}
	
	public boolean deleteDriverInfo(int index){
		List.remove(index);
		System.out.println("DriverInfoPO has been removed");		
		return true;
	}
	public boolean changeDriverInfo(DriverInfoPO po){
		System.out.println("DriverInfoPO has been modified");		
		return true;
	}
	@Override
	public boolean changeDriverInfo(DriverInfoPO po, int index)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean writeAllDriverInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
}

