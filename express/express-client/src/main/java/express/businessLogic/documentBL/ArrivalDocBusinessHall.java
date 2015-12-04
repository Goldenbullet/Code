package express.businessLogic.documentBL;

import express.businesslogicService.businessSaleBLService.BusinessSaleArrivalDocumentblService;
import express.dataService.documentDataService.BusinessSaleArrivalDocumentDataService;
import express.vo.ArrivalDocBusinessHallVO;
import express.rmi.RMIClient;

public class ArrivalDocBusinessHall implements BusinessSaleArrivalDocumentblService{

	BusinessSaleArrivalDocumentDataService rmiObj;
	
	public ArrivalDocBusinessHall(){
		rmiObj=RMIClient.getBusinessHallArrivalDocObject();
	}
	
	public boolean addArrivalDoc(ArrivalDocBusinessHallVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrivalDocBusinessHallVO getArrivalDoc(String OrderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void endArrivalDoc() {
		// TODO Auto-generated method stub
		
	}
	
	public String getTransferDocID(String orderID){
		return null;
	}
	
	

}
