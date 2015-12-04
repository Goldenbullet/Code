package express.businesslogicService.financialBLService;

import express.vo.DateAvailableVO;
import express.vo.OperateFormVO;

public interface OperateFinanceBLService extends OperateManagerBLService{

	public OperateFormVO addOperateForm(String beginDate,String endDate);
	
	public boolean checkDateAvailable(String beginDate,String endDate);
}
