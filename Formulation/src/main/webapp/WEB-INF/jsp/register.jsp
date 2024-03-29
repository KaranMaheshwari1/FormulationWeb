<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<link
	href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/all.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Registration</title>
</head>



<body>
	<jsp:include page="navbar.jsp" />
	<section class="vh-100 section-with-background"
		style="background-image: url('https://c4.wallpaperflare.com/wallpaper/209/848/50/technology-physics-and-chemistry-chemistry-hd-wallpaper-preview.jpg')">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">

								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<c:if test="${not empty sessionScope.msg}">
										<div class="alert alert-info text-center"
											style="color: green; background-color: transparent; border: none; font-weight: bold; font-size: 1.2em;">
											${sessionScope.msg}</div>
									</c:if>

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-1">New
										User
									<form action="register" method="post" class="mx-1 mx-md-4">

										<!-- to call addUser Api -->

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example1c">First
													Name</label> <input type="text" id="form3Example1c"
													name="firstName" class="form-control" required />
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example1c">LastName</label>
												<input type="text" id="form3Example1c" name="lastName"
													class="form-control" required />

											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="form3Example3c">
													Email</label> <input type="email" id="form3Example3c" name="email"
													class="form-control" required />

											</div>
										</div>


										<!-- password field
										 <div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="form3Example4c"
													class="form-control" /> <label class="form-label"
													for="form3Example4c">Password</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="form3Example4cd"
													class="form-control" /> <label class="form-label"
													for="form3Example4cd">Repeat your password</label>
											</div>
										</div> -->

										<!-- captcha functionality
										
										 <div style="margin-top: 20px;"></div>

										<div id="captchaContainer"
											class="row justify-content-center text-center">
											<div class="col-md-4"
												style="padding-top: 5px; padding-bottom: 5px;">
												<input type="text" id="backendCaptcha" readonly
													class="form-control mb-2"
													style="background-color: #007fff; color: #ffffff; text-align: center; font-size: 20px;">
											</div>
											<div class="col-md-4"
												style="padding-top: 5px; padding-bottom: 5px;">
												<input type="text" id="captchaInput"
													placeholder="Enter CAPTCHA" class="form-control mb-2"
													style="background-color: #ffffff; color: #333333; text-align: center; font-size: 20px">
												<span id='captcha-err-msg' style="color: red"></span>
											</div>

											<div class="col-md-1"
												style="padding-top: 5px; padding-bottom: 1px;">
												<button id="refreshButton" onclick="getCaptcha()"
													class="btn btn-primary mb-2"
													style="background-color: #007fff; color: #fff; border: none; border-radius: 15px; cursor: pointer; font-size: 20px; box-shadow: 0px 3px 0px #005BB5, 0px 2px 10px rgba(0, 0, 0, 0.2);">&#8635;</button>
											</div>
											<div class="col-md-4"
												style="padding-top: 5px; padding-bottom: 5px;">
												This is where captcha-err-msg will be placed
											</div>
										</div> -->
										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg">Add
												User</button>
										</div>

									</form>

								</div>
								<div
									class="col-md-12 col-lg-9 col-xl-7 d-flex align-items-center order-1 order-lg-2">
									<img
										src="https://media.istockphoto.com/id/624034258/photo/flask-in-scientist-hand-with-laboratory-background.jpg?s=1024x1024&w=is&k=20&c=YawLNKwNdrDY4mmu_5chk_fyeP2y1LxEvN1jgtWcYwo="
										style="max-width: 100%; height: auto;">
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


</body>
</html>