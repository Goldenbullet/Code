package express.businessLogic.documentBL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import express.businessLogic.syslogBL.SysLog;
import express.businesslogicService.financialBLService.PaymentBLService;
import express.businesslogicService.managerBLService.SysLogBLService;
import express.data.logData.LogIO;
import express.dataService.documentDataService.PaymentDocDataService;
import express.po.LogPO;
import express.rmi.RMIClient;
import express.vo.DateAvailableVO;
import express.vo.PaymentDocVO;

public class PaymentDoc implements PaymentBLService{
	
	PaymentDocDataService pay;
	
	public PaymentDoc(){
		pay=RMIClient.getPaymentDocObject();
	}

	public boolean addPaymentDoc(PaymentDocVO payment) {
		
		return false;
	}

	public PaymentDocVO getPaymentDoc(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public DateAvailableVO checkDateAvailable(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	public void endPaymentDoc() {
		SysLogBLService log=new SysLog();
		log.addSysLog("生成付款单");
	}

}
