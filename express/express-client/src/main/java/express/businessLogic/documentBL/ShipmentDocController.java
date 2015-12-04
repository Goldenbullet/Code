package express.businessLogic.documentBL;

import express.businesslogicService.transcenterSaleBLService.TransCenterSaleShipmentDocblService;
import express.vo.ShipmentDocTransCenterVO;

public class ShipmentDocController implements TransCenterSaleShipmentDocblService{
	ShipmentDocTransCenter shipmentdoc=new ShipmentDocTransCenter();
	ShipmentDocCheck shipmentdocchecker= new ShipmentDocCheck();
	
			public boolean addShipmentDoc(ShipmentDocTransCenterVO vo){
					if(isTransIDavailable(vo.gettranscenterNumber())){
						return shipmentdoc.addShipmentDoc(vo);
						
					}
					else {
						return false;
					}	
			}
	
			
			
			public ShipmentDocTransCenterVO getShipmentDoc(String shipmentID){
				
				return shipmentdoc.getShipmentDoc(shipmentID);
			}
			
			public void endShipmentDoc(){
				
			}

			public boolean isTransIDavailable(String transid) {
				return shipmentdocchecker.isTransIDavailable(transid);
			}
}
