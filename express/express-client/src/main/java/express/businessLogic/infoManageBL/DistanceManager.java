package express.businessLogic.infoManageBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import express.dataService.strategyDataService.DistanceDataService;
import express.po.CityDistancePO;
import express.vo.CityDistanceVO;
import express.rmi.RMIClient;

public class DistanceManager {
	
	public double getTwoCityDistance(String city1,String city2){
		DistanceDataService rmiObj=RMIClient.getDistanceStrategy();
		try{
			ArrayList<CityDistancePO> arr=rmiObj.getAllDistanceStrategy();
			int len=arr.size();
			for(int i=0;i<len;i++){
				CityDistancePO po=arr.get(i);
				if(po.getCity1().equals(city1)&&po.getCity2().equals(city2)){
					return po.getDistance();
				}
				if(po.getCity1().equals(city2)&&po.getCity2().equals(city1)){
					return po.getDistance();
				}
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;   //not find	
	}
	
	public boolean setTwoCityDistance(CityDistanceVO vo){  //改变现有的城市距离
		DistanceDataService rmiObj=RMIClient.getDistanceStrategy();
		CityDistancePO po=new CityDistancePO(vo.getCity1(), vo.getCity2(), vo.getDistance(), vo.getID());
		try{
		rmiObj.changeDistanceStrategy(po, vo.getID());
		return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean addDistanceStrategy(CityDistanceVO vo){
		DistanceDataService rmiObj=RMIClient.getDistanceStrategy();
		CityDistancePO po=new CityDistancePO(vo.getCity1(), vo.getCity2(), vo.getDistance(), vo.getID());
		try{
			rmiObj.addDistanceStrategy(po);
			return true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return false;	
	}
	
	
	public boolean deleteDistanceStrategy(CityDistanceVO vo){
		DistanceDataService rmiObj=RMIClient.getDistanceStrategy();
		try {
			rmiObj.deleteDistanceStrategy(vo.getID());
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
//	public static void main(String[] args){
//		try{
//			
//			RMIClient.init();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		DistanceManager dm=new DistanceManager();
//		System.out.println(dm.getTwoCityDistance("BeiJing", "NanJing"));
//	}
}
