$(document).ready(function(){
	console.log("admin");  
	console.log(window.location.href);
	
	
	//crud category
	
	$('table').append('<tr><th scope="col" >Name category</th><th scope="col">Description</th><th scope="col">Edit</th><th scope="col">Delete</th></tr>');
	$.ajax({
		url: "rest/crudCategory/getCategories",
		type:"GET",
		dataType:"json",			
		success: function (data) {
			if(data != null){
					for (i = 0; i < data.length; i++) { 
						
						$('tbody tr:last').after('<tr><td id="name'+ i+'" >'+data[i].name+'</td>'+
												'<td id="description'+ i+'" >'+data[i].description+'</td>'
												+'<td> <button type="button" class="btn btn-primary btn-md" id="edt-'+ i+'"' + '>Edit category</button> </td>'
												+'<td> <button type="button" class="btn btn-danger btn-md" id="del-'+ i+'"' + '>Delete category</button> </td></tr>' 
												);
					}
			}
			
			
		}
		
	});
	
	var cellName;
	var cellDescription;
	
	$('#tableCateg').on('click', 'button', function(e) {
		console.log(e.target.id);
		var val = e.target.id;
		val = val.split("-");

		    var btn = val[0];
		    var rowNmb = val[1];
		    console.log(btn);
		    console.log(rowNmb);
		    cellName = $('table').find("#name"+rowNmb).text();
	    	cellDescription = $('table').find("#description"+rowNmb).text();
		    if(btn == "edt"){
		    	
		    	
		    	
		    	console.log(cellName);
		    	$("#editCateg").show();
		    	
		    	$("#editName").val( cellName )
		    	$("#editDescription").val(cellDescription)
		    	
		    }else{
		    	console.log("--------"+cellName+ ""+ cellDescription );
		    	$.ajax({
					url: "rest/crudCategory/deleteCategory",
					type:"POST",
					data: JSON.stringify({
						name: cellName,
						description: cellDescription 
			        }),
					contentType:"application/json",
					dataType:"json",
					
					success: function (data) {
						
						location.reload();		
		            }
					
				});
		    	
		    	console.log("delete");
		    }
		
	});
	
	
	$('#editCateg').on('click', 'button', function(e) {
		var btn = e.target.id;
		
		if(btn == "edtBtn"){
			if($('#editName').val() != ""){
				 $.ajax({
						url: "rest/crudCategory/updateCategory",
						type:"POST",
						data: JSON.stringify({
							oldName : cellName,
							oldDescription : cellDescription,
							newName : $('#editName').val(),
							newDescription : $('#editDescription').val()
							
						}),
						contentType:"application/json",
						dataType:"json",
						
						success: function (data) {
							if(data != null){
								location.reload();
							}
			            }
				 });
				 
			}else {
				alert("Ime kategorije ne sme da bude prazno!")
			} 
		}else{
		
			
			
			location.reload();
		}
	
	});
	
	
	$("#create").click(function(){
		    $("#addCateg").show();
	});
	
	$("#add").click(function(){  
		if($('#name').val() != ""){
			 $.ajax({
					url: "rest/crudCategory/createCategory",
					type:"POST",
					data: JSON.stringify({
						name : $('#addName').val(),
						description : $('#addDescription').val()
						
					}),
					contentType:"application/json",
					dataType:"json",
					
					success: function (data) {
						if(data != null){
							location.reload();
						}else{
							alert("Postoji ta kategorija!")
						}
		            }
			 });
			 
			 $("#addCateg").hide();
		}else {
			alert("Morate uneti ime kategorije!")
		} 
		
	    
	 });
	
	

});