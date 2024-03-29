<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- <link rel="stylesheet" type="text/css" href="style.css"> -->
<link
	href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/all.min.css"
	rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
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

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Login</p>
									<c:if test="${not empty param.error}">
										<p class="text-center text-danger">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</p>
									</c:if>

									<form action="/userLogin" method="post" class="mx-1 mx-md-4">
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<label class="form-label visually-hidden"
													for="form3Example3c">Email</label> <input type="email"
													name="username" id="form3Example3c" class="form-control"
													placeholder="Email" />
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<label class="form-label visually-hidden"
													for="form3Example4c">Password</label>
												<div style="position: relative;">
													<input type="password" id="form3Example4c"
														class="form-control" name="password"
														placeholder="Password" />
													<div
														style="position: absolute; top: 50%; right: 10px; transform: translateY(-50%); cursor: pointer;"
														onclick="togglePasswordVisibility()">
														<i class="fas fa-eye"></i>
													</div>
												</div>
											</div>
										</div>


										<!-- <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="password" id="form3Example4cd" class="form-control" />
                      <label class="form-label" for="form3Example4cd">Repeat your password</label>
                    </div>
                  </div> -->

										<!-- <div class="text-center">
											<a href="/get/all/rawMaterial/"
												class="btn btn-lg btn-primary mr-2">Login</a>
										</div>  -->
										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg">Login</button>
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