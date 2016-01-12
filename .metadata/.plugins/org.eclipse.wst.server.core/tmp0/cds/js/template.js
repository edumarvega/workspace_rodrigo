function showMsgWarning(txt){
	$("#msgWarning").text(txt);
	$("#dialogWarning").dialog();
}

function showMsgError(txt){
	$("#msgError").text(txt);
	$("#dialogError").dialog();
}

function showMsgSuccess(txt){
	$("#msgSuccess").text(txt);
	$("#dialogSuccess").dialog();
}

function showMsgInfo(txt,url,params,container){
	$("#msgInfo").text(txt);
	$("#dialogInfo").dialog({
			buttons: {
				'Aceptar': function() {
						$.ajax({
							url:   url,
							data:  params,
							cache: false,
							type:  'post',
							beforeSend: function () {
								$("#displayTable").block({ message: '<h5><img src="/ventas/images/loading.gif"/> Procesando...</h5>' });
							},
							success:  function (response) {
								$('#'+container).html(response);
								changeLinksPagination(container);
								parent.$("#dialogInfo").dialog("close");
							}
						});
				},
				'Cancelar': function() {
					parent.$("#dialogInfo").dialog("close");
				}
			}
	});
}


function validaSoloNumeros(){
	if ((event.keyCode < 48) || (event.keyCode > 57)) 
		event.returnValue = false;
}

function validaSoloNumerosConPunto(){
	
	if ((event.keyCode >=48  && event.keyCode <=57) || (event.keyCode == 46)){
		event.returnValue = true;
	} 
	else{
		event.returnValue = false;
	}
		
}



