$(function() {
	var doubleTypeInputs = new Array();

	var form = $(".form");

	var priceFrom = $(".precoDe");
	var priceFor = $(".precoPor");

	doubleTypeInputs.push(priceFor);
	doubleTypeInputs.push(priceFrom);

	// Apply Double Type masks
	$.each(doubleTypeInputs, function(index, data) {
		data.mask('09999.00');
	});

	$.validator.addMethod("greaterThan",

	function (value, element, param) {
		var $min = $(param);
		if (this.settings.onfocusout) {
			$min.off(".validate-greaterThan").on("blur.validate-greaterThan", function () {
			$(element).valid();
			});
		}
		
		return parseInt(value) > parseInt($min.val());
	}, "Preço de deve ser maior que preço por.");

	form.validate({
		submitHandler : function(form) {
			form.submit();
		},
		rules : {
			"nome" : {
				required : true
			},
			"tema" : {
				required : true
			},
			"precoDe" : {
				required : true,
				number: true,
				greaterThan: '.precoPor'
			}, 
			"precoPor" : {
				required : true,
				number: true
			}
		},
		messages : {
			"nome" : {
				required : "Este campo é obrigatório.",
			},
			"tema" : {
				required : "Este campo é obrigatório.",
			},
			"precoDe"  : {
				required : "Este campo é obrigatório.",
				number: "Este campo deve ser um número."
			}, 
			"precoPor"  : {
				required : "Este campo é obrigatório.",
				number: "Este campo deve ser um número."
			}
		}
	});
});