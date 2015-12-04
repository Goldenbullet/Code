package express.po;

import java.io.Serializable;
import java.util.ArrayList;

public class PaymentDocPO extends DocumentPO implements Serializable{

	private ArrayList<PaymentItemPO> payment;
	private double sum;
	private String paymentID;
	
	public PaymentDocPO(ArrayList<PaymentItemPO> payment,double sum,String paymentID){
		this.payment=payment;
		this.sum=sum;
		this.paymentID=paymentID;
	}
	
	public PaymentDocPO(){
		payment=null;
		sum=0;
		paymentID="0";
	}
	
	public ArrayList<PaymentItemPO> getPaymentList(){
		return payment;
	}
	public PaymentItemPO getPaymentItem(int index){
		if(index>=0&&index<payment.size())
			return payment.get(index);
		else
			return null;
	}
	public double getSum(){
		return sum;
	}
	public String getPaymentID(){
		return paymentID;
	}
	public boolean deletePaymentItem(int index){
		if(index>=0&&index<payment.size()){
			payment.remove(index);
			return true;
		}
		else
			return false;
	}
	public void addPaymentItem(PaymentItemPO paymentItem){
		payment.add(paymentItem);
	}
	public boolean changePaymentItem(PaymentItemPO paymentItem,int index){
		if(index>=0&&index<payment.size()){
			payment.remove(index);
			payment.add(index, paymentItem);
			return true;
		}
		else
			return false;
	}
	public void setID(String id){
		paymentID=id;
	}
	public void setSum(double s){
		sum=s;
	}
	public double reCalculateSum(){
		sum=0;
		for(PaymentItemPO paymentItem:payment){
			sum+=paymentItem.getSum();
		}
		return sum;
	}
}
