package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Order;
import model.Voucher;

/**
 * Servlet implementation class getVoucher
 */
@WebServlet("/getVoucher")
public class getVoucher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getVoucher() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =UTF-8");
		HttpSession session = request.getSession();
		Order order = (Order)session.getAttribute("order");
		if(order.getPriceTotal() >0)
		{
			DAO dao = new DAO();
			int vid = Integer.parseInt(request.getParameter("vid"));
			Voucher voucher = dao.getVoucherById(vid);
			if(order.getVoucher()!=null)
			{
			if(order.getVoucher().getId() == voucher.getId())
			{
				order.setVoucher(null);
			}
			else
			{
				order.setVoucher(voucher);
			}}
			else {
				order.setVoucher(voucher);
			}
			
			order.setOtherBill();
			session.setAttribute("order", order);
			response.sendRedirect("cartShow");
		}
		else {
			response.sendRedirect("cartShow");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
