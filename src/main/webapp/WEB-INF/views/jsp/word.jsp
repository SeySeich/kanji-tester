<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Modern an Admin Panel Category Flat Bootstarp Resposive
	Website Template | Forms :: w3layouts</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"> <!-- , maximum-scale=1.0, user-scalable=no"> -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- Bootstrap Core CSS -->
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel='stylesheet' type='text/css' />
<spring:url value="/resources/css/font-awesome.css" var="faCss" />
<link href="${faCss}" rel="stylesheet" >
<!-- jQuery -->
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>
<spring:url value="/resources/js/jquery.session.js" var="jquerySessionJs" />
<script src="${jquerySessionJs}"></script>
<!----webfonts--->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!-- Bootstrap Core JavaScript -->
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<script src="${bootstrapJs}"></script>
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<div id="page-wrapper">
			<div class="graphs">
				<div class="xs">
					<h3>Слово</h3>
					<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal">
								<div>
									<input id="wordId" type="hidden" value="" >
								</div>
								<div class="form-group">
									<div class="text-center" >
										<span class="col-lg-12 kanji" style="font-size: 750%">水</span>
									</div>
								</div>
								<div class="form-group" >
									<div class="text-center" >
										<span class="col-lg-12 hiragana" style="font-size: 500%">みず</span>
									</div>
								</div>
								<div class="form-group meanings-div container-fluid" >
									<div class="text-center" >
										<h4>Значения</h4>
									</div>
									<div class="row" >
										<div class="col-md-6 col-xs-6 meaning-holder" >
											<div class="checkbox-inline" >
												<label><input type="checkbox"  >
													<span id="meaning1">
														Вода
													</span>
												</label>
											</div>
										</div>
										<div class="col-md-6 col-xs-6 meaning-holder" >
											<div class="checkbox-inline" >
												<label><input type="checkbox"  >
													<span id="meaning2">
														Вода
													</span>
												</label>
											</div>
										</div>
									</div>
									<div class="row" >
										<div class="col-md-6 col-xs-6 meaning-holder" >
											<div class="checkbox-inline" >
												<label><input type="checkbox"  >
													<span id="meaning3">
														Вода
													</span>
												</label>
											</div>
										</div>
										<div class="col-md-6 col-xs-6 meaning-holder" >
											<div class="checkbox-inline" >
												<label><input type="checkbox"  >
													<span id="meaning4">
														Вода
													</span>
												</label>
											</div>
										</div>
									</div>
									<div class="row" >
										<div class="col-md-6 col-xs-6 meaning-holder" >
											<div class="checkbox-inline" >
												<label><input type="checkbox"  >
													<span id="meaning5">
														Вода
													</span>
												</label>
											</div>
										</div>
										<div class="col-md-6 col-xs-6 meaning-holder" >
											<div class="checkbox-inline" >
												<label><input type="checkbox"  >
													<span id="meaning6">
														Вода
													</span>
												</label>
											</div>
										</div>
									</div>
									<div class="row" >
										<div class="col-md-6 col-xs-6 meaning-holder" >
											<div class="checkbox-inline" >
												<label><input type="checkbox"  >
													<span id="meaning7">
														Вода
													</span>
												</label>
											</div>
										</div>
										<div class="col-md-6 col-xs-6 meaning-holder" >
											<div class="checkbox-inline" >
												<label><input type="checkbox"  >
													<span id="meaning8">
														Вода
													</span>
												</label>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group" >
									<div class="col-md-12 col-xs-12" >
										<button id="check" class="btn btn-primary btn-block" >Проверить</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="copy_layout">
					<p>
						Copyright © 2015 Modern. All Rights Reserved | Design by <a
							href="http://w3layouts.com/" target="_blank">W3layouts</a>
					</p>
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- Nav CSS -->
	<spring:url value="/resources/css/custom.css" var="customCss" />
	<link href="${customCss}" rel="stylesheet">
	<!-- Metis Menu Plugin JavaScript -->
	<spring:url value="/resources/js/metisMenu.min.js" var="metisJs" />
	<script src="${metisJs}"></script>
	<spring:url value="/resources/js/custom.js" var="customJs" />
	<script src="${customJs}"></script>
	<spring:url value="/resources/js/custom/word.js" var="wordJs" />
	<script src="${wordJs}" ></script>
</body>
</html>
