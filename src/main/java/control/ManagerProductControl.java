package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Account;
import model.Product;

/**
 * Servlet implementation class ManagerProductControl
 */
@WebServlet({  "/managerProduct" })
public class ManagerProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = UTF-8");
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc");
		int sid = a.getId();
		DAO dao = new DAO();
		List<Product> list = dao.getProbySellId(sid);
		request.setAttribute("listP", list);
		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
