package fa.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.DichVuDao;
import fa.training.dao.DichVuImpl;

import fa.training.entities.DichVu;

@WebServlet("/dichvuadd")
public class ControllerDichVuadd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/DichVu.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DichVu dichvu = new DichVu();
		dichvu.setMaDV(request.getParameter("madv"));
		dichvu.setTenDV(request.getParameter("tendv"));
		dichvu.setDonViTinh(request.getParameter("donvitinh"));
		dichvu.setDonGia(Double.parseDouble(request.getParameter("dongia")));
		DichVuDao dichVuDao = new DichVuImpl();
		if (dichVuDao.save(dichvu)) {
			String mss = "Thanh cong";
			request.setAttribute("mss", mss);
			request.getRequestDispatcher("DichVu.jsp").forward(request, response);
		} else {
			String mss = "bi loi";
			request.setAttribute("mss", mss);
			request.getRequestDispatcher("DichVu.jsp").forward(request, response);
		}
	}
}
