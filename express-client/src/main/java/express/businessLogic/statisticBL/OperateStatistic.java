package express.businessLogic.statisticBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import express.businessLogic.documentBL.SumReceiveDoc;
import express.businesslogicService.businessSaleBLService.GetReceiveDocBLService;
import express.businesslogicService.financialBLService.OperateFinanceBLService;
import express.dataService.statisticsDataService.OperateFormDataService;
import express.po.OperateFormPO;
import express.po.ReceiveDocPO;
import express.rmi.RMIClient;
import express.vo.OperateFormVO;
import express.vo.ReceiveDocVO;

public class OperateStatistic implements OperateFinanceBLService{

	OperateFormDataService operate;
	
	public OperateStatistic(){
		operate=RMIClient.getOperateFormObject();
	}
	
	public ArrayList<String> getOperateFormListTitle() {
		try {
			return operate.getOperateFormListTitle();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public OperateFormVO getOperateForm(int index) {
		try {
			
			OperateFormPO po=operate.getOperateForm(index);
			if(po!=null){
				OperateFormVO vo=transPOToVO(po);
				return vo;
			}
			return null;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public OperateFormVO addOperateForm(String beginDate, String endDate) {
		GetReceiveDocBLService l=new SumReceiveDoc();
		ArrayList<ReceiveDocVO> list=l.getAllReceiveDoc();
		if(list==null)
			return null;
		ArrayList<ReceiveDocVO> select=new ArrayList<ReceiveDocVO>();
		ArrayList<ReceiveDocPO> s=new ArrayList<ReceiveDocPO>();
		for(ReceiveDocVO vo:list){
			String date=vo.getReceiveDate();
			if(date.compareTo(beginDate)>=0&&date.compareTo(endDate)<=0){
				select.add(vo);
				s.add(new ReceiveDocPO(vo.getReceiveDate(),
						vo.getReceivePrice(),vo.getDeliverManID(),
						vo.getAllOrderIDs(),vo.getOrgID()));
			}
		}
		if(select.isEmpty())
			return null;
		
		try {
			operate.createOperateForm(new OperateFormPO(beginDate,endDate,s));
			operate.writeAllOperateForm();
			return new OperateFormVO(beginDate,endDate,select);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean checkDateAvailable(String beginDate, String endDate) {
		if(beginDate.compareTo(endDate)>0)
			return false;
		return true;
	}
	
	private OperateFormVO transPOToVO(OperateFormPO po){
		OperateFormVO vo=new OperateFormVO();
		
		vo.setEndDate(po.getEndDate());
		ArrayList<ReceiveDocPO> list=po.getReceiveDoc();
		if(list==null)
			vo.setReceiveDoc(null);
		else if(list.size()==0)
			vo.setReceiveDoc(null);
		else{
			ArrayList<ReceiveDocVO> l=new ArrayList<ReceiveDocVO>();
			for(ReceiveDocPO i:list){
				l.add(new ReceiveDocVO(i.getReceiveDate(),
						i.getReceivePrice(),i.getDeliverManID(),
						i.getAllOrderIDs(),i.getOrgID()));
			}
			vo.setReceiveDoc(l);
		}
		vo.setStartDate(po.getStartDate());
		
		return vo;
	}

}
