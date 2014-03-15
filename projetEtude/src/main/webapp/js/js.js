$(document).ready(function() {

	$(".tab_content").hide();
	$(".tab_content:first").show(); 

	$("ul.tabs li").click(function() {
		$("ul.tabs li").removeClass("active");
		$(this).addClass("active");
		$(".tab_content").hide();
		var activeTab = $(this).attr("rel"); 
		$("#"+activeTab).fadeIn(); 
	});
	
	$(".tab_cont").hide();
	$(".tab_cont:first").show(); 
	
	$("select#bureau option").click(function() {
		$("select#bureau option").removeClass("active");
		$(this).addClass("active");
		$(".tab_cont").hide();
		var activeTab = $(this).attr("value"); 
		$("#"+activeTab).fadeIn(); 
	});
});