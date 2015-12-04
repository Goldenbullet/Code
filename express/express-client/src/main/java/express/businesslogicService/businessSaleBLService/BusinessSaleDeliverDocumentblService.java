package express.businesslogicService.businessSaleBLService;

import java.util.ArrayList;

import express.po.DeliverDocPO;
import express.vo.DeliverDocVO;

public interface BusinessSaleDeliverDocumentblService {
	public boolean addDeliverDoc(DeliverDocVO vo);
	public DeliverDocVO getDeliverDoc(String OrderID);
	public boolean isOrderIDavailable(String id);  
	public ArrayList<DeliverDocPO> getUnexamedDeliverDoc();
	public void endDeliverDoc();
	
}
