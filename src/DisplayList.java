import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisplayList extends JFrame {
	public ArrayList<Company> All_Names= new ArrayList<Company>();
	public JTable table;
	private JTable table_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayList frame = new DisplayList();
					frame.setResizable(false);
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					//frame.setUndecorated(true);
					frame.setSize(630, 500);
					frame.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DisplayList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("AngelList Companies");
		lblName.setBounds(42, 11, 500, 100);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		getContentPane().add(lblName);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 135, 602, 326);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int rowCount = table_1.rowAtPoint(arg0.getPoint());
				Additional_info as = new Additional_info(rowCount,All_Names);
				as.setVisible(true);
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Description", "Link"
			}
		));
		scrollPane_1.setViewportView(table_1);
		try {
			All_Names= (ArrayList<Company>) CompanyScrap.getall();
		} catch (IOException e) {
		System.out.println("Exception with GETALL in DisplayList");
		}
		Object rowData[] = new Object[3];
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		for (int i = 0; i < All_Names.size(); i++){
			rowData[0] = All_Names.get(i).getName();
            rowData[1] = All_Names.get(i).getDescription();
            rowData[2] = All_Names.get(i).getLink();
			 //  String name = All_Names.get(i).getName();
			  // String link = All_Names.get(i).getLink();
			   //String desc = All_Names.get(i).getDescription();
			   //System.out.println(name+"    "+link+"    "+desc ); 
			model.addRow(rowData);
		}
		
		
	}
}
