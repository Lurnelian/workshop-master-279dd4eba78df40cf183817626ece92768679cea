$(document).ready(function() {
	
	var webappContext = $("#webapp-context").text();
	
	/*function prepareFiles(files) {
		console.lg
	}*/
    $("#addCancelBtn").click(function(event) {
            window.location.replace(webappContext + "index");
    });
	$("#addAdvBtn").click(function(event) {
		
		//var files = prepareFiles($("#photosInput")[0].files);
		
		var price = null;
		if ($("#advPrice").val() && $("#currencySelect").val()) {
			 price = $("#advPrice").val() + " " + $("#currencySelect").val();
		}
		$.ajax({
			method: "POST",
			url: webappContext + "api/advertisements",
			data: JSON.stringify({
				name: $("#advName").val(),
				description: $("#advDescription").val(),
				price: price,
				address: $("#advAddress").val(),
				phone: $("#advPhoneNumber").val()
			}),
			contentType: 'application/json',
			dataType: "json",
			cache: false
		})
		.done(function (msg) {
			window.location.replace(webappContext + "index");
		})
		.fail(function (err) {
			$("#add-adv-error").empty();
			$("#add-adv-error").removeClass("hidden-xs-up");
			var response = JSON.parse(err.responseText);
			$("#add-adv-error").append(response.message);
		});
		
	});
});