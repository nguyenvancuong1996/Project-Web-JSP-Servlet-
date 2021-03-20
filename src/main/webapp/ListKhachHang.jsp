<%@page import="fa.training.entities.Khachhang"%>
<%@page import="fa.training.entities.May"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en"
	xmlns:th="http://www.springframework.org/schema/data/jaxb">
<head>
<title>User List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="./css/all.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="./fontawesome-free-5.15.1-web/css/all.min.css">
<!-- Custom styles for this template-->
<link href="./css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">

	<div id="wrapper">


		<%@ include file="common/navica.jsp"%>

		<div id="content-wrapper" class="d-flex flex-column">


			<div id="content">
				<%@ include file="common/header.jsp"%>
				<div class="container">
					<div class="row bg-dark p-3">
						<h2 style="color: white;" class="col-6"></h2>
						<div class="col-6 text-right">

							<a href="controllerkhachhang" style="background-color: green;" type="submit"
								class="btn btn-primary"> <i class="fas fa-plus-circle">
									Add Khach Hang</i>
							</a>

						</div>
					</div>
					<div style="margin: 0 auto; width: 550px">
						<h3 align="left">Show Danh Sach Khach Hang</h3>
						<form action="controllerkhachhang" method="post">
							<div class="row">
								<table border="1" cellpadding="5">
									<tr>
										<th>Ma Khach Hang</th>
										<th>Ten Khach Hang</th>
										<th>Dia Chi</th>
										<th>So Dien Thoai</th>
										<th>Email</th>
										<th>Thao Tac</th>
									</tr>
									<tbody>
									
										<c:forEach items="${listkhach}" var="khach">
											<tr class="row-table">
												<td>${khach.maKH}</td>
												<td>${khach.tenKH}</td>
												<td>${khach.diaChi}</td>
												<td>${khach.soDienThoai}</td>
												<td>${khach.diachiEmail}</td>
												<td><a href="updateKhachhang?id=${khach.maKH}"
													class="btn text-warning"> <i class="fa fa-edit"></i>
												</a> <a href="DeleteMay?id=${khach.maKH}" class="btn text-danger">
														<i class="fa fa-trash"></i>
												</a></td>


											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</form>
						<h1 style="color: red">

							<%
								if (request.getAttribute("mss") != null) {
							%>
							<%=request.getAttribute("mss")%>
							<%
								}
							%>
						</h1>

					</div>

				</div>
				<div class="row">
					<div class="col-6">
						Showing <b>5</b> out of <b>25</b> entries
					</div>
					<div class="col-6 d-flex justify-content-end">
						<nav aria-label="Page navigation ">
							<ul class="pagination">
								<li class="page-item disabled"><a class="page-link"
									href="#" aria-label="Previous"> <span aria-hidden="true">Previous</span>

								</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item active"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">4</a></li>
								<li class="page-item"><a class="page-link" href="#">5</a></li>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">Next</span>

								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<%@ include file="common/footer.jsp"%>
		</div>


	</div>

	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
	<script src="./js/jquery.min.js"></script>
</body>
</html>