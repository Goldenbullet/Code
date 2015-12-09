package express.presentation.managerUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import express.businessLogic.examDocumentBL.ExamDocument;
import express.businesslogicService.managerBLService.ExamDocumentBLService;
import express.po.GoodsArrivalStatus;
import express.presentation.mainUI.MainUIService;
import express.presentation.mainUI.MyCellRenderer;
import express.presentation.mainUI.MyTableModel;
import express.vo.ArrivalDocBusinessHallVO;
import express.vo.ArrivalDocTransCenterVO;
import express.vo.DeliverDocVO;
import express.vo.InDocVO;
import express.vo.OrderVO;
import express.vo.OutDocVO;
import express.vo.PaymentDocVO;
import express.vo.ReceiveDocVO;
import express.vo.ShipmentDocBusinessHallVO;
import express.vo.ShipmentDocTransCenterVO;
import express.vo.TransferDocVO;

public class managerExamDocUI extends JPanel {

	private JButton exam;
	private MainUIService m;
	private JTable table;
	private MyTableModel tableModel;
	private MyCellRenderer headerren;
	private ExamDocumentBLService examdoc;
	private ArrayList<OrderVO> orderarr;
	private ArrayList<ShipmentDocBusinessHallVO> shipbusarr;
	private ArrayList<ArrivalDocTransCenterVO> arrivaltransarr;
	private ArrayList<InDocVO> indocarr;
	private ArrayList<TransferDocVO> transdocarr;
	private ArrayList<OutDocVO> outdocarr;
	private ArrayList<ShipmentDocTransCenterVO> shiptransarr;
	private ArrayList<ArrivalDocBusinessHallVO> arrivalbusarr;
	private ArrayList<DeliverDocVO> deliverdocarr;
	private ArrayList<ReceiveDocVO> receivearr;
	private ArrayList<PaymentDocVO> paymentarr;
	private String changeunder = "<HTML><U>修改</U></HTML>";
	private String confirmunder = "<HTML><U>确认</U></HTML>";
	// private String yesunder = "<HTML><U>已审批</U></HTML>";
	// private String nounder = "<HTML><U>未审批</U></HTML>";
	private Object[][] data;
	private String[] header = { "选择", "单据类型", "单据名称", "单据信息类型", "单据信息", "修改" };

	public managerExamDocUI(MainUIService main) {
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);
		Listener listener = new Listener();

		// data = { { false, "到达单", "12345" },{ false, "到达单", "127845" }, {
		// false, "到达单", "12722845" } };

		examdoc = new ExamDocument();
		orderarr = examdoc.getUEOrderlist();
		int ordernum = orderarr.size();
		shipbusarr = examdoc.getUEBusinessHallShipmentDoclist();
		int shipbunum = shipbusarr.size();
		arrivaltransarr = examdoc.getUETransCenterArrivalDoclist();
		int arritrannum = arrivaltransarr.size();
		indocarr = examdoc.getUEInDoclist();
		int indocnum = indocarr.size();
		transdocarr = examdoc.getUETransferDoclist();
		int trannum = transdocarr.size();
		outdocarr = examdoc.getUEOutDoclist();
		int outnum = outdocarr.size();
		shiptransarr = examdoc.getUETransCenterShipmentDoclist();
		int shiptrannum = shiptransarr.size();
		arrivalbusarr = examdoc.getUEBusinessHallArrivalDoclist();
		int arribunum = arrivalbusarr.size();
		deliverdocarr = examdoc.getUEDeliverDoclist();
		int delivernum = deliverdocarr.size();
		receivearr = examdoc.getUEReceiveDoclist();
		int receivenum = receivearr.size();
		paymentarr = examdoc.getUEPaymentDoclist();
		int paynum = paymentarr.size();

		Class[] typeArray = { Boolean.class, Object.class, Object.class,
				Object.class, Object.class, Object.class };
		// table数据初始化
		data = new Object[ordernum + arribunum + arritrannum + delivernum
				+ indocnum + outnum + paynum + receivenum + shipbunum
				+ shiptrannum + trannum][6];

		for (int i0 = 0; i0 < ordernum; i0++) {
			data[i0][0] = false;
			data[i0][1] = "订单";
			data[i0][2] = orderarr.get(i0).getOrderID();
			data[i0][3] = "运费";
			data[i0][4] = orderarr.get(i0).getFee();
			data[i0][5] = changeunder;
		}

		for (int i1 = 0; i1 < arribunum; i1++) {
			data[i1 + ordernum][0] = false;
			data[i1 + ordernum][1] = "营业厅到达单";
			data[i1 + ordernum][2] = arrivalbusarr.get(i1).getOrderID();
			data[i1 + ordernum][3] = "货物状态";
			GoodsArrivalStatus status = arrivalbusarr.get(i1)
					.getArrivalStatus();
			if (status.equals(GoodsArrivalStatus.Complete)) {
				data[i1 + ordernum][4] = "完好";
			} else if (status.equals(GoodsArrivalStatus.Damage)) {
				data[i1 + ordernum][4] = "损坏";
			} else {
				data[i1 + ordernum][4] = "丢失";
			}
			data[i1 + ordernum][5] = changeunder;
		}

		for (int i1 = 0; i1 < arritrannum; i1++) {
			data[i1 + ordernum + arribunum][0] = false;
			data[i1 + ordernum + arribunum][1] = "中转中心到达单";
			data[i1 + ordernum + arribunum][2] = arrivaltransarr.get(i1)
					.getOrderID();
			data[i1 + ordernum + arribunum][3] = "货物状态";
			GoodsArrivalStatus status = arrivaltransarr.get(i1)
					.getArrivalStatus();
			if (status.equals(GoodsArrivalStatus.Complete)) {
				data[i1 + ordernum + arribunum][4] = "完好";
			} else if (status.equals(GoodsArrivalStatus.Damage)) {
				data[i1 + ordernum + arribunum][4] = "损坏";
			} else {
				data[i1 + ordernum + arribunum][4] = "丢失";
			}
			data[i1 + ordernum + arribunum][5] = changeunder;
		}

		for (int i1 = 0; i1 < delivernum; i1++) {
			data[i1 + ordernum + arribunum + arritrannum][0] = false;
			data[i1 + ordernum + arribunum + arritrannum][1] = "派件单";
			data[i1 + ordernum + arribunum + arritrannum][2] = deliverdocarr
					.get(i1).getOrderID();
			data[i1 + ordernum + arribunum + arritrannum][3] = "快递员工号";
			data[i1 + ordernum + arribunum + arritrannum][4] = deliverdocarr
					.get(i1).getDeliverManID();
			data[i1 + ordernum + arribunum + arritrannum][5] = changeunder;
		}

		for (int i1 = 0; i1 < indocnum; i1++) {
			data[i1 + ordernum + arribunum + arritrannum + delivernum][0] = false;
			data[i1 + ordernum + arribunum + arritrannum + delivernum][1] = "入库单";
			data[i1 + ordernum + arribunum + arritrannum + delivernum][2] = indocarr
					.get(i1).getdeliveryNumber();
			data[i1 + ordernum + arribunum + arritrannum + delivernum][3] = "仓库位置";
			data[i1 + ordernum + arribunum + arritrannum + delivernum][4] = "";// 信息太多，写JDialog
			data[i1 + ordernum + arribunum + arritrannum + delivernum][5] = changeunder;
		}

		for (int i1 = 0; i1 < outnum; i1++) {
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum][0] = false;
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum][1] = "出库单";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum][2] = outdocarr.get(i1).getOrderID();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum][3] = "装运形式";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum][4] = outdocarr.get(i1).gettransKind();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum][5] = changeunder;
		}

		for (int i1 = 0; i1 < paynum; i1++) {
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum][0] = false;
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum][1] = "付款单";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum][2] = paymentarr.get(i1).getPaymentID();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum][3] = "";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum][4] = "";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum][5] = changeunder;
		}

		for (int i1 = 0; i1 < receivenum; i1++) {
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum][0] = false;
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum][1] = "收款单";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum][2] = receivearr.get(i1)
					.getReceiveDate();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum][3] = "收款金额";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum][4] = receivearr.get(i1)
					.getReceivePrice();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum][5] = changeunder;
		}

		for (int i1 = 0; i1 < shipbunum; i1++) {
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum][0] = false;
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum][1] = "营业厅装车单单";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum][2] = shipbusarr
					.get(i1).getShipmentID();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum][3] = "运费";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum][4] = shipbusarr
					.get(i1).getMoney();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum][5] = changeunder;
		}

		for (int i1 = 0; i1 < shiptrannum; i1++) {
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum][0] = false;
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum][1] = "中转中心装车单单";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum][2] = shiptransarr
					.get(i1).getShipmentID();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum][3] = "运费";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum][4] = shiptransarr
					.get(i1).getMoney();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum][5] = changeunder;
		}

		for (int i1 = 0; i1 < trannum; i1++) {
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum
					+ shiptrannum][0] = false;
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum
					+ shiptrannum][1] = "中转单";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum
					+ shiptrannum][2] = transdocarr.get(i1)
					.getcontainerNumber();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum
					+ shiptrannum][3] = "运费";
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum
					+ shiptrannum][4] = transdocarr.get(i1).getmoney();
			data[i1 + ordernum + arribunum + arritrannum + delivernum
					+ indocnum + outnum + paynum + receivenum + shipbunum
					+ shiptrannum][5] = changeunder;
		}

		tableModel = new MyTableModel(data, header, typeArray);
		table = new JTable(tableModel);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		table.setBounds(50, 60, 750, 600);
		table.setFont(f);
		table.addMouseListener(listener);
		headerren = new MyCellRenderer(table);
		table.getTableHeader().setDefaultRenderer(headerren);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 60, 750, 600);
		this.add(scrollPane);

		exam = new JButton("审批");
		exam.setBounds(340, 10, 100, 30);
		exam.setFont(font);
		exam.addMouseListener(listener);
		this.add(exam);

	}

	private class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exam) {
				for (int i = 0; i < tableModel.getRowCount(); i++) {
					if ((boolean) tableModel.getValueAt(i, 0)) {
						//通过审批，设置单据审批状态
						if(tableModel.getValueAt(i, 1).equals("订单")){
							OrderVO vo = orderarr.get(i);
							orderarr.remove(vo);
							vo.setState(true);
							examdoc.changeOrder(vo);							
						}else if(tableModel.getValueAt(i, 1).equals("营业厅装车单")){
							ShipmentDocBusinessHallVO vo = shipbusarr.get(i-orderarr.size());
							shipbusarr.remove(vo);
							vo.setState(true);
							examdoc.changeBusinessHallShipmentDoc(vo);							
						}else if(tableModel.getValueAt(i, 1).equals("中转中心到达单")){
							ArrivalDocTransCenterVO vo = arrivaltransarr.get(i-orderarr.size()-shipbusarr.size());
							arrivaltransarr.remove(vo);
							vo.setState(true);
							examdoc.changeTransCenterArrivalDoc(vo);							
						} 
						tableModel.removeRow(i);
					}
				}
			}else if(e.getSource() == table){
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				if (col == 5) {
					if(tableModel.getValueAt(row, col).equals(changeunder)){
						//tableModel.setrowedit(row);
						tableModel.setValueAt(confirmunder, row, col);
					}else if (tableModel.getValueAt(row, col).equals(
							confirmunder)) {
						tableModel.setrowunedit();
						tableModel.setValueAt(changeunder, row, col);
						
					}
				}
				
			}
			updateUI();
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
