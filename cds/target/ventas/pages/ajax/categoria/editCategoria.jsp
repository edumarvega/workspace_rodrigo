<%@ include file="/pages/template/taglibs.jsp" %>
  <script type="text/javascript">
  $(document).ready(function(){
  	  	
  		var options = { 
  		  		target : '#resultado',
			    success:    function(){ 
  					changeLinksPagination('resultado','filterForm');
			    	divEditarCategoria.dialog('destroy').remove();
			    } 
		};
  		$('#formEdicionCategoria').submit(function() {
  	        $(this).ajaxSubmit(options);
  	        return false;
  	    });
  		
 	});
   </script>
	<s:form id="formEdicionCategoria"  action="abmCategoria_update" theme="simple"  cssClass="form-horizontal" role="form">
		<s:hidden id="idCategoria" name="categoria.id" value="%{categoria.id}"/>
		  			
  		<div class="form-group">
    		<label for="nombre" class="col-md-4 col-lg-4 control-label">Nombre</label>
    		<div class="col-md-5 col-lg-5">
      			<input type="text" class="form-control input-sm" id="nombre" name="categoria.nombre" value="${categoria.nombre}" autofocus required>
    		</div>
  		</div>
  		  				
  		<div class="form-group">
  			<label for="button" class="col-md-4 col-lg-4 control-label"></label>
    		<div class="col-md-4 col-lg-4">
      			<button type="submit" class="btn btn-info">Aceptar</button>
    		</div>
    	</div>	
    </s:form>
    	
