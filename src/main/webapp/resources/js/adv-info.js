$(document).ready(function() {
	
	var webappContext = $("#webapp-context").text();
    $("#addCancelBtn").click(function(event) {
        window.location.replace(webappContext + "index");
    });
	var loadAdvertisementInfo = function () {
		
		$.ajax({
			method: "GET",
			url: webappContext + "api/advertisements/" + $("#advId").text(),
			dataType: "json",
			cache: false
		})
		.done(function (adv) {
			console.log("Детальная информация по объявлению успешно получена");
			console.log(adv);
			
			$("#advDescription").val(adv.description);
			$("#advName").val(adv.name);
			$("#advPrice").val(adv.price);
			$("#advAddress").val(adv.address);
			$("#advPhoneNumber").val(adv.phone);
		})
		.fail(function (err) {
			console.log("Ошибка во время получения объявления");
		});
		
	};
	
	loadAdvertisementInfo();
	
});