var supprimerEventOui = function(idCommission){
	$.post("supprimerAsso", {
		idComm : idCommission
	}).done(function() {
		location.reload(true);
		console.log("fait");
	});
	
};

$(document).ready(function(){
	
	jQuery(".btnSuppr").click(function(){
		var num =this.id;
		var verif= confirm("Etes-vous sûr de vouloir supprimer cette association?");
		if(verif){
			supprimerEventOui(num);
		}else{
			console.log("Error");
		}
	});
});