package express.businessLogic.repoBL;

import java.util.ArrayList;

import express.businesslogicService.transcenterRepoBLService.AdjustRepoBLService;
import express.businesslogicService.transcenterRepoBLService.InventoryRepoBLService;
import express.businesslogicService.transcenterRepoBLService.ScanRepoBLService;
import express.vo.InDocVO;
import express.vo.RepoCacheVO;
import express.vo.RepoPositionVO;

public class RepoController implements AdjustRepoBLService,
		InventoryRepoBLService, ScanRepoBLService {
	
	ViewRepo view;
	
	public RepoController(){
		view=new ViewRepo();
	}

	public RepoCacheVO getRepoInfo(String city, String startDate, String endDate) {
		return view.getRepoInfo(city, startDate, endDate);
	}

	public ArrayList<RepoPositionVO> getRepoPositionList(String city) {
		return view.getRepoPositionList(city);
	}

	public boolean checkBeginAndEndDate(String beginDate, String endDate) {
		return view.checkBeginAndEndDate(beginDate, endDate);
	}

	public ArrayList<InDocVO> inventoryRepo() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exportExcel(ArrayList<InDocVO> repoCache) {
		// TODO Auto-generated method stub
		return false;
	}

	public void endRepoInventory() {
		// TODO Auto-generated method stub
		
	}

	public boolean checkRepoBlockUsed(RepoPositionVO position) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setRepoBlock(RepoPositionVO position) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean alarm() {
		// TODO Auto-generated method stub
		return false;
	}

	public void adjustRepo(RepoPositionVO oldPosition,
			RepoPositionVO newPosition) {
		// TODO Auto-generated method stub
		
	}

	public void endRepoManage() {
		// TODO Auto-generated method stub
		
	}

}
