import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Additional_info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @param company 
	 */

	/**
	 * Create the frame.
	 */
	public Additional_info(int index,ArrayList<Company> All) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 617, 644);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Joined");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(32, 207, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Location");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(209, 207, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Market");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(408, 207, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Website");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(32, 361, 66, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Employees");
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(209, 361, 77, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Stage");
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(408, 361, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Total Raised");
		lblNewLabel_6.setForeground(Color.GRAY);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(32, 486, 79, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(32, 232, 105, 63);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(209, 232, 136, 63);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(408, 232, 164, 63);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(32, 386, 159, 63);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(209, 386, 135, 63);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(408, 386, 105, 63);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(32, 511, 145, 63);
		contentPane.add(lblNewLabel_13);
		
		JButton btnNewButton = new JButton("Visit Site");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String url =("www."+All.get(index).getwebsite()).replaceAll(" ", "") ;
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(371, 573, 105, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewTable = new JLabel("New Table");
		lblNewTable.setForeground(Color.RED);
		lblNewTable.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewTable.setBounds(115, 11, 374, 63);
		contentPane.add(lblNewTable);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(32, 74, 540, 93);
		contentPane.add(lblNewLabel_14);
		
		lblNewTable.setText(All.get(index).getName());
		lblNewLabel_14.setText(All.get(index).getDescription());
		lblNewLabel_7.setText(All.get(index).getjoindate());
		lblNewLabel_8.setText(All.get(index).getlocation());
		lblNewLabel_9.setText(All.get(index).getmarket());
		lblNewLabel_10.setText(All.get(index).getwebsite());
		lblNewLabel_11.setText(All.get(index).getemployees());
		lblNewLabel_12.setText(All.get(index).getstage());
		lblNewLabel_13.setText(All.get(index).gettotal());
		
		JButton button = new JButton("More Info..");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url1 =(All.get(index).getLink()).replaceAll(" ", "") ;
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url1));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(486, 573, 105, 23);
		contentPane.add(button);
	}
}
