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

import model.Item;
import model.Order;

/**
 * Servlet implementation class reduceQuantityCart
 */
@WebServlet("/reduceQuantityCart")
public class reduceQuantityCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = UTF-8"); 
		HttpSession session = request.getSession();
		Order order = (Order)session.getAttribute("order");
		
		if(order.getItems() !=null)
		{
			for(Item item:order.getItems())
			{
				if(Integer.parseInt(request.getParameter("pid"))== item.getProduct().getId())
				{
					if(item.getQuantity() >1)
					{
					item.setQuantity(item.getQuantity()-1);
					order.setPriceTotal(order.getPriceTotal()-item.getProduct().getPrice());
					order.setOtherBill();
					}
					else {
						List<Item> listItems = new ArrayList<>(order.getItems());
						for(Item i: listItems)
						{
							if(i.equals(item) ==true)
							{
								listItems.remove(i);
								break;
							}
						}
						order.setItems(listItems);
						order.setPriceTotal(order.getPriceTotal()-item.getProduct().getPrice());
						if(order.getPriceTotal()==0)
						{
							order.setShipFee(0);
							order.setVoucher(null);
						}
						order.setOtherBill();
						
					}
				}
				
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
