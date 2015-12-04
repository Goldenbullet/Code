package express.data.stub;

import java.util.ArrayList;

import express.dataService.documentDataService.BusinessSaleReceiveDocumentDataService;
import express.po.ReceiveDocPO;


public class BusinessSaleReceiveDocumentDataService_stub implements BusinessSaleReceiveDocumentDataService {
	private String receiveDate;
	private double receivePrice;
	private String deliverManID;
	private ArrayList<String> allOrderIDs;
	
	public BusinessSaleReceiveDocumentDataService_stub(String receiveDate,double receivePrice,String deliverManID,ArrayList<String> allOrderIDs){
		this.receiveDate=receiveDate;
		this.receivePrice=receivePrice;
		this.deliverManID=deliverManID;
		this.allOrderIDs=allOrderIDs;
	}
	public boolean createReceiveDoc(ReceiveDocPO po){
		if (po.getDeliverManID()=="Lu Hailong"){
			return true;
		}
		else {
			return false;
		}
	}
	public ReceiveDocPO getReceiveDoc(String date){
		System.out.println("we have found an ReceiveDoc");
		return null;
	}
	
}
