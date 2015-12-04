package express.vo;

public class RepoPositionVO {

	private String orderID;
	private String block;
	private int row;
	private int shelf;
	private int position;
	private boolean isUsed;
	
	public RepoPositionVO(String id,String b,int r,int s,int p,boolean isUsed){
		this.orderID=id;
		this.block=b;
		this.row=r;
		this.shelf=s;
		this.position=p;
		this.isUsed=isUsed;
	}
	
	public RepoPositionVO(){
		this.orderID=null;
		this.block=null;
		this.row=0;
		this.shelf=0;
		this.position=0;
		this.isUsed=false;
	}
	
	public String getOrderID(){
		return orderID;
	}
	
	public String getblock(){
		return block;
	}
	
	public int getrow(){
		return row;
	}
	
	public int getshelf(){
		return shelf;
	}

	public int getposition(){
		return position;
	}
	
	public boolean getIsUsed(){
		return isUsed;
	}
	//
	public void setIsUsed(boolean b){
		this.isUsed=b;
	}
	
	public void setOrderID(String id){
		orderID = id;
	}
	
	public void setblock(String b){
		block = b;
	}
	
	public void setrow(int n){
		row = n;
	}
	
	public void setshelf(int n){
		shelf = n;
	}

	public void setposition(int n){
		position = n;
	}
}