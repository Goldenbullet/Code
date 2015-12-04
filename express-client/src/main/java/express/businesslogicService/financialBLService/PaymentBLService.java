package express.businesslogicService.financialBLService;

import express.vo.DateAvailableVO;
import express.vo.PaymentDocVO;

public interface PaymentBLService {

	public boolean addPaymentDoc(PaymentDocVO payment);
	
	public PaymentDocVO getPaymentDoc(String id);
	
	public DateAvailableVO checkDateAvailable(String date);
	
	public void endPaymentDoc();
}
