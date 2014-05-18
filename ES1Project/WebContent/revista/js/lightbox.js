$(function() {
	$(document).on('click', "#fade", function() {
		killLightBoxWithFire();
	});
});

function summonLightBox(url) {
	var content = '<p class="delete_message">Você tem certeza que deseja excluir a revista?</p><br/><a class="select_lightbox_option" id="optionInLightBox" href="'+url+'" >Sim</a>&nbsp;&nbsp;<a id="optionInLightBox" href="javascript:void(0)" onclick = "killLightBoxWithFire()" class="select_lightbox_option" >Não</a>';
	$('#light').removeClass("hidden").html(content);
	$('#fade').removeClass("hidden");
}

function killLightBoxWithFire() {
	$('#light').addClass("hidden");
	$('#fade').addClass("hidden");
}