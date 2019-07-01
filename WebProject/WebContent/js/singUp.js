$(document).ready(function(){
	  $("#goBack").click(function(){
		  window.history.back();
	  }); 
});

$(document).ready(function(){
	  $("#singUp").click(function(){
		  
		  if($('#username').val()!="" && $('#psw').val()!=""
			 && $('#name').val()!="" && $('#lastName').val()!="" 
		     && $('#contactPh').val()!="" && $('#town').val()!=""
		   	 && $('#email').val()!=""){
			  
				  $.ajax({
						url: "rest/user/singUp",
						type:"POST",
						data: JSON.stringify({
							userName: $('#username').val() ,
							password: $('#psw').val(), 
				            name: $('#name').val() ,
				            lastName: $('#lastName').val() ,
				            contactPh: $('#contactPh').val() ,
				            town: $('#town').val() ,
				            email: $('#email').val()    
				        }),
						contentType:"application/json",
						dataType:"json",
						
						success: function (data) {
							if(data != null){
								console.log(data);
								url = "http://localhost:8080/WebProject/buyerHomePage.html";
								window.location.replace(url);
							}else{
								alert("Postoji korisnik sa tim Username!")
							}
			            }
						
					}); 
				  	
		  }
		  
	  }); 
	  
	  $("#goBack").click(function(){
		  window.history.back();
	  });
});

