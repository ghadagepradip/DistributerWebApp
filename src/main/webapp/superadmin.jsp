<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="JS/validate.js"></script>
</head>
<body>

	<div class="container myflex p-5">
		<div class="nav flex-column nav-pills menubar" id="v-pills-tab"
			role="tablist" aria-orientation="vertical">
			<a class="nav-link active" id="v-pills-home-tab" data-toggle="pill"
				href="#v-pills-home" role="tab" aria-controls="v-pills-home"
				aria-selected="true">Company Master</a> <a class="nav-link"
				id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile"
				role="tab" aria-controls="v-pills-profile" aria-selected="false">Profile</a>
			<a class="nav-link" id="v-pills-messages-tab" data-toggle="pill"
				href="#v-pills-messages" role="tab" aria-controls="v-pills-messages"
				aria-selected="false">Messages</a> <a class="nav-link"
				id="v-pills-settings-tab" data-toggle="pill"
				href="#v-pills-settings" role="tab" aria-controls="v-pills-settings"
				aria-selected="false">Settings</a>
		</div>
		<div class="content ">
			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="v-pills-home"
					role="tabpanel" aria-labelledby="v-pills-home-tab">
					<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							id="pills-home-tab" data-toggle="pill" href="#pills-home"
							role="tab" aria-controls="pills-home" aria-selected="true">Add
								New Company</a></li>
						<li class="nav-item"><a class="nav-link"
							id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
							role="tab" aria-controls="pills-profile" aria-selected="false">View
								Company</a></li>
						<li class="nav-item"><a class="nav-link"
							id="pills-contact-tab" data-toggle="pill" href="#pills-contact"
							role="tab" aria-controls="pills-contact" aria-selected="false">Search
								Company</a></li>
					</ul>
					<div class="tab-content" id="pills-tabContent">
						<div class="tab-pane fade show active" id="pills-home"
							role="tabpanel" aria-labelledby="pills-home-tab">

							<form action="savevendor" method="post" name="frm"
								onsubmit="validatevendor()">
								<div class="form-group">
									<input type="text" class="form-control" value="" name="name"
										id="txtvend" placeholder="Vendor Name"
										onkeyup="validatevendor()"> <br>
									<span id="s"></span>
								</div>
								<div class="form-group">
									<input type="submit" class="form-control" name="s" id="btn"
										value="Add New Vendor">
								</div>
							</form>

						</div>
						<div class="tab-pane fade" id="pills-profile" role="tabpanel"
							aria-labelledby="pills-profile-tab">
							<%@page import="org.app.service.*,org.app.model.*,java.util.*"%>
							<%!VendorService vendservice = new VendorServiceImpl();%>
							<%
							List<VendorModel> vendorlist = vendservice.getAllVendor();
							%>
							<table class="table">
									<thead>
										<tr>
											<th scope="col">Id</th>
											<th scope="col">Name</th>
											<th scope="col">DELETE</th>
											<th scope="col">UPDATE</th>
										</tr>
									</thead>
									<tbody>
									<%
									int count=0;
								for (VendorModel vm : vendorlist) 
								{ count++;
								%>
										<tr>
											<th><%=count%></th>
											<td><%=vm.getName() %></td>
											<td><a href="delvend?vid=<%=vm.getId()%>">DELETE</a></td>
											<td><a href="updatevendor?vid=<%=vm.getId()%>&vname=<%=vm.getName()%>">UPDATE</a></td>
										</tr>
								<%
								}
								%>
									</tbody>
								</table>
						</div>
						<div class="tab-pane fade" id="pills-contact" role="tabpanel"
							aria-labelledby="pills-contact-tab">...</div>
					</div>
				</div>
				<div class="tab-pane fade p-5" id="v-pills-profile" role="tabpanel"
					aria-labelledby="v-pills-profile-tab">
					<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							id="pills-home-tab" data-toggle="pill" href="#pills-home"
							role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
							role="tab" aria-controls="pills-profile" aria-selected="false">Profile</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							id="pills-contact-tab" data-toggle="pill" href="#pills-contact"
							role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
						</li>
					</ul>
					<div class="tab-content" id="pills-tabContent">
						<div class="tab-pane fade show active" id="pills-home"
							role="tabpanel" aria-labelledby="pills-home-tab">...</div>
						<div class="tab-pane fade" id="pills-profile" role="tabpanel"
							aria-labelledby="pills-profile-tab">...</div>
						<div class="tab-pane fade" id="pills-contact" role="tabpanel"
							aria-labelledby="pills-contact-tab">...</div>
					</div>
				</div>
				<div class="tab-pane fade p-5" id="v-pills-messages" role="tabpanel"
					aria-labelledby="v-pills-messages-tab">
					<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							id="pills-home-tab" data-toggle="pill" href="#pills-home"
							role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
							role="tab" aria-controls="pills-profile" aria-selected="false">Profile</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							id="pills-contact-tab" data-toggle="pill" href="#pills-contact"
							role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
						</li>
					</ul>
					<div class="tab-content" id="pills-tabContent">
						<div class="tab-pane fade show active" id="pills-home"
							role="tabpanel" aria-labelledby="pills-home-tab">...</div>
						<div class="tab-pane fade" id="pills-profile" role="tabpanel"
							aria-labelledby="pills-profile-tab">...</div>
						<div class="tab-pane fade" id="pills-contact" role="tabpanel"
							aria-labelledby="pills-contact-tab">...</div>
					</div>
				</div>
				<div class="tab-pane fade p-5" id="v-pills-settings" role="tabpanel"
					aria-labelledby="v-pills-settings-tab">
					<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							id="pills-home-tab" data-toggle="pill" href="#pills-home"
							role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
							role="tab" aria-controls="pills-profile" aria-selected="false">Profile</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							id="pills-contact-tab" data-toggle="pill" href="#pills-contact"
							role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
						</li>
					</ul>
					<div class="tab-content" id="pills-tabContent">
						<div class="tab-pane fade show active" id="pills-home"
							role="tabpanel" aria-labelledby="pills-home-tab">...</div>
						<div class="tab-pane fade" id="pills-profile" role="tabpanel"
							aria-labelledby="pills-profile-tab">...</div>
						<div class="tab-pane fade" id="pills-contact" role="tabpanel"
							aria-labelledby="pills-contact-tab">...</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>