package express.presentation.mainUI;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface MainUIService {
	
	public void setcard1(CardLayout card1);
	
	public void setpane1(JPanel pane1);
	
	public boolean jumpToSignInUI();

	public boolean jumpToadminStartUI();
	
	public boolean jumpToadminAddUI ();
	
	public boolean jumpTomanagerMenuUI();
	
	public boolean jumpTomanagerMemberUI ();
	
	public boolean jumpTomanagerOrgUI ();
		
	public boolean jumpToViewSysLogUI ();
	
    public boolean jumpTomanagerExamDocUI ();
	
	
	public boolean jumpToStatisticDataUI (String s,int index,String date);
	
	public boolean jumpToFinanceMenuUI ();
	
	public boolean jumpToFinanceCreateProfitUI ();
	
	public boolean jumpToFinanceSumReceiveDocUI ();
	
	public boolean jumpToFinanceInitAccountUI ();
	
	public boolean jumpToFinanceManageBankAccountUI ();
	
	public boolean jumpToFinancePaymentUI ();
	
	public boolean jumpToFinanceCreateOperateUI ();
	
//	public boolean jumpToFinanceInitRepoUI (CardLayout card1,JPanel pane1);
//	
//	public boolean jumpToFinanceInitBankUI (CardLayout card1,JPanel pane1);
//	
//	public boolean jumpToFinanceInitOrgUI (CardLayout card1,JPanel pane1);
//	
//	public boolean jumpToFinanceInitVehicleUI (CardLayout card1,JPanel pane1);
//	
//	public boolean jumpToFinancePreviousInitUI (CardLayout card1,JPanel pane1);
//	
//	public boolean jumpToFinanceInitUserUI (CardLayout card1,JPanel pane1);
	
	public boolean jumpToshowUI ();
	
	public boolean jumpTosearchUI ();
	
	public boolean jumpToinUI ();
	
	public boolean jumpTooutUI ();
	
	public boolean jumpTotranscenterRepoMenuUI ();
	
	public boolean jumpToadjustUI ();
	
	public boolean jumpToviewUI ();
	
	public boolean jumpToviewShowUI ();
	
	public boolean jumpToinventoryUI ();
	
	public boolean jumpTobusinessMenuUI ();
	
	public boolean jumpTobusinessArrivalUI ();
	
	public boolean jumpTobusinessDriverUI ();
	
	public boolean jumpTobusinessDeliverUI ();
	
	public boolean jumpTobusinessVehicleUI ();
	
	public boolean jumpTobusinessReceiveUI ();
	
	public boolean jumpTobusinessShipmentUI ();
	
	public boolean jumpTodeliverOrderUI ();
	
	public boolean jumpTodeliverReceiveUI ();
	
	public boolean jumpTodeliverMenuUI ();
	
	public boolean jumpTotransSaleMenuUI ();
	
	public boolean jumpTotransSaleTransterDocUI ();
	
	public boolean jumpTotransSaleShipmentDocUI ();
	
	public boolean jumpTotransSaleArrivalDocUI ();

	public boolean jumpToViewProfitUI();

	public boolean jumpToViewOperateUI();
}
