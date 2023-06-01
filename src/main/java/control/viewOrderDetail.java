package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import model.Item;
import model.Order;
import model.Product;

/**
 * Servlet implementation class viewOrderDetail
 */
@WebServlet("/viewOrderDetail")
public class viewOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewOrderDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = new Order();
		int oid = Integer.parseInt(request.getParameter("oid"));
		DAO dao = new DAO();
		order = dao.getOrderById(oid);
		String input = order.getListitem();
		String[] products = input.split(",");
		List<Item> listitems = new  ArrayList<>();
		for (String product : products) {
            String[] parts = product.split("\\(");
            
            String id = parts[0].trim();
            int quantity = Integer.parseInt(parts[1].replaceAll("\\)", "").trim());
            Product pro = dao.getProbyID(id);
            Item item = new Item();
            item.setProduct(pro);
            item.setQuantity(quantity);
            item.setPrice(quantity*pro.getPrice());
            listitems.add(item);
        }
		request.setAttribute("listItems", listitems);
		request.setAttribute("orders", order);
		request.getRequestDispatcher("OrderDetail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
