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
import model.Item;
import model.Order;
import model.Product;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quantity = 1;
		DAO dao = new DAO();
		if(request.getParameter("pid") !=null)
		{
			
			Product product = dao.getProbyID(request.getParameter("pid"));
			if(product!=null)
			{
				HttpSession session = request.getSession();
				if(session.getAttribute("order") == null)
				{
					
					List<Item> listItems = new ArrayList<Item>();
					Item item = new Item(product,quantity,product.getPrice());
					listItems.add(item);
					Order order = new Order();
					order.setItems(listItems);
					session.setAttribute("order", order);
					dao.addToCart(order.getItems().size());
				}
				else
				{
					Order order = (Order) session.getAttribute("order");
					List<Item> listItems = order.getItems();
					boolean check = false;
					for(Item item:listItems)
					{
						if(item.getProduct().getId() == product.getId())
						{
							item.setQuantity(item.getQuantity()+1);
							check =true;
						}
					}
					if(check == false)
					{
						Item item = new Item();
						item.setQuantity(1);
						item.setProduct(product);
						item.setPrice(product.getPrice());
						listItems.add(item);
					}
					session.setAttribute("order", order);
					dao.addToCart(order.getItems().size());
				}
			}
			
		}
		response.sendRedirect("home");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
