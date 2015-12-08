package express.data.documentData;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import express.data.IOHelper.IOHelper;
import express.dataService.documentDataService.PredictTimeDataService;
import express.po.HistoryTimePO;
import express.po.PredictTimePO;

public class PredictTimeIO extends UnicastRemoteObject implements PredictTimeDataService{
	ArrayList<PredictTimePO> predictTimelist;
	String filepath="SerializableData/ARPredictTime.ser";
	
	public PredictTimeIO() throws RemoteException {
		super();
		predictTimelist=new ArrayList<PredictTimePO>();
		try{
			IOHelper io=new IOHelper();
			predictTimelist=(ArrayList<PredictTimePO>)io.readFromDisk(filepath);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean addToHistory(HistoryTimePO po) throws RemoteException{
		int len=predictTimelist.size();
		String setout=po.getStartCity();
		String arrival=po.getEndCity();
		for(int i=0;i<len;i++){
			PredictTimePO ptpo=predictTimelist.get(i);
			if(ptpo.getSetOutCity().equals(setout)&&ptpo.getArrivalCity().equals(arrival)){
				ptpo.addHistoryTime(po);
				return true;
			}

		}
		return false;
	}
	
	public PredictTimePO getPredictlist(String startCity,String endCity) throws RemoteException{
		String setout=startCity;
		String arrival=endCity;
		int len=predictTimelist.size();
		for(int i=0;i<len;i++){
			PredictTimePO ptpo=predictTimelist.get(i);
			if(ptpo.getSetOutCity().equals(setout)&&ptpo.getArrivalCity().equals(arrival)){
				return ptpo;
			}
		}
		
		return null;
	}
	
	
	
	
	
	
}
