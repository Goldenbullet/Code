package express.businesslogicService.transcenterSaleBLService;

import express.vo.ShipmentDocTransCenterVO;

public interface TransCenterSaleShipmentDocblService {
	public boolean addShipmentDoc(ShipmentDocTransCenterVO vo);
	public ShipmentDocTransCenterVO getShipmentDoc(String shipmentID) ;
	public boolean isTransIDavailable(String transid);
	
	public void endShipmentDoc();
}
