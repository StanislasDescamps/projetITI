$(document).ready(function(){

	menu = jQuery('#menu');
	cont = jQuery('#navigation');
	
	menu.hide();
	//menu mobile
	jQuery('.mobile_menu').click(function(){
		
		if(menu.is(':visible')){
			menu.hide("slide", { direction: "left" }, 500);
			cont.switchClass("visible", "invisible", 510, "easeInOutQuad");
		} else {
			menu.show("slide", { direction: "left" }, 510);
			cont.switchClass("invisible", "visible", 500, "easeInOutQuad");
		}
	});	
});