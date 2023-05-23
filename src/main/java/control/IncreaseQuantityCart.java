package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.Order;

/**
 * Servlet implementation class IncreaseQuantityCart
 */
@WebServlet("/IncreaseQuantityCart")
public class IncreaseQuantityCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = UTF-8"); 
		HttpSession session = request.getSession();
		Order order = (Order)session.getAttribute("order");
		for(Item item:order.getItems())
		{
			if(Integer.parseInt(request.getParameter("pid"))== item.getProduct().getId())
			{
				item.setQuantity(item.getQuantity()+1);
				order.setPriceTotal(order.getPriceTotal()+item.getProduct().getPrice());
				order.setOtherBill();
				
			}
			
		}
		session.setAttribute("order", order);
		response.sendRedirect("cartShow");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
