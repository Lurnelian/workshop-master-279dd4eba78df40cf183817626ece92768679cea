<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/bootstrap.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/jquery-ui-1.12.1.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/lib/font-awesome-4.7.0.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/>"/>
	
	
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-1.12.4.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/tether-1.4.0.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/moment-2.17.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui-1.12.1.js"/>" ></script>
	<script type="text/javascript" src="<c:url value="/resources/js/lib/bootstrap.js"/>"></script>

	<script type="text/javascript" src="<c:url value="/resources/js/adv-info.js"/>"></script>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Объявление о сдаче жилья</title>

</head>
<body>

	<div id="webapp-context" class="hidden-xs-up"><c:url value="/"/></div>
	
	<span id="advId" class="hidden-xs-up">
		<c:out value="${id}"></c:out>
	</span>

	<div class="jumbotron">
		<div class="container-fluid">
			<form>
				<fieldset disabled>
				<div class="form-group row">
					<label for="advName" class="col-2 col-form-label">Название</label>
					<div class="col-10">
						<input class="form-control" type="text" id="advName">
					</div>
				</div>
				<div class="form-group row">
					<label for="advDescription" class="col-2 col-form-label">Описание</label>
					<div class="col-10">
						<textarea id="advDescription" class="form-control" rows="3"></textarea>
					</div>
				</div>
				<div class="form-group row">
					<label for="advAddress" class="col-2 col-form-label">Адрес </label>
					<div class="col-10">
						<input class="form-control" type="text" id="advAddress">
					</div>
				</div>
				<div class="form-group row">
					<label for="advPhoneNumber" class="col-2 col-form-label">Телефон </label>
					<div class="col-10">
						<input class="form-control" type="text" id="advPhoneNumber">
					</div>
				</div>
				<div class="form-group row">
					<label for="advPrice" class="col-2 col-form-label">Стоимость / сутки </label>
					<div class="col-8">
						<input class="form-control" type="number" id="advPrice">
					</div>
					<div class="col-2">
						<select class="form-control" id="currencySelect">
							<option>RUB</option>
							<option>EUR</option>
							<option>USD</option>
						</select>
					</div>
				</div>
				</fieldset>
				<button type="button" class="btn btn-info btn-sm" id="addCancelBtn">Отмена</button>
			</form>
		</div>
	</div>

</body>
</html>