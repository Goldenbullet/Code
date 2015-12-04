package express.data.stub;

import express.dataService.documentDataService.BusinessSaleDeliverDocumentDataService;
import express.po.DeliverDocPO;

public class BusinessSaleDeliverDocumentDataService_stub implements BusinessSaleDeliverDocumentDataService {
	private String arriveDate;
	private String orderID;
	private String deliverManID;//快递员工号
	
	
	
	//consturctor
	public BusinessSaleDeliverDocumentDataService_stub(String arriveDate,String orderID,String deliverManID){
		this.arriveDate=arriveDate;	
		this.orderID=orderID;
		this.deliverManID=deliverManID;
		
	}
	
	public boolean createDeliverDoc(DeliverDocPO po){
		if (po.getDeliverManID()=="Lu Hailong"){
			return true;
		}
		else {
			return false;
		}
	}
	public DeliverDocPO getDeliverDoc(String OrderID){
		System.out.println("we have found an DeliverDoc");
		return null;
	}
	
}
