package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;

import controll.BookTicket;
import controll.SearchTicket;
import controll.SearchOrderNum;
import controll.CancelTicket;
import controll.ParseTimeTable;
import controll.Convert_Time;
import entity.Station;
import entity.Train;

import javax.swing.JRadioButton;

/**
 * The main ui of the booking system.
 * 
 * @author Jerry
 */
public class MainPage {
	private JFrame frame;
	private TimeTablePage winTimeTable;
	private DiscountTablePage winDiscount;
	private ConfirmOrderPage winConfirmOrder;
	private JTextField uidField;
	private JTextField uid_ok;
	private JTextField code_ok;
	private JTextField uid_no;
	private JTextField train_no;
	private JTextField newTicketUID;
	private JTextField newTicketCode;
	private JTextField newTicketCount;
	private JPanel panelBook;
	/**
	 * Launch the application.
	 * 
	 * @param args
	 *            No args.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
					window.winTimeTable = new TimeTablePage();
					window.winDiscount = new DiscountTablePage();
					window.winConfirmOrder = new ConfirmOrderPage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u9AD8\u9435\u8A02\u7968\u7CFB\u7D71");
		frame.setBounds(100, 100, 708, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton updateButton = new JButton("Update Time Table");
		updateButton.setBounds(0, 0, 690, 23);
		updateButton.addActionListener(new ActionListener() {
			/**
			 * Update time table database.
			 */
			public void actionPerformed(ActionEvent arg0) {
				updateButton.setEnabled(false);
				new ParseTimeTable().parseTime();
				JOptionPane.showMessageDialog(null, "Successed.", "InfoBox: Finish",
						JOptionPane.INFORMATION_MESSAGE);
				updateButton.setEnabled(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(updateButton);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 206, 694, 351);
		frame.getContentPane().add(tabbedPane_1);

		panelBook = new JPanel();
		tabbedPane_1.addTab("\u8A02\u7968", null, panelBook, null);
		panelBook.setLayout(null);

		JLabel label_6 = new JLabel("\u65E5\u671F");
		label_6.setBounds(20, 66, 32, 15);
		panelBook.add(label_6);

		JComboBox<String> buyDate = new JComboBox<String>();
		buyDate.setBounds(62, 63, 263, 21);
		panelBook.add(buyDate);

		JLabel label_9 = new JLabel("\u8D77\u7AD9");
		label_9.setBounds(20, 97, 32, 15);
		panelBook.add(label_9);

		JComboBox<String> buyStart = new JComboBox<String>();
		buyStart.setBounds(62, 94, 52, 21);
		panelBook.add(buyStart);

		JButton buySearch = new JButton("\u67E5\u8A62");
		buySearch.setBounds(374, 149, 305, 23);
		panelBook.add(buySearch);

		JLabel lblid = new JLabel("\u4F7F\u7528\u8005ID");
		lblid.setBounds(20, 38, 54, 15);
		panelBook.add(lblid);

		uidField = new JTextField();
		uidField.setBounds(90, 35, 235, 21);
		panelBook.add(uidField);
		uidField.setColumns(10);

		JLabel label_7 = new JLabel("\u8A16\u7AD9");
		label_7.setBounds(124, 97, 32, 15);
		panelBook.add(label_7);

		JComboBox<String> buyEnd = new JComboBox<String>();
		buyEnd.setBounds(158, 94, 60, 21);
		panelBook.add(buyEnd);

		JLabel label_8 = new JLabel("\u5F35\u6578");
		label_8.setBounds(230, 97, 32, 15);
		panelBook.add(label_8);

		JComboBox<String> ticketCount = new JComboBox<String>();
		ticketCount.setBounds(265, 94, 60, 21);
		panelBook.add(ticketCount);

		JLabel label_10 = new JLabel("\u7968\u7A2E");
		label_10.setBounds(142, 125, 32, 15);
		panelBook.add(label_10);

		JComboBox<String> seatType = new JComboBox(Train.TICKET_TYPE);
		seatType.setBounds(184, 122, 141, 21);
		panelBook.add(seatType);

		JLabel label_11 = new JLabel("\u4F4D\u7F6E");
		label_11.setBounds(20, 125, 32, 15);
		panelBook.add(label_11);

		JComboBox<String> seatSide = new JComboBox(Train.SEAT_TYPE);
		seatSide.setBounds(62, 122, 70, 21);
		panelBook.add(seatSide);

		JCheckBox goBack = new JCheckBox("\u56DE\u7A0B");

		goBack.setBounds(377, 66, 60, 23);
		panelBook.add(goBack);

		JLabel label_12 = new JLabel("\u8ECA\u6B21\u67E5\u8A62");
		label_12.setFont(label_12.getFont().deriveFont(label_12.getFont().getStyle() | Font.BOLD));
		label_12.setBounds(10, 10, 60, 15);
		panelBook.add(label_12);

		JLabel label_13 = new JLabel("\u8A02\u55AE\u78BA\u8A8D");
		label_13.setFont(label_13.getFont().deriveFont(label_13.getFont().getStyle() | Font.BOLD));
		label_13.setBounds(10, 182, 679, 15);
		panelBook.add(label_13);

		JLabel status = new JLabel("\u5C1A\u672A\u67E5\u8A62");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setForeground(Color.BLUE);
		status.setBounds(74, 182, 615, 15);
		panelBook.add(status);

		JLabel label_15 = new JLabel("\u53BB\u7A0B");
		label_15.setBounds(20, 210, 32, 15);
		panelBook.add(label_15);

		JComboBox<String> goCandidate = new JComboBox<String>();
		goCandidate.setEnabled(false);
		goCandidate.setBounds(52, 207, 627, 21);
		panelBook.add(goCandidate);

		JLabel label_16 = new JLabel("\u56DE\u7A0B");
		label_16.setBounds(20, 238, 32, 15);
		panelBook.add(label_16);

		JComboBox<String> backCandidate = new JComboBox<String>();
		backCandidate.setEnabled(false);
		backCandidate.setBounds(52, 235, 627, 21);
		panelBook.add(backCandidate);

		JLabel bookCodeText = new JLabel("\u8A02\u55AE\u7DE8\u865F");
		bookCodeText.setBounds(20, 266, 60, 15);
		panelBook.add(bookCodeText);

		JLabel bookCode = new JLabel("192873645");
		bookCode.setEnabled(false);
		bookCode.setHorizontalAlignment(SwingConstants.TRAILING);
		bookCode.setBounds(90, 266, 235, 15);
		panelBook.add(bookCode);

		JButton bookTicket = new JButton("\u8A02\u7968");
		bookTicket.setEnabled(false);
		bookTicket.setBounds(20, 291, 659, 23);
		panelBook.add(bookTicket);

		JLabel label_21 = new JLabel("\u51FA\u767C\u6642\u9593");
		label_21.setBounds(85, 153, 57, 15);
		panelBook.add(label_21);

		JComboBox<String> goTime = new JComboBox<String>();
		goTime.setBounds(140, 150, 60, 21);
		panelBook.add(goTime);

		JLabel label_22 = new JLabel("\u62B5\u9054\u6642\u9593");
		label_22.setBounds(210, 153, 57, 15);
		panelBook.add(label_22);

		JComboBox<String> backTime = new JComboBox<String>();
		backTime.setBounds(265, 150, 60, 21);
		panelBook.add(backTime);

		JLabel label_18 = new JLabel("\u51FA\u767C\u6642\u9593");
		label_18.setBounds(439, 69, 57, 15);
		panelBook.add(label_18);

		JComboBox<String> goTime2 = new JComboBox<String>();
		goTime2.setEnabled(false);
		goTime2.setBounds(494, 66, 60, 21);
		panelBook.add(goTime2);

		JLabel label_20 = new JLabel("\u62B5\u9054\u6642\u9593");
		label_20.setBounds(564, 69, 57, 15);
		panelBook.add(label_20);

		JComboBox<String> backTime2 = new JComboBox<String>();
		backTime2.setEnabled(false);
		backTime2.setBounds(619, 66, 60, 21);
		panelBook.add(backTime2);

		JLabel lblNewLabel_1 = new JLabel("\u53BB\u7A0B");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(37, 153, 32, 15);
		panelBook.add(lblNewLabel_1);

		JLabel label_23 = new JLabel("\u56DE\u7A0B\u65E5\u671F");
		label_23.setBounds(374, 41, 63, 15);
		panelBook.add(label_23);

		JComboBox<String> buyBackDate = new JComboBox<String>();
		buyBackDate.setEnabled(false);
		buyBackDate.setBounds(438, 38, 241, 21);
		panelBook.add(buyBackDate);

		/* Book Ticket Start */
		BookTicket con = new BookTicket();	
		
		// check go-back
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goTime2.setEnabled(goBack.isSelected());
				backTime2.setEnabled(goBack.isSelected());
				buyBackDate.setEnabled(goBack.isSelected());
			}
		});
		
		// buy ticket - search
		buySearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid = uidField.getText();
				int code = Math.abs(new Random().nextInt());
				int startStationIndex = buyStart.getSelectedIndex();
				int endStationIndex = buyEnd.getSelectedIndex();
				int side = seatSide.getSelectedIndex();
				int type = seatType.getSelectedIndex();
				int count = ticketCount.getSelectedIndex() + 1;
				int goEarly = buyDate.getSelectedIndex() >= 5 ? 1 : 0;
				int backEarly = buyBackDate.getSelectedIndex() >= 5 ? 1 : 0;
				int goStartTime = Integer.parseInt(((String) goTime.getSelectedItem()).replace(":", ""));
				int goEndTime = Integer.parseInt(((String) backTime.getSelectedItem()).replace(":", ""));
				int backStartTime = Integer.parseInt(((String) goTime2.getSelectedItem()).replace(":", ""));
				int backEndTime = Integer.parseInt(((String) backTime2.getSelectedItem()).replace(":", ""));
				boolean ifGoBack = goBack.isSelected();
				int goDateIndex = buyDate.getSelectedIndex(); // 去程日期的index
				int backDateIndex = buyBackDate.getSelectedIndex(); // 回程日期的index

				
				// 看訂位條件是否合理 
				String err = con.checkCondition(uid, startStationIndex, endStationIndex, ifGoBack, count, goDateIndex,
						backDateIndex, goStartTime, goEndTime, backStartTime, backEndTime);
				if (!err.equals("ok")) {
					JOptionPane.showMessageDialog(null, err, "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 列出適合車次 
				String goDate = (String) buyDate.getSelectedItem();
				String backDate = (String) buyBackDate.getSelectedItem();
				err = con.showCandidate(goCandidate, backCandidate, goDate, backDate, startStationIndex, endStationIndex, 
						goStartTime, goEndTime, backStartTime, backEndTime, count, side, type, goEarly, backEarly, ifGoBack);
				if (!err.equals("ok")) {
					JOptionPane.showMessageDialog(null, err, "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}
				goCandidate.setEnabled(true);
				backCandidate.setEnabled(true);
				bookCode.setEnabled(true);
				bookTicket.setEnabled(true);
				status.setText("請選擇班次");

				bookCode.setText(Integer.toString(code));
			}
		});

		bookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uid = uidField.getText();
				int code = Math.abs(new Random().nextInt());
				int startStationIndex = buyStart.getSelectedIndex();
				int endStationIndex = buyEnd.getSelectedIndex();
				int side = seatSide.getSelectedIndex();
				int type = seatType.getSelectedIndex();
				int count = ticketCount.getSelectedIndex() + 1;
				boolean ifGoBack = goBack.isSelected();
				goCandidate.setEnabled(false);
				backCandidate.setEnabled(false);
				bookCode.setEnabled(false);
				bookTicket.setEnabled(false);
				
				int goIndex = goCandidate.getSelectedIndex();
				int backIndex = backCandidate.getSelectedIndex();
				
				con.showPrice(ifGoBack, goIndex, backIndex, uid, count, type, startStationIndex,
						endStationIndex, side, code);
				int price = con.getTotalPrice();
				ArrayList<Integer> timeArray = con.getTicketTime();
				String ty;
				if(type==0)
					ty = "一般";
				else if(type==1)
					ty = "學生";
				else if(type==2)
					ty = "愛心";
				else if(type==3)
					ty = "商務";
				else
					ty = "早鳥";
				
				
				
				winConfirmOrder.showOrderContent((String) buyStart.getSelectedItem(),(String) buyEnd.getSelectedItem(),
						timeArray.get(0), timeArray.get(1),timeArray.get(2),timeArray.get(3),ty,count,price,ifGoBack,con);
				winConfirmOrder.show();
			}
		});

		JPanel panelCancel = new JPanel();
		tabbedPane_1.addTab("\u9000\u7968\u8207\u4FEE\u6539", null, panelCancel, null);
		panelCancel.setLayout(null);

		JLabel cancelTicketLabel = new JLabel("\u67E5\u8A62\u8A02\u7968 - \u6709\u8A02\u4F4D\u4EE3\u865F");
		cancelTicketLabel
				.setFont(cancelTicketLabel.getFont().deriveFont(cancelTicketLabel.getFont().getStyle() | Font.BOLD));
		cancelTicketLabel.setBounds(10, 10, 212, 15);
		panelCancel.add(cancelTicketLabel);

		JLabel label_14 = new JLabel("\u4F7F\u7528\u8005ID");
		label_14.setBounds(20, 38, 54, 15);
		panelCancel.add(label_14);

		newTicketUID = new JTextField();
		newTicketUID.setColumns(10);
		newTicketUID.setBounds(84, 35, 241, 21);
		panelCancel.add(newTicketUID);

		newTicketCode = new JTextField();
		newTicketCode.setColumns(10);
		newTicketCode.setBounds(84, 63, 241, 21);
		panelCancel.add(newTicketCode);

		JLabel label_17 = new JLabel("\u8A02\u4F4D\u4EE3\u865F");
		label_17.setBounds(20, 66, 54, 15);
		panelCancel.add(label_17);

		JRadioButton deleteTicket = new JRadioButton("\u9000\u7968");
		deleteTicket.setSelected(true);
		deleteTicket.setBounds(331, 34, 107, 23);
		panelCancel.add(deleteTicket);

		JRadioButton reduceTicket = new JRadioButton("\u4FEE\u6539\u7968\u6578");
		reduceTicket.setBounds(331, 62, 86, 23);
		panelCancel.add(reduceTicket);

		ButtonGroup updateGroup = new ButtonGroup();
		updateGroup.add(deleteTicket);
		updateGroup.add(reduceTicket);

		newTicketCount = new JTextField();
		newTicketCount.setColumns(10);
		newTicketCount.setBounds(423, 63, 256, 21);
		panelCancel.add(newTicketCount);

		JButton cancelTicket = new JButton("\u66F4\u65B0");
		cancelTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uid = newTicketUID.getText();
				String code = newTicketCode.getText();
				int tickets = 0;
				
				if (uid.equals("")) {
					JOptionPane.showMessageDialog(null, "UID不可為空!", "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (code.equals("")) {
					JOptionPane.showMessageDialog(null, "訂位代號不可為空!", "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}

				CancelTicket cancelTicketControl = new CancelTicket();
				
				try {
					if (reduceTicket.isSelected()) {
						tickets = Integer.parseInt(newTicketCount.getText()); // This part may cause exception!
						if(tickets <= 0) {
							JOptionPane.showMessageDialog(null, "數量必須為正整數!", "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					String result = cancelTicketControl.deleteTickets(uid, Integer.parseInt(code), tickets);
					JOptionPane.showMessageDialog(null, result, "InfoBox: 提示",
							JOptionPane.ERROR_MESSAGE); // Only "修改成功.../退票成功..." is not an error message
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "數量必須為正整數!", "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});		
		cancelTicket.setBounds(20, 94, 659, 23);
		panelCancel.add(cancelTicket);

		JPanel panelSearch = new JPanel();
		tabbedPane_1.addTab("\u67E5\u8A62", null, panelSearch, null);
		panelSearch.setLayout(null);

		JLabel TT_search_label = new JLabel("\u7576\u65E5\u6642\u523B\u8868\u67E5\u8A62");
		TT_search_label.setFont(TT_search_label.getFont().deriveFont(TT_search_label.getFont().getStyle() | Font.BOLD));
		TT_search_label.setBounds(10, 10, 92, 15);
		panelSearch.add(TT_search_label);

		JComboBox<String> dateTimeTable = new JComboBox<String>();
		dateTimeTable.setBounds(54, 32, 184, 21);
		initializeDate(dateTimeTable);
		panelSearch.add(dateTimeTable);

		JLabel dateLabel = new JLabel("\u65E5\u671F");
		dateLabel.setBounds(20, 35, 32, 15);
		panelSearch.add(dateLabel);

		JButton dateTableSearch = new JButton("\u67E5\u8A62");
		dateTableSearch.addActionListener(new ActionListener() {
			/**
			 * Show time table.
			 */
			public void actionPerformed(ActionEvent e) {
				winTimeTable.setTitle((String) dateTimeTable.getSelectedItem());
				winTimeTable.setTimeDown(((String) dateTimeTable.getSelectedItem()).replaceAll("/", ""));
				winTimeTable.setTimeUp(((String) dateTimeTable.getSelectedItem()).replaceAll("/", ""));
				winTimeTable.show();
			}
		});
		dateTableSearch.setBounds(248, 31, 87, 23);
		panelSearch.add(dateTableSearch);

		// Cheap Ticket
		JLabel cheapSearchLabel = new JLabel("\u512A\u60E0\u8ECA\u6B21\u67E5\u8A62");
		cheapSearchLabel
				.setFont(cheapSearchLabel.getFont().deriveFont(cheapSearchLabel.getFont().getStyle() | Font.BOLD));
		cheapSearchLabel.setBounds(10, 63, 92, 15);
		panelSearch.add(cheapSearchLabel);

		JLabel label_1 = new JLabel("\u65E5\u671F");
		label_1.setBounds(20, 91, 32, 15);
		panelSearch.add(label_1);

		JComboBox<String> dateCheap = new JComboBox<String>();
		dateCheap.setBounds(54, 88, 281, 21);
		panelSearch.add(dateCheap);

		JLabel label_2 = new JLabel("\u51FA\u767C\u6642\u9593");
		label_2.setBounds(20, 119, 57, 15);
		panelSearch.add(label_2);

		JComboBox<String> startTime = new JComboBox<String>();
		startTime.setBounds(75, 116, 92, 21);
		panelSearch.add(startTime);

		JLabel label_3 = new JLabel("\u62B5\u9054\u6642\u9593");
		label_3.setBounds(188, 119, 57, 15);
		panelSearch.add(label_3);

		JComboBox<String> endTime = new JComboBox<String>();
		endTime.setBounds(243, 116, 92, 21);
		panelSearch.add(endTime);

		JComboBox<String> startStation = new JComboBox<String>();
		startStation.setBounds(54, 144, 70, 21);
		panelSearch.add(startStation);

		JLabel label_4 = new JLabel("\u8D77\u7AD9");
		label_4.setBounds(20, 147, 32, 15);
		panelSearch.add(label_4);

		JComboBox<String> endStation = new JComboBox<String>();
		endStation.setBounds(168, 144, 70, 21);
		panelSearch.add(endStation);

		JLabel label_5 = new JLabel("\u8A16\u7AD9");
		label_5.setBounds(134, 147, 32, 15);
		panelSearch.add(label_5);

		JButton cheapSearch = new JButton("\u67E5\u8A62");
		cheapSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int direction = 0;
				if (startTime.getSelectedIndex() >= endTime.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "出發時間必須早於抵達時間!", "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (startStation.getSelectedIndex() == endStation.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "起站和訖站不可以一樣!", "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (startStation.getSelectedIndex() > endStation.getSelectedIndex())
					direction = 1;

				// Start Search
				try {
					winDiscount.setTitle(dateCheap.getSelectedItem() + " From " + startStation.getSelectedItem()
							+ " To " + endStation.getSelectedItem());
					winDiscount.showDiscount(Integer.parseInt(((String) dateCheap.getSelectedItem()).replace("/", "")),
							direction, Integer.parseInt(((String) startTime.getSelectedItem()).replace(":", "")),
							Integer.parseInt(((String) endTime.getSelectedItem()).replace(":", "")),
							startStation.getSelectedIndex(), endStation.getSelectedIndex());
					winDiscount.show();
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "無優惠車票!", "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cheapSearch.setBounds(248, 143, 87, 23);
		panelSearch.add(cheapSearch);

		JLabel search_ok_label = new JLabel("\u67E5\u8A62\u8A02\u7968 - \u6709\u8A02\u4F4D\u4EE3\u865F");
		search_ok_label.setFont(search_ok_label.getFont().deriveFont(search_ok_label.getFont().getStyle() | Font.BOLD));
		search_ok_label.setBounds(364, 10, 212, 15);
		panelSearch.add(search_ok_label);

		JLabel uid_ok_label = new JLabel("\u4F7F\u7528\u8005ID");
		uid_ok_label.setBounds(374, 38, 54, 15);
		panelSearch.add(uid_ok_label);

		uid_ok = new JTextField();
		uid_ok.setColumns(10);
		uid_ok.setBounds(438, 35, 241, 21);
		panelSearch.add(uid_ok);

		JLabel code_ok_label = new JLabel("\u8A02\u4F4D\u4EE3\u865F");
		code_ok_label.setBounds(374, 66, 54, 15);
		panelSearch.add(code_ok_label);

		code_ok = new JTextField();
		code_ok.setColumns(10);
		code_ok.setBounds(438, 63, 241, 21);
		panelSearch.add(code_ok);

		JButton search_ok = new JButton("\u67E5\u8A62");
		search_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uid = uid_ok.getText();
				String code = code_ok.getText();
				SearchTicket search = new SearchTicket(uid, code);
				search.exec(0);
			}
		});
		search_ok.setBounds(374, 91, 305, 23);
		panelSearch.add(search_ok);

		JLabel search_no_label = new JLabel("\u67E5\u8A62\u8A02\u7968 - \u7121\u8A02\u4F4D\u4EE3\u865F");
		search_no_label.setFont(search_no_label.getFont().deriveFont(search_no_label.getFont().getStyle() | Font.BOLD));
		search_no_label.setBounds(364, 124, 212, 15);
		panelSearch.add(search_no_label);

		JLabel uid_no_label = new JLabel("\u4F7F\u7528\u8005ID");
		uid_no_label.setBounds(374, 152, 54, 15);
		panelSearch.add(uid_no_label);

		uid_no = new JTextField();
		uid_no.setColumns(10);
		uid_no.setBounds(438, 149, 241, 21);
		panelSearch.add(uid_no);

		JLabel train_no_label = new JLabel("\u8ECA\u6B21");
		train_no_label.setBounds(374, 180, 54, 15);
		panelSearch.add(train_no_label);

		train_no = new JTextField();
		train_no.setColumns(10);
		train_no.setBounds(438, 177, 241, 21);
		panelSearch.add(train_no);

		JLabel date_no_label = new JLabel("\u65E5\u671F");
		date_no_label.setBounds(374, 208, 32, 15);
		panelSearch.add(date_no_label);

		JComboBox<String> date_no = new JComboBox<String>();
		date_no.setBounds(408, 205, 271, 21);
		panelSearch.add(date_no);

		JLabel start_no_label = new JLabel("\u8D77\u7AD9");
		start_no_label.setBounds(374, 237, 32, 15);
		panelSearch.add(start_no_label);

		JComboBox<String> start_no = new JComboBox<String>();
		start_no.setBounds(408, 234, 70, 21);
		panelSearch.add(start_no);

		JLabel start_ok_label = new JLabel("\u8A16\u7AD9");
		start_ok_label.setBounds(488, 237, 32, 15);
		panelSearch.add(start_ok_label);

		JComboBox<String> end_no = new JComboBox<String>();
		end_no.setBounds(522, 234, 70, 21);
		panelSearch.add(end_no);

		JButton search_no = new JButton("\u67E5\u8A62");
		search_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String uid = uid_no.getText();
				String train_id = train_no.getText();
				if (uid.equals("")) {
					JOptionPane.showMessageDialog(null, "UID不可為空!", "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (train_id.equals("")) {
					JOptionPane.showMessageDialog(null, "車次不可為空!", "InfoBox: Failed", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String date = (String) date_no.getSelectedItem();
				int start = start_no.getSelectedIndex();
				int end = end_no.getSelectedIndex();
				SearchOrderNum search = new SearchOrderNum(uid, train_id, Convert_Time.getDateInt(date), start, end);
				search.exec();
			}
		});
		search_no.setBounds(602, 233, 77, 23);
		panelSearch.add(search_no);

		ImageIcon ii = new ImageIcon("img/train.png");
		JLabel trainImage = new JLabel(ii);
		trainImage.setBounds(0, 20, 694, 176);
		frame.getContentPane().add(trainImage);

		initializeDate(buyDate);
		initializeDate(buyBackDate);
		initializeDate(date_no);
		initializeTime(goTime);
		initializeTime(backTime);
		initializeTime(goTime2);
		initializeTime(backTime2);
		initializeStaion(buyStart);
		initializeStaion(buyEnd);
		initializeCount(ticketCount);

		initializeDate(dateCheap);
		initializeTime(startTime);
		initializeTime(endTime);
		initializeStaion(startStation);
		initializeStaion(endStation);
		initializeStaion(start_no);
		initializeStaion(end_no);
	}

	/**
	 * Initialize Date Combo Box
	 * 
	 * @param box
	 *            a Combo Box
	 */
	private void initializeDate(JComboBox<String> box) {
		Date myDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		for (int i = 0; i < Convert_Time.FETCH_DAYS; i++) {
			String date = formatter.format(myDate);
			box.insertItemAt(date, i);

			Calendar c = Calendar.getInstance();
			c.setTime(myDate);
			c.add(Calendar.DATE, 1);
			myDate = c.getTime();
		}
		box.setSelectedItem(box.getItemAt(0));
	}

	/**
	 * Initialize Time Combo Box
	 * 
	 * @param box
	 *            a Combo Box
	 */
	private void initializeTime(JComboBox<String> box) {
		for (int hour = 0; hour < 24; hour++) {
			for (int min = 0; min < 60; min++) {
				box.addItem(String.format("%02d:%02d", hour, min));
			}
		}
	}

	/**
	 * Initialize Staion Combo Box
	 * 
	 * @param box
	 *            a Combo Box
	 */
	private void initializeStaion(JComboBox<String> box) {
		for (String sta : Station.CHI_NAME) {
			box.addItem(sta);
		}
	}

	/**
	 * Initialize Count Combo Box
	 * 
	 * @param box
	 *            a Combo Box
	 */
	private void initializeCount(JComboBox<String> box) {
		for (int i = 0; i < 10; i++) {
			box.addItem(Integer.toString(i + 1));
		}
	}

	public JPanel getPanelBook() {
		return panelBook;
	}
	
}
