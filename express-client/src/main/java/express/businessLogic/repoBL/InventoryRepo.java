package express.businessLogic.repoBL;

import java.util.ArrayList;

import express.businessLogic.syslogBL.SysLog;
import express.vo.InDocVO;

public class InventoryRepo {
	
	public ArrayList<InDocVO> inventoryRepo() {
		
		return null;
	}
	
	public boolean exportExcel(ArrayList<InDocVO> repoCache) {
		return false;
	}
	
	public void endRepoInventory() {
		SysLog log=new SysLog();
		log.addSysLog("库存盘点");
	}

}
