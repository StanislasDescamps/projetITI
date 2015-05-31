var marquerParticipationOui = function(idEvenement) {	
	
	$.post("participe", {
		idEvent : idEvenement, participer:"Participer"
	}).done(function() {
		console.log("fait");
	});
};

var recupereParticipation = function(idEvenement) {
	
	var bool=false;
	$.getJSON("participe", function(json) {
		
		var longueurListe=json.length;
		var i=0;
				
		while(i<longueurListe && bool==false){
			
			if(idEvenement==json[i]){
				bool=true;
			}else {
				i++;
			}
		}	
	}).done(function(){
		
		btnParticipation=jQuery('#'+idEvenement);
		
		if(bool==false){
			btnParticipation.addClass('btnParticipe');
		}else if(bool==true){
			btnParticipation.addClass('btnNoParticipe');
		}else{
			console.log("Error");
		}
	});
};

var marquerParticipationNon = function(idEvenement) {
	
	$.post("participe", {
		idEvent : idEvenement, participer:"Ne plus Participer"
	}).done(function() {
		console.log("fait");
	});
};

$(document).ready(function(){

	jQuery(".btnParticipation").click(function(){
		var num =this.id;
		if($(this).hasClass('btnParticipe')){
			marquerParticipationOui(num);
			$(this).removeClass('btnParticipe').addClass('btnNoParticipe');
		}else if($(this).hasClass('btnNoParticipe')){
			marquerParticipationNon(num);
			$(this).removeClass('btnNoParticipe').addClass('btnParticipe');
		}else{
			console.log("Error");
		}
	});
		
	$('.btnParticipation').each(function(){
		
		var idEvent=this.id;
		recupereParticipation(idEvent);		
	});
	
	description = jQuery('.description');
	cont = jQuery('.touteDescription');
		
	description.hide();
	//menu mobile
	jQuery('.touteDescription').click(function(){
		
		var num =this.id;
		descrip= jQuery('#description_'+num);
		btnNum= jQuery('.btnScroll_'+num);
		
		if(descrip.is(':visible')){
			descrip.hide("slide", { direction: "up" }, 400);
			cont.switchClass("packed", "unpacked", 410, "easeInOutQuad");
			btnNum.removeClass("up").addClass("down");
		} else {
			descrip.show("slide", { direction: "up" }, 410);
			cont.switchClass("unpacked", "packed", 400, "easeInOutQuad");
			btnNum.removeClass("down").addClass("up");
		}
	});	
});