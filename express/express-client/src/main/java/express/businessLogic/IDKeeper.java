package express.businessLogic;

public class IDKeeper {

	private static String id;
	private static String orgID;
	
	public IDKeeper(){
		id=null;
		orgID=null;
	}
	
	public static String getID(){
		return id;
	}
	
	public static void setID(String i){
		id=i;
	}
	
	public static String getOrgID(){
		return orgID;
	}
	
	public static void setOrgID(String org){
		orgID=org;
	}
}
