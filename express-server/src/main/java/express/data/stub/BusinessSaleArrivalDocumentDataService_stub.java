package express.data.stub;

import java.util.ArrayList;

import express.dataService.documentDataService.BusinessSaleArrivalDocumentDataService;
import express.po.ArrivalDocPO;
import express.po.GoodsArrivalStatus;

public class BusinessSaleArrivalDocumentDataService_stub implements BusinessSaleArrivalDocumentDataService {
	private String arriveDate;
	private String transCenterID;//中转中心ID
	private String transferDocID;//中转单ID
	private String departure;//出发地
	private GoodsArrivalStatus arrivalStatus;//枚举类  货物到达状态（损坏、完整、丢失）
	
	public ArrayList<ArrivalDocPO> List=new ArrayList<ArrivalDocPO>();
	
	//constructor
	public BusinessSaleArrivalDocumentDataService_stub(String arriveDate,String transCenterID,
						String transferDocID,String departure,
						GoodsArrivalStatus arrivalStatus){
		
		this.arriveDate=arriveDate;
		this.transCenterID=transCenterID;
		this.transferDocID=transferDocID;
		this.departure=departure;
		this.arrivalStatus=arrivalStatus;	
	}
	public boolean createArrivalDoc(ArrivalDocPO po){
		if (po.getDeparture()=="NanJing"){
			return true;
		}
		else {
			return false;
		}
	}
	public ArrivalDocPO getArrivalDoc(String OrderID){
		System.out.println("we have found an ArrivalDoc");
		return null;
	}
	
}
