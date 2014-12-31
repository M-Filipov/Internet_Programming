$(function() {

	//task 2
	console.log($('.tu').parent().children(':first-child').attr('title'));

	//task 3
	console.log($('#col1').children('p').text());

	//task 4
	var liItem = '<li id="menu-item-button"> <a href="#">New Button</a></li>';
	$('#menu-top-level-menu').append(liItem);

	//task 5
	var divItem = '<div id="dynamiccontent" />';
	$('#footer').append(divItem);

	//task 6
	var inputItem = '<input type="text" id="textinput"/>';
	$('#dynamiccontent').append(inputItem);

	//task 7
	var buttonItem = '<button id="addbutton">addbutton</button>';
	$('#dynamiccontent').append(buttonItem);

	//task 8
	var ulItem = '<ul id="posts" />';
	$('#dynamiccontent').append(ulItem);

	//task 9
	/*
	$( "#menu-item-button" ).click(function() {
	alert( "hello world" );
	});
	*/

	//task 10
	$( "#menu-item-button" ).click(function() {
		$('#col1').before($('#col2'));
	});


	
	var jsonPH = 'http://jsonplaceholder.typicode.com/posts'

	//task 11
	$.get(jsonPH, function(result) {
		for (var i = 0; i < 5; i++) {
			$("#posts").append('<li>' + result[i].title + '</li>');
		};
	});

	//task 12
	// $('#addbutton').click(function() {
	// 	if (!$('#textinput').val()) {
	// 		alert("you must enter text");
	// 	}
	// });

	//task 13
	// $('#addbutton').click(function() {
	// 	var val = $('#textinput').val()
	// 	var postArgs = { "userId": 1,
	// 					 "id": 1,
	// 					 "title": val,
	// 					 "body": "uia et suscipit\nsuscipit recusandae consequuntur",
	// 					}

	// 	if (!val) {
	// 		alert("you must enter text");
	// 	}
	// 	else {
	// 		$.post(jsonPH, postArgs);
	// 	}
	// });

	//task 14
	// $('#addbutton').click(function() {
	// 	var val = $('#textinput').val()
	// 	var postArgs = { "userId": 1,
	// 					 "id": 1,
	// 					 "title": val,
	// 					 "body": "uia et suscipit\nsuscipit recusandae consequuntur",
	// 					}

	// 	if (!val) {
	// 		alert("you must enter text");
	// 	}
	// 	else {
	// 		$.post(jsonPH, postArgs	,function(data){
 //      				$.get(jsonPH + '/' + data.id, function(result) {
 //      					$("#posts").append('<li>' + result.title + '</li>');
 //      					})
 //    			 });
	// 	}
	// });

	//task 15
// $('#addbutton').click(function() {
// 	var val = $('#textinput').val()
// 	var postArgs = { "userId": 1,
// 					 "id": 1,
// 					 "title": val,
// 					 "body": "uia et suscipit\nsuscipit recusandae consequuntur",
// 					}

// 	if (!val) {
// 		alert("you must enter text");
// 	}
// 	else {
// 		$.post(jsonPH, postArgs	,function(data){
// 			$.get(jsonPH + '/' + data.id, function(result) {
// 				var button = $('<button/>',
// 				{
// 					text: 'X',
// 					click: function () { alert('deleting'); }
// 				});
// 				var $post = $('<li>' + result.title + '</li>');
// 				$post.append(button);
// 				$('#posts').append($post);

// 			})
// 		});
// 	}
// });

	//task 16
	$('#addbutton').click(function() {
		var val = $('#textinput').val()
		var postArgs = { "userId": 1,
						 "title": val,
						 "body": "uia et suscipit\nsuscipit recusandae consequuntur",
						}

		if (!val) {
			alert("you must enter text");
		}
		else {
			$.post(jsonPH, postArgs	,function(data){
				$.get(jsonPH + '/' + data.id, function(result) {
					var button = $('<button/>',
					{
						text: 'X',
						click: function () { 
	 								if (confirm("Do you really want to delete post " + data.id)) {
	 									$.ajax({
										    url: jsonPH + '/' + data.id,
										    type: 'DELETE',
										    success: function(result) {
									        	button.parent().remove();
									    	}
										});

	 								};
								}
					});
					var $post = $('<li>' + result.title + '</li>');
					$post.append(button);
					$('#posts').append($post);

				})
			});
		}
	});

	//task 17
	inputItem = '<input type="text" id="textinput2"/>';
	$('#posts').before(inputItem);

	//task 18
	// $('#textinput2').change(function() {
	// 	$.get(jsonPH + '?userId=' + $('#textinput2').val(), function(result){
	// 		$.each(result, function(index) {
	// 			$("#posts").append('<li>' + result[index].title + '</li>');
	// 		})
	// 	})	
	// });

	//task 19
	// $('#textinput2').change(function() {
	// 	$.get(jsonPH + '?userId=' + $('#textinput2').val(), function(result){
	// 		$('#posts').empty();
	// 		$.each(result, function(index) {
	// 			$("#posts").append('<li>' + result[index].title + '</li>');
	// 		})
	// 	})	
	// });

	//task 20
	$('#textinput2').change(function() {
		$.get(jsonPH + '?userId=' + $('#textinput2').val(), function(result){
			$('#posts').empty();
			$.each(result, function(index) {
				//$("#posts").append('<li>' + result[index].title + '</li>');
				var button = $('<button/>',
					{
						text: 'X',
						click: function () { 
	 								if (confirm("Do you really want to delete post " + result[index].id)) {
	 									$.ajax({
										    url: jsonPH + '/' + result[index].id,
										    type: 'DELETE',
										    success: function(result) {
									        	button.parent().remove();
									    	}
										});

	 								};
								}
					});
					var $post = $('<li>' + result[index].title + '</li>');
					$post.append(button);
					$('#posts').append($post);
			})
		})	
	});

});