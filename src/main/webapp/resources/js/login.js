$(document).ready(function() {
	
	var webappContext = $("#webapp-context").text();
	
	$("#loginBtn").click(function(event) {
		
		$.ajax({
			method: "POST",
			url: webappContext + "api/login",
			data: {
				username: $("#username").val(),
				password: $("#password").val()
			},
			dataType: "text",
			cache: false
		})
		.done(function (msg) {
			console.log("Аутентификация успешна");
			window.location.replace(webappContext + "index");
		})
		.fail(function (err) {
			console.log("Ошибка во время аутентификации");
			$("#login-error").removeClass("hidden-xs-up");
		});
		
	});
});