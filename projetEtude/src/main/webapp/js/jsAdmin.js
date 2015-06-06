var recupereResponsabilite = function(idetudiant,resp) {
	
	$.getJSON("assignation",{idEtudiant:idetudiant}) 
		 
	  .done(function(json) {
	   
		  //console.log("idEtudiant: "+idetudiant+"\nresp: "+resp+"\njson: "+json);
		  		  
		  if(resp=="pole"){
			  assignationPole=jQuery(".assignPole_"+idetudiant);
			  
			  assignationPole.show();
			  assignationPole.val(json);
		  }else if(resp=="comm"){
			  assignationComm=jQuery(".assignComm_"+idetudiant);
			  
			  assignationComm.show();
			  assignationComm.val(json);
		  }
	  })
	  .fail(function() {
	    console.log( "error" );
	  });
};

var assignerDroit = function(idetudiant,droit){
	$.post("assignation", {
		idEtudiant : idetudiant, droits : droit
	}).done(function() {
		$(".btnVal_"+idetudiant).hide();
		console.log("fait");
	}).fail(function() {
	    console.log( "error" );
	  });
};

var assignerPoleComm = function(idetudiant,droit,quoi){
	$.post("assignation", {
		idEtudiant : idetudiant, droits : droit, assignation : quoi
	}).done(function() {
		$(".btnVal_"+idetudiant).hide();
		console.log("fait");
	}).fail(function() {
	    console.log( "error" );
	  });
};


$(document).ready(function() {
	
	$(".assignation").hide();
	$(".btnValider").hide();
	
	jQuery(".droits").each(function(){
		var num=this.id;
		var choix=$("#"+num+" option:selected").val();
		
		//console.log("idEtudiant:"+num+"\nResp:"+choix);
		
		if(choix==2){
			assignationPole=jQuery(".assignPole_"+num);
			result=recupereResponsabilite(num,"pole");
			
			//console.log("ok");
			
		}else if(choix==1){
			assignationComm=jQuery(".assignComm_"+num);
			result=recupereResponsabilite(num,"comm");
			
			//console.log("ok");

		}
	});
	
	jQuery("select").change(function(){;
		
		var num=this.id;
		var choix=$("#"+num+" option:selected").val();
				
		assignationComm=jQuery(".assignComm_"+num);
		assignationPole=jQuery(".assignPole_"+num);
		btnValider=jQuery(".btnVal_"+num);
		
		if(choix==1){
			if(assignationPole.is(":visible")){
				assignationPole.hide();
			}
			assignationComm.show();
			btnValider.show();
		}else if(choix==2){
			if(assignationComm.is(":visible")){
				assignationComm.hide();
			}
			assignationPole.show();
			btnValider.show();
		}else if(choix==0 || choix==3){
				assignationComm.hide();
				assignationPole.hide();
				
				btnValider.show();
		}
	});	
	
	jQuery(".btnValider").click(function(){
		var idEtudiant =this.id;
		
		var choix=$("#"+idEtudiant+" option:selected").val();
				
		if(choix==0 || choix==3){
			assignerDroit(idEtudiant,choix);
		}else if(choix==1){
			var comm=$(".assignComm_"+idEtudiant+" option:selected").val();
			assignerPoleComm(idEtudiant,choix,comm);
		}else if(choix==2){
			var pole=$(".assignPole_"+idEtudiant+" option:selected").val();
			assignerPoleComm(idEtudiant,choix,pole);
		}
	});
});

