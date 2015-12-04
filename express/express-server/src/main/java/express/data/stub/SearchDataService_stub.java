package express.data.stub;

import java.util.ArrayList;

import express.dataService.documentDataService.SearchDataService;
import express.po.GoodTransStatusPO;

public class SearchDataService_stub implements SearchDataService{
	String orderID;
	ArrayList<String> time;
	String firstBusinessHallID;
	String firsttransCenterID;
	String secondtransCenterID;
	String secondBusinessHallID;
	String deliverManID;
	
	public SearchDataService_stub(String OrderID,ArrayList<String> time,
			String firstBusinessHallID,String firsttransCenterID,String secondtransCenterID,
			String secondBusinessHallID,String deliverManID){
		this.orderID=orderID;
		this.time=time;
		this.firstBusinessHallID=firstBusinessHallID;
		this.firsttransCenterID=firsttransCenterID;
		this.secondtransCenterID=secondtransCenterID;
		this.secondBusinessHallID=secondBusinessHallID;
		this.deliverManID=deliverManID;
	}

	public GoodTransStatusPO search(String id){
		if(id.equals("0000000001")){
			GoodTransStatusPO gt=new GoodTransStatusPO();
			gt.setOrderID(orderID);
			gt.setTime(time);
			gt.setFirsttransCenterID(firsttransCenterID);
			gt.setFirstBusinessHallID(firstBusinessHallID);
			gt.setSecondBusinessHallID(secondBusinessHallID);
			gt.setSecondtransCenterID(secondtransCenterID);
			gt.setDeliverManID(deliverManID);
			return gt;
		}
		else{
			System.out.println("Not found");
			return null;
		}
	}
}
