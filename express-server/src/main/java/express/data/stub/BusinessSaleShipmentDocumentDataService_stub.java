package express.data.stub;

import java.util.ArrayList;

import express.dataService.documentDataService.BusinessSaleShipmentDocumentDataService;
import express.po.ShipmentDocPO;


public class BusinessSaleShipmentDocumentDataService_stub implements BusinessSaleShipmentDocumentDataService {
	private String date;
	private String transcenterNumber;
	private String arrival;
	private String vin;
	private String checkMan;
	private String transMan;
	private String shipmentID;
	private ArrayList<String> orderID;
	private double money;
	
	
	public BusinessSaleShipmentDocumentDataService_stub(String d,String transnumber,String ar,String v,String che,
			String transman,String shipmentID,ArrayList<String> orderID,double m){
		this.date=d;
		this.transcenterNumber=transnumber;
		this.arrival=ar;
		this.vin=v;
		this.checkMan=che;
		this.transMan=transman;
		this.shipmentID=shipmentID;
		this.money=m;
	}
	public boolean createShipmentDoc(ShipmentDocPO po){
		if (po.getcheckMan()=="Lu Hailong"){
			return true;
		}
		else {
			return false;
		}
	}
	public ShipmentDocPO getShipmentDoc(String OrderID){
		System.out.println("we have found an ShipmentDoc");
		return null;
	}
	
	
	
	
}
