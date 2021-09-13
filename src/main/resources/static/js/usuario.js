$(function() {
	
	$("body").on("click", "[data-function='usuarios-mostarFormularioCreacion']", function(){mostarModalCreacionUsuario()})
	$("body").on("submit", "[data-function='usuarios-crearUsuario']", function(e){crearUsuario(e)})
});

function mostarModalCreacionUsuario() {
	$("#modalCreacionUsuario").modal("show")
}

function crearUsuario(e) {
	e.preventDefault();
	e.stopPropagation();

	var data = {};

	var form = e.currentTarget;
	data["username"] = form.elements["username"].value;
	data["name"] = form.elements["name"].value;
	data["lastname"] = form.elements["lastname"].value;
	data["password"] = form.elements["password"].value;

	var request = $.ajax({
		url: "/usuario",
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(data),
		dataType: 'html',
		cache: false
	});
	
	request.done(function( response, textStatus, jqXHR ) {
		var obj = JSON.parse(response);
		
		if (obj.status == "OK") {
			alert("Usuario creado");
			location.reload();
		}
	});
	
	request.fail(function( jqXHR, textStatus, errorThrown ) {
		alert( "Request failed: " + textStatus );
	});
}
