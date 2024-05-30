<%@page import="com.org.dto.Doctor"%>
<%@page import="com.org.dto.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.SpecialistDao"%>
<%@page import="com.org.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>

	<%@include file="admin_Navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Doctor</p>

						<form action="../add_doctor" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input name="name"
									type="text" class="form-control" required value="hello">
							</div>
							<div class="mb-3">
								<label class="form-label">DOB</label> <input name="dob"
									type="date" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select
									name="specName" class="form-control">
									<option>select</option>

									<%
									SpecialistDao specDao = new SpecialistDao();
									List<Specialist> specList = specDao.fetchAllSpecialist();

									for (Specialist s : specList) {
									%>
									<option><%=s.getName()%></option>

									<%
									}
									%>
								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									name="qualification" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input name="email"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile No</label> <input name="mobile"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Register</button>

						</form>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Doctor Details</p>
						<table class="table">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>DOB</th>
									<th>Qulification</th>
									<th>Specialist</th>
									<th>Email</th>
									<th>Mobile No</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								DoctorDao docDao = new DoctorDao();
								List<Doctor> doctorList = docDao.fetchAllDoctors();

								for (Doctor d : doctorList) {
								%>

								<tr>

									<td><%=d.getName()%></td>
									<td><%=d.getDob()%></td>
									<td><%=d.getQualification()%></td>
									<td><%=d.getSpecName()%></td>
									<td><%=d.getEmail()%></td>
									<td><%=d.getMobileNo()%></td>
									<td>
										<a href="admin_home.jsp?id=<%=d.getId() %>" class="btn btn-primary btn-sm">Edit</a>
										<a href="#" class="btn btn-danger btn-sm">Delete</a>
									</td>
								</tr>
								<%
								}
								%>
								<tr>

								</tr>

							</tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>

</body>
</html>