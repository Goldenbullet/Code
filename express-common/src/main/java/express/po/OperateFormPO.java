package express.po;

import java.io.Serializable;
import java.util.ArrayList;

public class OperateFormPO implements Serializable{
	private String startDate;
	private String endDate;
	private ArrayList<ReceiveDocPO> receiveDoc;
	
	public OperateFormPO(String startDate,String endDate,ArrayList<ReceiveDocPO> receiveDoc){
		this.startDate=startDate;
        this.endDate=endDate;
		this.receiveDoc=receiveDoc;
	}
	public OperateFormPO(){
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
	public ArrayList<ReceiveDocPO> getReceiveDoc(){
		return receiveDoc;
	}
	public void setStartDate(String d){
		startDate=d;
	}
	public void setEndDate(String d){
		endDate=d;
	}
	public void setReceiveDoc(ArrayList<ReceiveDocPO> r){
		receiveDoc=r;
	}
}
