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
})