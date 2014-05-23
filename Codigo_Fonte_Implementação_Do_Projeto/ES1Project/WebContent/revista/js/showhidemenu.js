$(document).ready(function() {
	
	$("#menu-top").click(function() {
		if($("#dropdown-menu-items").is(':hidden')) {
		    $("#dropdown-menu-items").show(130);
		} else {
		    $("#dropdown-menu-items").hide(130);
		}
	});

});