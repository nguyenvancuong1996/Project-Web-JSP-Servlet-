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
@WebServlet("/updateKhachhang")
public class SuakhachHang extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = req.getParameter("id");
			KhachhangDao dao = new KhachhangImpl();
			Khachhang user = dao.getKhachhang(username);

			req.setAttribute("khachhang", user);
			RequestDispatcher rd = req.getRequestDispatcher("/updateKhachhang.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			KhachhangDao dao = new KhachhangImpl();
			Khachhang khachhang = new Khachhang();

			khachhang.setMaKH(req.getParameter("makh"));
			khachhang.setTenKH(req.getParameter("tenkh"));
			khachhang.setDiaChi(req.getParameter("diachi"));
			khachhang.setSoDienThoai(req.getParameter("sdt"));
			khachhang.setDiachiEmail(req.getParameter("email"));
			if (dao.update(khachhang)) {
				System.out.println("Sua Thanh Cong");
			}
			resp.sendRedirect("/hrms/listkh");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
