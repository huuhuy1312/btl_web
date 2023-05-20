package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.DAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class CategoryControl
 */
@WebServlet("/category")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public CategoryControl() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =UTF-8");
		//Lay category tu Home.jsp ve
		String cateID = request.getParameter("cid");
		DAO ProDao = new DAO();
		List<Product> list = ProDao.getProbyCid(cateID);
		request.setAttribute("listP", list);
		// Boi xanh cate duoc chon
		request.setAttribute("tag", cateID);
		//common
		Product lastProduct = ProDao.getLastProduct();
		CategoryDAO catDao = new CategoryDAO();
		List<Category> listC = catDao.getAllCategory();
		request.setAttribute("listC", listC);
		request.setAttribute("lastPro", lastProduct);
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
