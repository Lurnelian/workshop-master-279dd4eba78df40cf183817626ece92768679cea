$(document).ready(function() {
	
	var webappContext = $("#webapp-context").text();
	
	var buildAdvertisementList = function (advertisements) {
		$.each(advertisements, function (index, value) {
			var media = $("<div/>").addClass("media");
			var mediaBody = $("<div/>").addClass("media-body");
			
			mediaBody.on("click", function () {
				window.location.replace(webappContext + "adv-info/" + value.id);
			});
			
			var header = $("<h5/>").addClass("mt-0");
			header.append(value.name);
			mediaBody.append(header);
			mediaBody.append(value.description);
			media.append(mediaBody);
			$("#adv-list").append(media).append("<hr/>");
		});
	};
	
	var loadAdvertisements = function () {
		
		$.ajax({
			method: "GET",
			url: webappContext + "api/advertisements",
			dataType: "json",
			cache: false
		})
		.done(function (msgs) {
			console.log("Объявления успешно получены");
			console.log(msgs);
			buildAdvertisementList(msgs);
		})
		.fail(function (err) {
			console.log("Ошибка во время получения объявлений");
		});
		
	};
	
	loadAdvertisements();
	
	$("#addAdvBtn").click(function(event) {
		
		window.location.replace(webappContext + "add-adv");
		
	});
});