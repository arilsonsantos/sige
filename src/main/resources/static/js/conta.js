$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {

	var button = $(event.relatedTarget);

	var idConta = button.data('id');

	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base')
	if (!action.endsWith('/')) {
		action += '/';
	}

	form.attr('action', action + idConta);

});

$(function(){
	$('[rel="tooltip"]').tooltip();
	$('.js-money').maskMoney({thousands:'.', decimal:',', allowZero:true, prefix: 'R$ '});
	
	$('.js-atualizar-status').on('click', function(event){
		event.preventDefault();
		
		var btnAtivar = $(event.currentTarget);
		var urlAtivar = btnAtivar.attr('href');
		
		var response = $.ajax({
			url: urlAtivar,
			type: 'PUT'
		});
		
		response.done(function(e){
			var idConta = btnAtivar.data('id');
			$('[data-role=' + idConta + ']').html('<span class="label label-success">' + e + '</span>');
			btnAtivar.hide();
			
		});
		
		response.fail(function(e){
			console.log(e);
			alert('Erro ao atualizar status');
		});
		
	});
})