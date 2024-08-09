/*


*/

	let inputType=[];
	let inputName=[];

	$(function(){ //window.onload
	
		$("#del").on("click", function(){
		
			var isOk = confirm("정말로 삭제하시겠습니까?");
			if(isOk){
				$("#fm").submit();
			}	
		});
	
		$("#modify").on("click",function(){
			$.each($(".value") , function(i, v){ // i - 인덱스, v - i인덱스의 값
				var text=$(v).text().trim();
				$(v).html("<input type='' name='' value='"+text+"'>");
			});
			
		});

});