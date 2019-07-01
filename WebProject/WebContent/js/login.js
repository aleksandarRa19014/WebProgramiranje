$(document).ready(function(){
	  $("#login").click(function(){
		 
		 // console.log($('#username').val());
		 
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
						//console.log(data.role);
						
						switch (data.role) { 
						case 'admin': 
							url = "http://localhost:8080/WebProject/adminHomePage.html"+ "?username="+data.userName;
							window.location.replace(url);
							break;
						case 'buyer': 
							url = "http://localhost:8080/WebProject/buyerHomePage.html"+ "?username="+data.userName;
							window.location.replace(url);
							break;
						case 'seller': 
							url = "http://localhost:8080/WebProject/sellerHomePage.html"+ "?username="+data.userName;
							window.location.replace(url);
							break;		
						}
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