package express.businesslogicService.businessSaleBLService;

import java.util.ArrayList;

import express.vo.ReceiveDocVO;

public interface GetReceiveDocBLService {

	public ArrayList<ReceiveDocVO> getAllReceiveDoc();
	
	public ArrayList<ReceiveDocVO> getReceiveDocList(String date,String orgID);
	
	public double getSum(ArrayList<ReceiveDocVO> list,String bankAccountID);
	
	public void endManage();
}