/*EFEITO PARA ABRIR MODAL*/
$(document).ready(function(){
    $('.visualizar').click(function(){
        $('#container').fadeIn(1000);
    });

});

/*FUNÇÃO PARA FECHAR A MODAL*/
$(document).ready(function(){
    $('#fechar').click(function(){
        $('#container').fadeOut(0);
    });
});


/*FUNÇÃO QUE PARA ABRIR MODAL */
function verMais(idItem){
    $.ajax({
        type: "GET",
        url: "modal.php",
        data: {id_jogo:idItem},
        success: function(dados){
            $('#modal').html(dados);

        }
    });
}
