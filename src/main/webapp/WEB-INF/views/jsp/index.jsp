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
	
	<script type="text/javascript" src="<c:url value="/resources/js/index.js"/>"></script>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Доска объявлений о сдаче жилья</title>

</head>
<body>

	<div id="webapp-context" class="hidden-xs-up"><c:url value="/"/></div> 

	<div class="jumbotron">
		<div class="container-fluid">
			<button class="btn btn-info btn-sm" type="button" id="addAdvBtn">
				Добавить объявление
			</button>
			
			<div id="adv-list" class="mt-2">
			</div>
			
		</div>
	</div>

</body>
</html>