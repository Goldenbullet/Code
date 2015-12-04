package express.businesslogicService.businessSaleBLService;

import express.vo.ShipmentDocBusinessHallVO;
import express.vo.ShipmentDocTransCenterVO;

public interface BusinessSaleShipmentDocumentblService {
	public boolean addShipmentDoc(ShipmentDocBusinessHallVO vo);
	public ShipmentDocBusinessHallVO getShipmentDoc(String shipmentID) ;
	public double getShipmentfee(ShipmentDocBusinessHallVO vo);
	public void endShipmentDoc();
}
