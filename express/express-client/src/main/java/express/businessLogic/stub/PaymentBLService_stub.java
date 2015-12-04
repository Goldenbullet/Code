package express.businessLogic.stub;

import express.businesslogicService.financialBLService.PaymentBLService;
import express.vo.DateAvailableVO;
import express.vo.PaymentDocVO;

public class PaymentBLService_stub implements PaymentBLService{
	
	PaymentDocVO payment;
	
	public PaymentBLService_stub(PaymentDocVO payment){
		this.payment=payment;
	}

	public boolean addPaymentDoc(PaymentDocVO payment){
		System.out.println("Add payment");
		return true;
	}
	
	public PaymentDocVO getPaymentDoc(String id){
		System.out.println("Get payment");
		return payment;
	}
	
	public DateAvailableVO checkDateAvailable(String date){
		if(date.equals("2015-10-26"))
			return DateAvailableVO.Found;
		else
			return DateAvailableVO.NotFound;
	}
	
	public void endPaymentDoc(){
		System.out.println("2015-10-25 10:50:40"+"管理成本");
	}
}
