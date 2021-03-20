<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Custom fonts for this template-->
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
					<div style="margin: 0 auto; width: 500px">
						<h3>Them Thong Tin Dich Vu</h3>
						<form action="dichvuadd" method="post">
							<table cellspacing="5px">
								<tr>
									<td>Ma Dich Vu:</td>
									<td><input type="text" size="20px" name="madv"
										required="required"></td>
								</tr>
								<tr>
									<td>Ten Dich Vu:</td>
									<td><input type="text" size="20px" name="tendv"
										required="required"></td>
								</tr>
								<tr>
									<td>Don Vi Tinh:</td>
									<td><input type="text" size="20px" name="donvitinh"
										required="required"></td>
								</tr>
								<tr>
									<td>Don Gia:</td>
									<td><input type="text" size="20px" name="dongia"
										required="required"></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><input type="submit"
										value="Submit" style="border-radius: 10px; width: 80px">
										<input type="reset" value="Clean"
										style="border-radius: 10px; width: 80px"></td>
								</tr>
							</table>

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