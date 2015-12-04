package express.businessLogic.statisticBL;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import express.businessLogic.infoManageBL.BankAccount;
import express.businesslogicService.financialBLService.BankAccountBLService;
import express.businesslogicService.financialBLService.ProfitFinanceBLService;
import express.dataService.statisticsDataService.ProfitFormDataService;
import express.po.ProfitFormPO;
import express.rmi.RMIClient;
import express.vo.BankAccountVO;
import express.vo.ProfitFormVO;

public class ProfitStatistic implements ProfitFinanceBLService{
	
	ProfitFormDataService profit;
	
	public ProfitStatistic(){
		profit=RMIClient.getProfitFormObject();
	}

	public ArrayList<String> getProfitFormListTitle() {
		try {
			return profit.getProfitFormListTitle();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ProfitFormVO getProfitForm(String date) {
		try {
			ProfitFormPO po=profit.getProfitForm(date);
			if(po!=null){
				ProfitFormVO vo=transPOToVO(po);
				return vo;
			}
			return null;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ProfitFormVO addProfitForm() {
		BankAccountBLService bank=new BankAccount();
		ArrayList<BankAccountVO> list=bank.showAllBankAccount();
		double income=0,outcome=0,p=0;
		if(list!=null){
			for(BankAccountVO b:list){
				income+=b.getIncome();
				outcome+=b.getOutcome();
			}
			p=income-outcome;
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			String time=format.format(date);
			ProfitFormVO vo=new ProfitFormVO(time,income,outcome,p);
			ProfitFormPO po=transVOToPO(vo);
			try {
				profit.createProfitForm(po);
				profit.writeAllProfitForm();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			return vo;
		}
		
		return null;
	}

	private ProfitFormVO transPOToVO(ProfitFormPO po){
		ProfitFormVO vo=new ProfitFormVO();
		
		vo.setTitle(po.getTitle());
		vo.setIncome(po.getIncome());
		vo.setOutcome(po.getOutCome());
		vo.setProfit(po.getOutCome());
		
		return vo;
	}
	
	private ProfitFormPO transVOToPO(ProfitFormVO vo){
		ProfitFormPO po=new ProfitFormPO();
		
		po.setTitle(vo.getTitle());
		po.setIncome(vo.getIncome());
		po.setOutcome(vo.getOutCome());
		po.setProfit(vo.getOutCome());
		
		return po;
	}
}
