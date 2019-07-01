$(document).ready(function(){
	  $("#login").click(function(){
		 
		  console.log($('#username').val());
		 
		  $.ajax({
				url: "rest/userLog/logIn",
				type:"POST",
				data: JSON.stringify({
					userName: $('#username').val() ,
					password: $('#password').val() 
		        }),
				contentType:"application/json",
				dataType:"json",
				
				success: function (data) {
					if(data != null){
						console.log(data);
						url = "http://localhost:8080/WebProject/buyerHomePage.html";
						window.location.replace(url);
					}else{
						alert("Nije dobar username ili password!")
					}
	            }
				
			});
			
	  });
	  
	  $("#goBack").click(function(){
		  window.history.back();
	  });
	  
});