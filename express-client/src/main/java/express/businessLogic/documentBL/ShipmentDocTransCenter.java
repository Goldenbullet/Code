package express.businessLogic.documentBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import express.businessLogic.syslogBL.SysLog;
import express.businesslogicService.managerBLService.SysLogBLService;
import express.businesslogicService.transcenterSaleBLService.TransCenterSaleShipmentDocblService;
import express.dataService.documentDataService.TransCenterShipmentDocDataService;
import express.po.DeliverDocPO;
import express.po.ShipmentDocBusinessHallPO;
import express.po.ShipmentDocTransCenterPO;
import express.vo.ShipmentDocTransCenterVO;
import express.rmi.RMIClient;

public class ShipmentDocTransCenter {   //不用implements
	TransCenterShipmentDocDataService rmiObj;
	
	public ShipmentDocTransCenter(){
		rmiObj=RMIClient.getShipmentDocObject();
	}
	
	public boolean addShipmentDoc(ShipmentDocTransCenterVO vo){
		ShipmentDocTransCenterPO po=new ShipmentDocTransCenterPO(vo.getdate(), vo.gettranscenterNumber(),vo.getarrival(), vo.getvin(),
											vo.getcheckMan(), vo.gettransMan(), vo.getshipmentID(), vo.getOrderID(), vo.getmoney());
		
		ArrayList<String> idlist=vo.getOrderID();
		for(String id:idlist){
			if(!isOrderIDavailable(id))
				return false;
		}
		
		try{
			rmiObj.createShipmentDoc(po);
			}catch(Exception e){
				e.printStackTrace();
			}
		
			return true;
	}
	
	
	
	
	public ShipmentDocTransCenterVO getShipmentDoc(String shipmentID) {
		
			try{
				ShipmentDocTransCenterPO po=rmiObj.getShipmentDoc(shipmentID);
				ShipmentDocTransCenterVO vo=new ShipmentDocTransCenterVO(po.getdate(), po.gettranscenterNumber(),po.getarrival(), po.getvin(),
						po.getcheckMan(), po.gettransMan(), po.getshipmentID(), po.getOrderID(), po.getmoney());
				return vo;
			}catch(Exception e){
				e.printStackTrace();
			}
		return null;

	}
	
	public ArrayList<ShipmentDocTransCenterPO> getUnexamedShipmentDoc(){
		try{
		ArrayList<ShipmentDocTransCenterPO> list=rmiObj.getShipmentDoclist();
		ArrayList<ShipmentDocTransCenterPO> unexam=new ArrayList<ShipmentDocTransCenterPO>();
		int len=list.size();
		for(int i=0;i<len;i++){
			if(list.get(i).getState()==false){
				unexam.add(list.get(i));
			}
		}
		return unexam;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public void  endShipmentDoc(){
		SysLogBLService syslog=new SysLog();
		syslog.addSysLog("生成中转中心装车单");
		try{
			rmiObj.writeAllShipmentDoc();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public boolean isOrderIDavailable(String id){
		CheckOrder checker=new CheckOrder();
		return checker.isOrderIDAvailable(id);
	}
	
	public ArrayList<ShipmentDocTransCenterPO>  getAllShipmentDoc(){
		try {
			ArrayList<ShipmentDocTransCenterPO> shipmentdoclist=rmiObj.getShipmentDoclist();
			return shipmentdoclist;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
