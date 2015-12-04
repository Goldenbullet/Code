package express.data.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import express.dataService.repoDataService.RepoDataService;
import express.po.RepoInfoPO;
import express.po.RepoPosition;

public class RepoDataService_stub implements RepoDataService{
	
	RepoInfoPO repoInfo;
	
	public RepoDataService_stub(RepoInfoPO repoInfo){
		this.repoInfo=repoInfo;
	}

	public boolean getBlockUsed(RepoPosition position) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean changeBlockPositionState(RepoPosition position) {
		// TODO Auto-generated method stub
		return true;
	}

	public RepoInfoPO getRepoInfo(String city, String beginDate, String endDate) {
		// TODO Auto-generated method stub
		System.out.println("Get repository imformation");
		return repoInfo;
	}

	@Override
	public boolean deleteBlock(String city, RepoPosition position)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBlock(String city, int index) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRepo(RepoInfoPO repo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRepo(int index) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RepoInfoPO getRepo(String city) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBlock(String city, RepoPosition position)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<RepoInfoPO> getAllRepo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeAllRepo() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
