package express.businesslogicService.transcenterSaleBLService;


import express.vo.TransferDocVO;

public interface TransCenterTransferDocblService {
	public boolean addTransferDoc(TransferDocVO vo);
	public TransferDocVO getTransferDoc(String transID) ;
	public boolean isTransIDavailable(String transid);
	public double getTransferFee(TransferDocVO vo);
	public void endTransferDoc();
}
