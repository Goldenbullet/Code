package express.vo;

import java.util.ArrayList;

public class OperateFormVO {

	private String startDate;
	private String endDate;
	private ArrayList<ReceiveDocVO> receiveDoc;
	
	public OperateFormVO(String startDate,String endDate,ArrayList<ReceiveDocVO> receiveDoc){
		this.startDate=startDate;
        this.endDate=endDate;
		this.receiveDoc=receiveDoc;
	}
	public OperateFormVO(){
		this.startDate=null;
        this.endDate=null;
		this.receiveDoc=null;
	}
	public String getStartDate(){
		return startDate;
	}
    public String getEndDate(){
		return endDate;
	}
	public ArrayList<ReceiveDocVO> getReceiveDoc(){
		return receiveDoc;
	}
	public void setStartDate(String d){
		startDate=d;
	}
	public void setEndDate(String d){
		endDate=d;
	}
	public void setReceiveDoc(ArrayList<ReceiveDocVO> r){
		receiveDoc=r;
	}
}
