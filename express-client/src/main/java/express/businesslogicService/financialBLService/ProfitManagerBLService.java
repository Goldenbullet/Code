package express.businesslogicService.financialBLService;

import java.util.ArrayList;

import express.vo.ProfitFormVO;

public interface ProfitManagerBLService {

	public ArrayList<String> getProfitFormListTitle() ;
	
	public ProfitFormVO getProfitForm(String date);
	
	public boolean exportExcel(ProfitFormVO profit);
}
