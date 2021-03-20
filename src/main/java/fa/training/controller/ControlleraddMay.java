package fa.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.MayDao;
import fa.training.dao.MayDaoImpl;
import fa.training.entities.May;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controllermay")
public class ControlleraddMay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlleraddMay() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("/Hello.jsp");
		rd.forward(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String c = request.getParameter("mamay");
		String a = request.getParameter("vitri");
		String b = request.getParameter("trangthai");

		if (request.getParameter("vitri") != null && !request.getParameter("vitri").equals("")
				&& request.getParameter("trangthai") != null && !request.getParameter("trangthai").equals("")
				&& request.getParameter("mamay") != null && !request.getParameter("mamay").equals("")) {
			May one = new May();
			one.setTrangThai(request.getParameter("trangthai"));
			one.setViTri(request.getParameter("vitri"));
			one.setMaMay(request.getParameter("mamay"));
			MayDao mayDao = new MayDaoImpl();
			if (mayDao.save(one)) {
				String mss = "thanh cong !!";
				request.setAttribute("mss", mss);
				request.getRequestDispatcher("Hello.jsp").forward(request, response);
			}
		} else {
			String mss = "vui long nhap day du thong tin ";
			request.setAttribute("mss", mss);
			request.getRequestDispatcher("Hello.jsp").forward(request, response);
		}
		
	}
}
