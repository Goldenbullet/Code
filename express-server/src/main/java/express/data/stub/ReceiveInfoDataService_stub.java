package express.data.stub;

import express.dataService.documentDataService.ReceiveInfoDataService;
import express.po.ReceiveInfoPO;

public class ReceiveInfoDataService_stub implements ReceiveInfoDataService{
	public boolean createReceiveInfo(ReceiveInfoPO po){
	 System.out.println("Receive information has created");
	 return true;
	}
	public ReceiveInfoPO getReceiveInfo(String orderID){
		ReceiveInfoPO x=new ReceiveInfoPO("Jack", "2015-02-01", "0000000001");
		if(orderID.equals("0000000001")){
			return x;
		}
		else{
			System.out.println("NO SUCH ReceiveInfo");
			return null;
		}		
	}
	
	
	
}
