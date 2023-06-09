package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Account;
import model.Order;
import model.Product;
import model.Voucher;

/**
 * Servlet implementation class ShowCartControl
 */
@WebServlet("/cartShow")
public class ShowCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html,charset = UTF-8");
		DAO dao = new DAO();
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("acc");
		Order order = (Order) session.getAttribute("order");
		
		if(order!=null)
		{
			
			List<Voucher> listVoucher = new ArrayList<>();
			listVoucher = dao.getListVoucherByIDUser(acc.getId());
			request.setAttribute("listVoucher", listVoucher);
			request.getRequestDispatcher("Cart.jsp").forward(request, response);
	
		}
		else {
			response.sendRedirect("home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
