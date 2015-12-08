package express.presentation.mainUI;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {

	private int rowedit;
	private boolean edit = false;
	private Class[] typeArray;
	private String[] head;
	private Object[][] data;
	private String changeunder = "<HTML><U>修改</U></HTML>";

	public MyTableModel(Object[][] data, String[] head, Class[] typeArray) {
		super(data, head);
		this.typeArray = typeArray;
		this.head = head;
		this.data = data;
	}

	// 创建类型数组
	// Class[] typeArray = { Boolean.class, Object.class, JComboBox.class,
	// Object.class, JComboBox.class, JComboBox.class, Object.class,
	// Object.class, Object.class };

	// 使表格具有可编辑性
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(data[0][head.length-1].equals(changeunder)){
			if(columnIndex==head.length-1){
				return false;
			}
		}
		
		if (edit) {
			if (rowIndex == rowedit) {
				return true;
			}
		}
		
		if (columnIndex == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setrowedit(int row) {
		rowedit = row;
		edit = true;
	}

	public void setrowunedit() {
		edit = false;
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return typeArray[columnIndex];// 返回每一列的数据类型
	}
}
