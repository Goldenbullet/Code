package express.businessLogic.documentBL;

import java.util.ArrayList;

import express.businessLogic.infoManageBL.DistanceManager;
import express.businessLogic.syslogBL.SysLog;
import express.businesslogicService.managerBLService.SysLogBLService;
import express.businesslogicService.transcenterSaleBLService.TransCenterTransferDocblService;
import express.dataService.documentDataService.TransCenterTransferDocDataService;
import express.po.TransWay;
import express.po.TransferDocPO;
import express.vo.OrderVO;
import express.vo.TransferDocVO;
import express.rmi.RMIClient;

public class TransferDoc implements TransCenterTransferDocblService{

	TransCenterTransferDocDataService rmiObj;
	
	public TransferDoc(){
		rmiObj=RMIClient.getTransferDocObject();
	}
	
	
	public boolean addTransferDoc(TransferDocVO vo) {
		ArrayList<String> orderlist=vo.getOrderlist();
		for(String id:orderlist){
			if(!isOrderIDavailable(id)){
				return false;
			}	
		}  //check every orderid
		
		if(!isTransIDavailable(vo.gettranscenterNumber())){
			return false;
		}
		
		TransferDocPO po=new TransferDocPO(vo.getdate(), vo.gettranscenterNumber(), vo.getflightNumber(), vo.getbegin(), vo.getarrival(), vo.getcontainerNumber(),vo.getcheckMan(), 
						vo.getmoney(), vo.getTransWay(), vo.getOrderlist());
		
		
		
		try{
			rmiObj.createTransferDoc(po);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}

	public TransferDocVO getTransferDoc(String transID) {
		try{
			TransferDocPO po=rmiObj.getTransferDoc(transID);
			TransferDocVO vo=new TransferDocVO(po.getdate(), po.gettranscenterNumber(), po.getflightNumber(), po.getbegin(), po.getarrival(), po.getcontainerNumber(), 
					po.getcheckMan(), po.getmoney(), po.getTransWay(), po.getOrderlist());
			
			return vo;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public boolean isTransIDavailable(String transid) {
		//  025 0 20010203 0000001
		// 0931 0 20020909 0000002
		//19/20位
		
		if(transid.charAt(0)!='0'){
			return false;
		}
		
		if(transid.length()==19||transid.length()==20){
			for(int i=0;i<transid.length();i++){
				if(transid.charAt(i)>='0'&&transid.charAt(i)<='9'){
					
				}
				else {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
		
	}

	public void endTransferDoc() {
		SysLogBLService syslog=new SysLog();
		syslog.addSysLog("生成中转单");
		try{
			rmiObj.writeAllTransferDoc();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private boolean isOrderIDavailable(String id){
		CheckOrder checker=new CheckOrder();
		return checker.isOrderIDAvailable(id);
	}
	
	public double getTransferFee(TransferDocVO vo){
		DistanceManager disman=new DistanceManager();
		double distance=disman.getTwoCityDistance(vo.getarrival(), vo.getbegin());
		double totalfee=0;
		ArrayList<String> orderlist=vo.getOrderlist();
		OrderController orderctr=new OrderController();
		double totalWeight=0;
		
		try{
			for(String id:orderlist){
				OrderVO orderinstance=orderctr.getOrder(id);				
				totalWeight+=orderinstance.getWeight();
			}
			
			totalWeight=totalWeight/1000;
			totalfee=distance*totalWeight;
			
			if(vo.getTransWay().equals(TransWay.Car)){
				totalfee=totalfee*2;
			}else if ((vo.getTransWay().equals(TransWay.Train))){
				totalfee=totalfee*0.2;
			}else if ((vo.getTransWay().equals(TransWay.Plane))){
				totalfee=totalfee*20;
			}
			
			return totalfee;	
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
}
