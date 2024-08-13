/**
 * 
 */
$(function(){
	$("#email").focus();
	
	$(".inputField input").on("focus",function(){
		$(this).addClass("active");
		$(this).next().addClass("focus");
	});
	
	$("inputField input").on("blur",function(){
		var naxt = $$(this).val();
		if(text==''){
			$(this).removeClass("active");
			$(this).next().removeClass("focus");
		}
	});
});