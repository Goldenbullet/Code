package express.data.stub;


import java.rmi.RemoteException;
import java.util.ArrayList;

import express.dataService.strategyDataService.DistanceDataService;
import express.dataService.strategyDataService.PriceDataService;
import express.dataService.strategyDataService.SalaryDataService;
import express.po.CityDistancePO;
import express.po.PricePO;
import express.po.SalaryPO;

public class StrategyDataService_stub implements SalaryDataService,DistanceDataService,PriceDataService{
	
	public StrategyDataService_stub(){
		super();
	}
	
	public boolean makeSalary(SalaryPO po){
		System.out.println("Make succeed.");
		return true;
	}
	
	public boolean makeCityDistance(CityDistancePO po){
		System.out.println("Make succeed.");
		return true;
	}
	
	public boolean makePrice(PricePO po){
		System.out.println("Make succeed.");
		return true;
	}

	@Override
	public boolean addDistanceStrategy(CityDistancePO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ArrayList<CityDistancePO> getAllDistanceStrategy()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeAllDistanceStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSalaryStrategy(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSalaryStrategy(int index) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeSalaryStrategy(SalaryPO po, int index)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<SalaryPO> getAllSalaryStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeAllSalaryStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setPriceStrategy(PricePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PricePO getPriceStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writePriceStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDistanceStrategy(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeDistanceStrategy(CityDistancePO po, String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}
