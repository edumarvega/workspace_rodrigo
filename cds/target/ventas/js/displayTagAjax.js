function changeLinksPagination(container,form){
	
	$('#'+container+' >.displayTable >.pagelinks > a').each(function(idx) {
		var link = $(this).attr('href');
		var pagination ='paginationAjax(\'' +link  +'\'' +',\'' +container +'\'' +',\''+form +'\');return false;';
		$(this).attr('onclick',pagination);
		$(this).attr('href','#');
	});
	
	$('#'+container+' >.displayTable > #data > thead > tr > .sortable > a').each(function(idx) {
		var link = $(this).attr('href');
		var pagination ='paginationAjax(\'' +link  +'\'' +',\'' +container +'\'' +',\''+form +'\');return false;';
		$(this).attr('onclick',pagination);
		$(this).attr('href','#');
	});

}

function paginationAjax(link,container,form){
	var uri = link.split("?");
	var action = uri[0];
	var pagination = uri[1];
	var paramsFilter = $('#'+form).serialize();
	$.ajax({
		url:   action,
		data:  pagination+'&'+paramsFilter,
		cache: false,
		type:  'get',
		beforeSend: function () {
			$('#'+container+'>.displayTable').block({ message: '<h5><img src="/ventas/images/loading.gif"/> Procesando...</h5>' });
		},
		success:  function (response) {
			$('#'+container).html(response);
			changeLinksPagination(container,form);
			$('#'+container+'>.displayTable').unblock();
			
		}
    });
}
