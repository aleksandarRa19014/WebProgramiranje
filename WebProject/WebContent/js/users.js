$(document).ready(function(){
		$('table').append('<tr><th scope="col" >Username</th><th scope="col">Name</th><th scope="col">Last name</th><th scope="col">Email</th><th scope="col">Role</th><th scope="col">Save changes</th></tr>');
		$.ajax({
			url: "rest/users/getUsers",
			type:"GET",
			dataType:"json",			
			success: function (data) {
				for (i = 0; i < data.length; i++) { 
					
					$('tbody tr:last').after('<tr>'+
											'<td id="userName'+ i+'" >'+data[i].userName+'</td>'+
											'<td >'+data[i].name+'</td>'+
											'<td>'+data[i].lastName+'</td>'+
											'<td>'+data[i].email+'</td>'
											+'<td><select id="combobox'+i+'" value=' + data[i].role +'>'
											   +'<option selected hidden>Choose here</option>'	
											   +'<option value="buyer">Buyer</option>'
											   +'<option value="admin">Admin</option>'
											   +'<option value="seller">Seller</option>'
											   +'</select> </td>'
											   +'<td> <button type="button" class="btn btn-primary btn-md" id="'+ i+'"' + '>Save change</button> </td></tr>'
											   
											);
				}
				
				
				
			}
			
		});
		$('body').on('click', 'button', function(e) {
			
			var cellUserName = $('table').find("#userName"+e.target.id).text();
			var selectedRole = $("#combobox"+e.target.id).find('option:selected').val();
		    console.log(cellUserName); 
		    console.log(selectedRole);
		    
		    
		    $.ajax({
				url: "rest/users/changeRole",
				type:"POST",
				data: JSON.stringify({
					role: selectedRole ,
					userName: cellUserName 
		        }),
				contentType:"application/json",
				dataType:"json",
				
				success: function (data) {
					
						alert("Uspesno ste pormenili ulogu korisnika: "+ data.userName+ " u ulogu: "+ data.role );	
	            }
				
			});
		    
		   
		});
	
});



	  
	  
	  
	  
	  
	  