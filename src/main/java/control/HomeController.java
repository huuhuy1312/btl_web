package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.DAO;
import model.Account;
import model.Category;
import model.Order;
import model.Product;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = {"/home","/trang-chu"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =UTF-8");
		
		//Get data from dao
			
			DAO proDao = new DAO();
			List<Product> listP = proDao.getAllProduct();
			Product lastProduct = proDao.getLastProduct();
			CategoryDAO catDao = new CategoryDAO();
			List<Category> listC = catDao.getAllCategory();
		//Set data to jsp
			HttpSession session = request.getSession();
			Account acc = (Account)session.getAttribute("acc");
			if(acc !=null)
			{
			List<Order> listOrder = proDao.getListOrderById(acc.getId(), acc);
			request.setAttribute("listOrder", listOrder);
			}
			request.setAttribute("listP", listP);
			request.setAttribute("listC", listC);
			request.setAttribute("lastPro", lastProduct);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
