package express.businesslogicService.businessSaleBLService;

import express.vo.ReceiveDocVO;

public interface BusinessSaleReceiveDocumentblService {
	
	public boolean addReceiveDoc(ReceiveDocVO vo);
	
	public ReceiveDocVO getReceiveDoc(String date,String delivermanID);
	
	public boolean isDateAvailable(String date);
	
	public void endReceiveDoc();
	
}
