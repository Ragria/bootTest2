$(function(){
	
	
	
	$(".delete").on("click", function(){
		
		var mNo = $(this).closest(".delete").val();
		var password = $(this).next().val();
		
		var result = prompt();
		
		if(result == password){
			$.ajax({
				type:"post",
				url:"/delete",
				dataType : "text",
				data:{"mNo":mNo},
				success: function(data){
					alert("삭제성공");
					location.reload();
				}
			})
		}
		
		
	})
	
})