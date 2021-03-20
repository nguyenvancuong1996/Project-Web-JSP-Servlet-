package fa.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.KhachhangDao;
import fa.training.dao.KhachhangImpl;
import fa.training.entities.Khachhang;

@WebServlet("/controllerkhachhang")
public class ControllerKhachhangAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/Khachhang.jsp");
		rd.forward(req, resp);
	}

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			Khachhang khachhang = new Khachhang();
			khachhang.setMaKH(request.getParameter("makhach"));
			khachhang.setTenKH(request.getParameter("tenkh"));
			khachhang.setSoDienThoai(request.getParameter("sdt"));
			khachhang.setDiaChi(request.getParameter("diachi"));
			khachhang.setDiachiEmail(request.getParameter("email"));
			KhachhangDao khachhangDao = new KhachhangImpl();
			if (khachhangDao.save(khachhang)) {
				String mss = "Thanh cong";
				request.setAttribute("mss", mss);
				request.getRequestDispatcher("Khachhang.jsp").forward(request, response);
			}
		else {
			String mss = "bi loi";
			request.setAttribute("mss", mss);
			request.getRequestDispatcher("Khachhang.jsp").forward(request, response);
		}
	}
}
