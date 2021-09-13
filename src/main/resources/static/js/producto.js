$(function() {
	
	$("body").on("click", "[data-function='carroCompras-agregarProducto']", function(){carroCompras_agregarProducto(this)});
	$("body").on("click", "[data-function='carroCompras-eliminarProducto']", function(){carroCompras_eliminarProducto(this)});
	
});

function carroCompras_agregarProducto (obj) {
	
	var data = {};
	
	data["productid"] = $(obj).data("id"); 
	data["cantidad"] = $(obj).data("cantidad");
	
	var request = $.ajax({
		url: "/agregarProducto",
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(data),
		dataType: 'html',
		cache: false
	});
	
	request.done(function( response, textStatus, jqXHR ) {
		var obj = JSON.parse(response);
		
		if (obj.status == "OK") {
			alert("Producto guardado");
		}
	});
	
	request.fail(function( jqXHR, textStatus, errorThrown ) {
		alert( "Request failed: " + textStatus );
	});
	
	request.always(function () {
		
	});
	
}

function carroCompras_eliminarProducto (obj) {
	
	var id = $(obj).data("id");
	
	var request = $.ajax({
		url: "/eliminarProducto",
		contentType: "application/json",
		method: "POST",
		data: {
			id: id
		},
		dataType: 'html',
		cache: false
	});
	
	request.done(function( response, textStatus, jqXHR ) {
		var obj = JSON.parse(response);
		
		if (obj.status == "OK") {
			alert("Producto eliminado");
		}
	});
	
	request.fail(function( jqXHR, textStatus, errorThrown ) {
		alert( "Request failed: " + textStatus );
	});
	
	request.always(function () {
		
	});
	
}