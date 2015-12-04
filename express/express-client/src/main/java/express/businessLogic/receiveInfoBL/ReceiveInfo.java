package express.businessLogic.receiveInfoBL;

import express.businessLogic.documentBL.CheckOrder;
import express.businesslogicService.delivermanBLService.ReceiveInfoBLService;

import express.vo.ReceiveInfoVO;

public class ReceiveInfo implements ReceiveInfoBLService{
	public boolean isOrderIDAvailable(String id){
		CheckOrder checker=new CheckOrder();
		return checker.isOrderIDAvailable(id);
	}
	public boolean addReceiveInfo(ReceiveInfoVO vo){
		return false;
	}
	public void endReceiveInfo(){
		
	}
}
