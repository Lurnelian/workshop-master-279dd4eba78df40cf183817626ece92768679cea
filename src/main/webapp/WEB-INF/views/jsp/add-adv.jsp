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

	<script type="text/javascript" src="<c:url value="/resources/js/add-adv.js"/>"></script>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Добавить объявление о cдаче жилья</title>

</head>
<body>

	<div id="webapp-context" class="hidden-xs-up"><c:url value="/"/></div>

	<div class="jumbotron">
		<div class="container-fluid">
			<form>

				<div class="alert alert-danger hidden-xs-up" id="add-adv-error">
				</div>
				<div class="form-group row">
					<label for="advName" class="col-2 col-form-label">Название: <span class="text-danger">*</span></label>
					<div class="col-10">
						<input class="form-control" type="text" id="advName">
					</div>
				</div>
				<div class="form-group row">
					<label for="advDescription" class="col-2 col-form-label">Описание: <span class="text-danger">*</span></label>
					<div class="col-10">
						<textarea id="advDescription" class="form-control" rows="3"></textarea>
					</div>
				</div>
				<div class="form-group row">
					<label for="advAddress" class="col-2 col-form-label">Адрес: </label>
					<div class="col-10">
						<input class="form-control" type="text" id="advAddress">
					</div>
				</div>
				<div class="form-group row">
					<label for="advPhoneNumber" class="col-2 col-form-label">Телефон: </label>
					<div class="col-10">
						<input class="form-control" type="text" id="advPhoneNumber">
					</div>
				</div>
				<div class="form-group row">
					<label for="advPrice" class="col-2 col-form-label">Стоимость / сутки: <span class="text-danger">*</span> </label>
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
				<div class="form-group row">
					<input id="photosInput" type="file" name="photos" required multiple title="Прикрепите одну или более фотографий">
				</div>
				<button type="button" class="btn btn-info btn-sm" id="addAdvBtn">Добавить</button>
				<button type="button" class="btn btn-info btn-sm" id="addCancelBtn">Отмена</button>
			</form>
		</div>
	</div>

</body>
</html>