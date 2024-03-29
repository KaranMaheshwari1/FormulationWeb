<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>RawMaterial</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/all.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>

<body>
	<%@ include file="navbar.jsp"%>
	<section class="vh-100 section-with-background"
		style="background-image: url('https://c4.wallpaperflare.com/wallpaper/209/848/50/technology-physics-and-chemistry-chemistry-hd-wallpaper-preview.jpg')">
		<div class="card text-black" style="border-radius: 25px;">
			<form action="${contextPath}/add/rawMaterial" method="post">
				<div class="card-body p-md-5 p-mt-31">
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="rmNumber">RM-Number</label> <input type="text"
									class="form-control rounded" id="rmNumber" name="rmNumber"
									style="max-width: 300px;">
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label for="rmName">RM-Name</label> <input type="text"
									class="form-control rounded" id="rmName" name="rmName"
									style="max-width: 300px;">
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label for="otherProperty">Quantity</label> <input type="text"
									class="form-control rounded" name="quantity"
									style="max-width: 300px;">
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label for="otherProperty">Unit</label> <select
									class="form-control rounded" name="unit"
									style="max-width: 300px;">
									<option value="gm">gm</option>
									<option value="kg">kg</option>
									<option value="liter">liter</option>
								</select>
							</div>
						</div>

						<div class="col">
							<div class="form-group">
								<label for="otherProperty">Other property</label> <input
									type="text" class="form-control rounded" name="otherProperty"
									style="max-width: 300px;">
							</div>
						</div>








						<div class="col-auto align-self-end">
							<button type="submit" class="btn btn-primary btn-add">Add</button>
						</div>
					</div>
				</div>
			</form>
			<hr
				style="margin-top: 20px; margin-bottom: 20px; border: 0; border-top: 2px solid green;">
			<div class="text-center" style="margin-top: 20px;">
				<label
					style="font-weight: bold; color: green; font-style: italic; font-size: 20px; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);">
					Raw Material List </label>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">RM-Number</th>
							<th scope="col">RM-Name</th>
							<th scope="col">Quantity</th>
							<th scope="col">Unit</th>
							<th scope="col">Other Properties</th>
							<th scope="col">Actions</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allraw}" var="rawItem">
							<tr>
								<td>${rawItem.rmNumber}</td>
								<td>${rawItem.rmName}</td>
								<td>${rawItem.quantity}</td>
								<td>${rawItem.unit}</td>
								<td>${rawItem.otherProperty}</td>
								<td><a href="/rawMaterial/byId/${rawItem.rmId}"
									class="btn btn-sm btn-primary mr-2">Edit</a> <a
									href="/delete/rawMaterial${rawItem.rmId}"
									class="btn btn-sm btn-danger ml-4">Delete</a> <a href="#"
									class="btn btn-sm btn-success ml-4">logs</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</section>
</body>
</html>
