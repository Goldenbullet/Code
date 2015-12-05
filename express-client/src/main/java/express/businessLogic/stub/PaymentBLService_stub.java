package express.businessLogic.stub;

import express.businesslogicService.financialBLService.PaymentBLService;
import express.vo.DateAvailableVO;
import express.vo.PaymentDocVO;

public class PaymentBLService_stub implements PaymentBLService{

	@Override
	public PaymentDocVO createPaymentDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentDocVO getPaymentDoc(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkDateAvailable(String date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void endPaymentDoc() {
		// TODO Auto-generated method stub
		
	}
	
	
}
