package express.businesslogicService.managerBLService;

import express.vo.DocumentListVO;

public interface ExamDocumentBLService {
	
	public DocumentListVO getDocumentList();
	
	public boolean changeDocumentInfo(int index);
	
	public boolean passDocument (int index);
	
	public void endJudge();
}
