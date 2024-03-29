<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/all.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<section class="vh-100 section-with-background"
		style="background-image: url('https://c4.wallpaperflare.com/wallpaper/209/848/50/technology-physics-and-chemistry-chemistry-hd-wallpaper-preview.jpg')">
		<div class="card text-black" style="border-radius: 25px;">
			<form action="${contextPath}/saveformula" method="post">
				<div class="card-body p-md-5 p-mt-31">
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="recipeNumber">Recipe-Number</label> <input
									type="text" class="form-control rounded" id="recipeNumber"
									name="fmNumber" style="max-width: 300px;">
							</div>
						</div>
						<div class="col">
							<div class="form-group">
								<label for="recipeName">Recipe-Name</label> <input type="text"
									class="form-control rounded" id="recipeName" name="formulaName"
									style="max-width: 300px;">
							</div>
						</div>
					</div>
				</div>
				<hr
					style="margin-top: 20px; margin-bottom: 20px; border: 0; border-top: 2px solid green;">
				<div class="text-center" style="margin-top: 20px;">
					<label
						style="font-weight: bold; color: green; font-style: italic; font-size: 20px; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);">
						Raw Material List </label>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Select</th>
								<th scope="col">RM-Number</th>
								<th scope="col">RM-Name</th>
								<th scope="col">Other Properties</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allraw}" var="rawItem">
								<tr>
									<td><label class="checkbox-label"> <input
											type="checkbox" name="selectedRawMaterials"
											value="${rawItem.rmId}"> <span
											class="custom-checkbox"></span>
									</label></td>
									<td>${rawItem.rmNumber}</td>
									<td name="rmName" >${rawItem.rmName}</td>
									<td>${rawItem.otherProperty}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Save Recipe</button>
				</div>
			</form>
		</div>
	</section>
</body>
</html>
