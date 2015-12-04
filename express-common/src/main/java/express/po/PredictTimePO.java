package express.po;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class PredictTimePO {//把同一出发地和到达地的historyPO放到PredictPO里
	private String setOutCity;
	private String arrivalCity;
	private ArrayList<HistoryTimePO> predictlist;

	public ArrayList<HistoryTimePO> getList(){
		return predictlist;
	}
	
	public boolean addHistoryTime(HistoryTimePO po){
		predictlist.add(po);
		return true;
	}
	
	public String getSetOutCity(){
		return setOutCity;
	}
	public String getArrivalCity(){
		return arrivalCity;
	}
	
	
}
