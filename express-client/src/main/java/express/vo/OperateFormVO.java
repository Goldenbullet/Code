package express.vo;

import java.util.ArrayList;

public class OperateFormVO {

	private String startDate;
	private String endDate;
	private ArrayList<ReceiveDocVO> receiveDoc;
	private ArrayList<PaymentDocVO> paymentDoc;

	public OperateFormVO(String startDate, String endDate,
			ArrayList<ReceiveDocVO> receiveDoc,
			ArrayList<PaymentDocVO> paymentDoc) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.receiveDoc = receiveDoc;
		this.paymentDoc = paymentDoc;
	}

	public OperateFormVO() {
		this.startDate = null;
		this.endDate = null;
		this.receiveDoc = null;
		this.paymentDoc = null;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public ArrayList<ReceiveDocVO> getReceiveDoc() {
		return receiveDoc;
	}

	public ArrayList<PaymentDocVO> getPaymentDoc() {
		return paymentDoc;
	}

	public void setStartDate(String d) {
		startDate = d;
	}

	public void setEndDate(String d) {
		endDate = d;
	}

	public void setReceiveDoc(ArrayList<ReceiveDocVO> r) {
		receiveDoc = r;
	}

	public void setPaymentDoc(ArrayList<PaymentDocVO> p) {
		paymentDoc = p;
	}
}
