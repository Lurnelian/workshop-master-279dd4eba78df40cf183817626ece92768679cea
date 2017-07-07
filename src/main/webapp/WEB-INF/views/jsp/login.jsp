<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Страница входа</title>
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/bootstrap.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/jquery-ui-1.12.1.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/font-awesome-4.7.0.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/>"/>
	
	
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-1.12.4.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/tether-1.4.0.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/moment-2.17.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui-1.12.1.js"/>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/bootstrap.js"/>"></script>
	
	<script type="text/javascript" src="<c:url value="/resources/js/login.js"/>"></script>
	
</head>
<body>

<div id="webapp-context" class="hidden-xs-up"><c:url value="/"/></div> 

<div class="container">

		<form class="form-signin">
			<div class="alert alert-danger hidden-xs-up" id="login-error">
				Неверный логин/пароль
			</div>
			<label for="inputEmail" class="sr-only">Email адрес</label>
			<input type="email" name="username" id="username" class="form-control mb-1" placeholder="Email адрес" required autofocus>
			<label for="inputPassword" class="sr-only">Пароль</label>
			<input type="password" name="password" id="password" class="form-control mt-1" placeholder="пароль" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Запомнить меня
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="button" id="loginBtn">Войти</button>
		</form>

	</div>

</body>
</html>