package express.businessLogic.documentBL;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import express.businessLogic.syslogBL.SysLog;
import express.businesslogicService.businessSaleBLService.BusinessSaleShipmentDocumentblService;
import express.businesslogicService.financialBLService.PaymentBLService;
import express.businesslogicService.transcenterSaleBLService.TransCenterSaleShipmentDocblService;
import express.businesslogicService.transcenterSaleBLService.TransCenterTransferDocblService;
import express.dataService.documentDataService.PaymentDocDataService;
import express.po.DeliverDocPO;
import express.po.DocumentPO;
import express.po.PaymentDocPO;
import express.po.PaymentItem;
import express.po.ShipmentDocBusinessHallPO;
import express.po.ShipmentDocTransCenterPO;
import express.po.TransferDocPO;
import express.rmi.RMIClient;
import express.vo.DateAvailableVO;
import express.vo.PaymentDocVO;

public class PaymentDoc implements PaymentBLService{
	
	PaymentDocDataService pay;
	
	public PaymentDoc(){
		pay=RMIClient.getPaymentDocObject();
	}

	public PaymentDocVO createPaymentDoc() {
		TransCenterSaleShipmentDocblService tShip=new ShipmentDocController();
		TransCenterTransferDocblService tTrans=new TransferDoc();
		BusinessSaleShipmentDocumentblService bShip=new ShipmentDocBusinessHall();
		
		Date d=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String dateFactory=format.format(d);
		String currDate=dateFactory.substring(0, 7);
		String date=dateFactory.substring(0, 10);
		
		String cd=dateFactory.substring(5, 7);
		if(cd.charAt(0)=='0')
			cd=cd.substring(1, 2);
		//如果是6月，将06变为6
		
		ArrayList<ShipmentDocTransCenterPO> list1=tShip.getAllShipmentDoc();
		ArrayList<TransferDocPO> list2=tTrans.getAllTransferDoc();
		ArrayList<ShipmentDocBusinessHallPO> list3=bShip.getAllShipmentDoc();
		
		PaymentDocVO payment=new PaymentDocVO();
		ArrayList<PaymentItem> payList=new ArrayList<PaymentItem>();
		
		DateFormat f=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

		payment.setID(dateFactory);
		//将日期设置为id
		
		//处理ShipmentDocTransCenterPO
		if(!isEmpty(list1)){
			
			for(ShipmentDocTransCenterPO po:list1){
				String dt=po.getdate();
				if(dt.startsWith(currDate)){
					PaymentItem p=new PaymentItem(null,dt,null,
							"运费",po.getshipmentID(),po.getmoney());
					
					payList.add(p);
				}
			}
			
		}
		
		//处理TransferDocPO
		if(!isEmpty(list2)){
			for(TransferDocPO po:list2){
				String dt=po.getdate();
				if(dt.startsWith(currDate)){
					PaymentItem p=new PaymentItem(null,dt,null,
							"运费",null,po.getmoney());
					
					payList.add(p);
				}
			}
		}
		
		//处理ShipmentDocBusinessHallPO
			
		return null;
	}
	
	/**
	 * 
	 * @param list
	 * @return 判断list是否为空
	 */
	
	private boolean isEmpty(ArrayList<? extends DocumentPO> list){
		if(list==null)
			return true;
		if(list.size()==0)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param list
	 * @param cd
	 * @return ShipmentDocTransCenterPO运费的总和
	 */
	
	private double calFare1(ArrayList<ShipmentDocTransCenterPO> list,String cd){
		double sum=0;
		for(ShipmentDocTransCenterPO po:list){
			String date=po.getdate().substring(0, 7);
			if(date.equals(cd)){
				sum+=po.getmoney();
			}
		}
		return sum;
	}
	
	/**
	 * 
	 * @param list
	 * @param cd
	 * @return TransferDocPO运费的总和
	 */
	
	private double calFare2(ArrayList<TransferDocPO> list,String cd){
		double sum=0;
		for(TransferDocPO po:list){
			String date=po.getdate().substring(0, 7);
			if(date.equals(cd)){
				sum+=po.getmoney();
			}
		}
		return sum;
	}
	
	/**
	 * 
	 * @param list
	 * @param cd
	 * @return ShipmentDocBusinessHallPO运费的总和
	 */
	
	private double calFare3(ArrayList<ShipmentDocBusinessHallPO> list,String cd){
		double sum=0;
		for(ShipmentDocBusinessHallPO po:list){
			String date=po.getDate().substring(0, 7);
			if(date.equals(cd)){
				sum+=po.getMoney();
			}
		}
		return sum;
	}
	
	public boolean addPaymentDoc(PaymentDocVO vo) {
		
		return true;
	}
	
	public ArrayList<PaymentDocVO> getUnexamedPaymentDoc(){
		try{
		ArrayList<PaymentDocPO> list=pay.getAllPaymentDoc();
		ArrayList<PaymentDocVO> unexam=new ArrayList<PaymentDocVO>();
		
		if(list==null)
			return unexam;
		
		for(PaymentDocPO po:list){
			if(!po.getState()){
				PaymentDocVO vo=new PaymentDocVO(po.getPaymentList(),
						po.getSum(),po.getPaymentID());
				
				unexam.add(vo);
			}
		}
		return unexam;

		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public PaymentDocVO getPaymentDoc(String id) {
		try {
			PaymentDocPO po = pay.getPaymentDoc(id);
			
			if(po==null)
				return null;
			
			PaymentDocVO vo = new PaymentDocVO(po.getPaymentList(),
					po.getSum(), po.getPaymentID());
			
			return vo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean checkDateAvailable(String date) {
		Date d=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM");
		String currDate=format.format(d);
		
		date = date.substring(0, 7);
		
		if(currDate.equals(date))
			return true;
		else
			return false;
	}

	public void endPaymentDoc() {
		SysLog log=new SysLog();
		log.addSysLog("生成付款单");
		
		try {
			pay.writeAllPaymentDoc();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean changePaymentDoc(PaymentDocVO vo, String id) {
		
		PaymentDocPO po=new PaymentDocPO(vo.getPaymentList(),
				vo.getSum(),vo.getPaymentID());
		
		try {
			return pay.changePaymentDoc(po, id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
