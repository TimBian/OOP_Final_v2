package controll;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import dao.DAOFactory;
import dao.TicketDAO;
import entity.Station;
import entity.Train;
import parser.MysqlExe;
import parser.MysqlExe.RetVal;

/**
 * This class is used to search the ticket by the booking code.
 * @author Jerry
 */
public class SearchTicket {
	private String uid;
	private String code;
	
	/**
	 * @param uid User ID.
	 * @param code Booking code.
	 */
	public SearchTicket(String uid, String code) {
		this.uid = uid;
		this.code = code;
	}

	/**
	 * Search the ticket.
	 * @param tostr Return string or pop the message box.
	 * @return The search result.
	 */
	public String exec(int tostr) {
		Vector<String> arr = new Vector<String>();
		TicketDAO ticketdao = DAOFactory.getTicket_DAO();
		boolean userCheck = ticketdao.getTicket(arr,uid,code);
		
		if (arr.isEmpty()) {
			JOptionPane.showMessageDialog(null, "�z��J���q��N�����~�A�Э��s��J!", "InfoBox: Failed",
					JOptionPane.ERROR_MESSAGE);
			return "";
		}
		if (!userCheck) {
			JOptionPane.showMessageDialog(null, "�z��J�������ѧO���X���~�A�Э��s��J!", "InfoBox: Failed",
					JOptionPane.ERROR_MESSAGE);
			return "";
		}
		if (tostr == 1)
			return String.join("\n", arr);
		else
			JOptionPane.showMessageDialog(null, String.join("\n", arr), "InfoBox: �d�߭q��",
				JOptionPane.INFORMATION_MESSAGE);
		return "";
	}
}
