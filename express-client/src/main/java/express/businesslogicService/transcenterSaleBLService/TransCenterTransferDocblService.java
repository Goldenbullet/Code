package express.businesslogicService.transcenterSaleBLService;


import java.util.ArrayList;

import express.po.TransferDocPO;
import express.vo.TransferDocVO;

public interface TransCenterTransferDocblService {
	public boolean addTransferDoc(TransferDocVO vo);
	public TransferDocVO getTransferDoc(String transID) ;
	public boolean isTransIDavailable(String transid);
	public double getTransferFee(TransferDocVO vo);
	public String getTransferDocID();
	public ArrayList<TransferDocPO>  getAllTransferDoc();
	public void endTransferDoc();
}
