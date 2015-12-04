package express.po;

import java.util.ArrayList;

public class HistoryTimePO {//每次完成一个订单后 生成一个Po
	private String startCity;
	private String endCity;
	private String setOutTime;
	private String arrivalTime;
	
	public HistoryTimePO(String startCity,String endCity,
					String setOutTime,String arrivalTime){
		this.startCity=startCity;
		this.endCity=endCity;
		this.setOutTime=setOutTime;
		this.arrivalTime=arrivalTime;
		
	}
	
	public String getStartCity(){
		return startCity;
	}
	public String getEndCity(){
		return endCity;
	}
	public String getSetOutTime(){
		return setOutTime;
	}
	public String getArrivalTime(){
		return arrivalTime;
	}
}
