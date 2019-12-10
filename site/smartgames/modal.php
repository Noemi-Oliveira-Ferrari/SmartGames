
<?php 

/*CONECXAO*/
require_once('db/conexao.php');
$conexao = conexaoMysql();

   /* VERIFICANDO ID DO JOGO*/
   if(isset($_GET['id_jogo'])){
       
       
       $idJogo = $_GET['id_jogo'];
       
       /*SELECT PARA TRAZER TODAS AS INFORMAÇOES DO JOGO*/
       $sql = "
            select tbl_jogo.*, 
            tbl_loja.*, 
            tbl_genero.*, 
            tbl_console.*, 
            tbl_uf.*, 
            tbl_endereco.*, 
            tbl_loja.*
            from tbl_jogo
            inner join tbl_genero 
            on tbl_genero.id_genero = tbl_jogo.id_genero 
            inner join tbl_console 
            on tbl_console.id_console = tbl_jogo.id_console
            inner join tbl_loja
            on tbl_loja.id_loja = tbl_jogo.id_loja
            inner join tbl_endereco
            on tbl_loja.id_endereco = tbl_endereco.id_endereco
            inner join tbl_uf
            on tbl_uf.id_uf = tbl_endereco.id_uf
            where id_jogo = ".$idJogo;
       
       
            $select = mysqli_query($conexao, $sql);
                    
            $rsjogo = mysqli_fetch_array($select);
                        
                /*RESGATANDO OS VALORES DO ARRAY*/
                $tituloJogo = $rsjogo['titulo_jogo'];
                $tituloGenero = $rsjogo['titulo_genero'];
                $tituloConsole = $rsjogo['titulo_console'];
                $caminhoFoto = $rsjogo['foto_web'];
                $anoLancamento = $rsjogo['ano_lancamento'];
                $idadeJogo = $rsjogo['idade']; 
                $descricao = $rsjogo['descricao']; 
                $avaliacao = $rsjogo['avaliacao'];
                $localMapa = $rsjogo['local_mapa'];
                $nomeShopping = $rsjogo['titulo_loja_shopping'];
                $logradouro = $rsjogo['logradouro'];
                $bairro = $rsjogo['bairro'];
                $numero = $rsjogo['numero'];
                $uf = $rsjogo['uf'];
                $fotoWeb = $rsjogo['foto_web'];
                $preco = $rsjogo['preco'];
       
   }

?>

<script src="js/funcoes.js"></script>
<!-- CAIXA MODAL -->
<div class="caixa-modal">
    <div class="caixa-informacoes-jogo">
        <!-- IMAGEM JOGO -->
        <div class="caixa-informacoes-jogo-esquerda">
            <div class="caixa-imagem-modal center">
                <img class="caixa-imagem-modal" src="<?php echo($fotoWeb); ?>" alt="imagem-jogo">
                <div class="caixa-idade-modal <?php echo("cor".$idadeJogo);?>">
                   <?php 

                        if($idadeJogo == 0){
                            $idadeJogo = "L";
                        }

                        echo($idadeJogo);
                        
                    ?>
                </div>
            </div>
        </div>
        <!-- INFORMACOES SOBRE O JOGO -->
        <div class="caixa-informacoes-jogo-direita">
            <div class="caixa-titulo-modal">
                <?php echo(utf8_encode($tituloJogo));?> 
            </div>
            <div class="caixa-ano-genero">
                 <?php echo($anoLancamento . " - ". utf8_encode($tituloGenero));?> 
            </div>
            <div class="caixa-plataforma-nota">
                <?php echo(utf8_encode($tituloConsole));?> |  NOTA:<?php   echo($avaliacao);?> | R$ <?php   echo($preco);?>
            </div>
            <div class="caixa-descricao-modal">
                <p><?php echo(utf8_encode($descricao));?> </p>
            </div>
        </div>  
    </div>
    <hr>
    <!-- INFORMACOES SOBRE A LOJA -->
    <div class="caixa-informacoes-loja">
        <div class="caixa-mapa-modal">
            <iframe class="caixa-mapa-iframe" src="<?php echo($localMapa);?>"></iframe>
        </div>
        <div class="caixa-endereco-loja">
            <div class="disponibilidade-jogo">
                Jogo disponível em:
            </div>
             <div class="caixa-titulo-loja">
                <?php echo (utf8_encode($nomeShopping));?>
            </div>
            <div class="caixa-logradouro">
                <?php echo(utf8_encode($logradouro));?>
            </div>
            <div class="caixa-bairro-numero">
               <?php echo(utf8_encode($bairro) . ", " . $numero . " - " . $uf); ?>
            </div>
            <div class="fechar-modal" id="fechar">
                VER OUTROS JOGOS
            </div>
        </div>
       
        
    </div>
</div>