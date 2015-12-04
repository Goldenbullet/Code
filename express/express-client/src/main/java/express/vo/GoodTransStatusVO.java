package express.vo;

import java.util.ArrayList;

public class GoodTransStatusVO {
	private String orderID;
	ArrayList<String> time;
	//最多经过2个营业厅，2个中转中心
	private String firstBusinessHallID="-1";
	private String firsttransCenterID="-1";
	private String secondtransCenterID="-1";
	private String secondBusinessHallID="-1";
	//没有经过的话 用－1表示
	private String deliverManID;
	//需要讨论他的构造方法
	
	public String getOrderID(){
		return orderID;
	}
	public void setOrderID(String id){
		orderID=id;
	}
	public ArrayList<String> getTime(){
		return time;
	}
	public void setTime(ArrayList<String> t){
		time=t;
	}
	public String getFirstBusinessHallID(){
		return firstBusinessHallID;
	}
	public void setFirstBusinessHallID(String s){
		firstBusinessHallID=s;
	}
	public String getFirsttransCenterID(){
		return firsttransCenterID;
	}
	public void setFirsttransCenterID(String s){
		firsttransCenterID=s;
	}
	public String getSecondtransCenterID(){
		return secondtransCenterID;
	}
	public void setSecondtransCenterID(String s){
		secondtransCenterID=s;
	}
	public String getSecondBusinessHallID(){
		return secondBusinessHallID;
	}
	public void setSecondBusinessHallID(String s){
		secondBusinessHallID=s;
	}
	public String getDeliverManID(){
		return deliverManID;
	}
	public void setDeliverManID(String s){
		deliverManID=s;
	}
}
