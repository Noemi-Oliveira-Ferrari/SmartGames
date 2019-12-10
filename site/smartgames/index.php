<?php 
require_once('db/conexao.php');
$conexao = conexaoMySql();



    /*DECLARACAO DE VARIAVEIS*/
    $foto = null;
    $tituloJogo = null;
    $tituloGenero = null;
    $caminhoFoto = null;
    $anoLancamento = null;
    $where = null;
    $idJogo = null;
    $idadeJogo = null;


?>
<!DOCTYPE HTML>
<html lang="pt-br">
    <head>
        <title>
            SMART GAMES
        </title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="js/jquery.js" ></script>
        <script src="js/funcoes.js"></script>
    </head>
    <body>
        <!-- MODAL -->
        <div id="container">
			<div id="modal">
				
			</div>         
		</div>
        <div id="slide" class="center">
             <?php
            
                    /*SLIDE*/
                    require_once('with-jquery.php');
            ?>
            
            <div class="caixa-titulo-smart-games center">
                <div class="titulo-smart-games center">
                    <div class="texto-bem-vindo">
                        Bem vindo à
                    </div>
                    <div class="smart-games">
                        SMART GAMES
                    </div>
                    <div class="descricao-smart-games">
                        Aqui você pode encontrar seus jogos preferidos, <br>além de ficar por dentro de todas as novidades e lançamentos de jogos.
                    </div>
                </div>
            </div>
                
        </div>
        <!-- PLATAFORMAS -->
        <div class="conteudo-site">
            <div class="caixa-consoles center">
                <div class="caixa-consoles-imagens">
                    <img src="img/logoxbox.png" alt="xbox" class="imagens-console">
                </div>
                <div class="caixa-consoles-imagens">
                    <img src="img/logonintendo.png" alt="nintendo" class="imagens-console">
                </div>
                <div class="caixa-consoles-imagens">
                    <img src="img/logosony.png" alt="sony" class="imagens-console">
                </div>
            </div>
        </div>
        <div class="caixa-descricao-smart">
            
        </div>
        <!-- SOBRE A LOJA -->
        <div class="caixa-descricao-smart-center center">
            <div class="caixa-descricao-imagens-abs center">
                <!-- JOGOS -->
                <div class="icons-detalhes-loja">
                    <div class="imagem-descricao-icon">
                        <img src="img/jogos.png" alt="jogos">
                    </div>
                    <div class="descricao-texto">
                        <span class="titulo-descricao">JOGOS</span>
                        <br>
                        <p class="espaco-texto">
                            Encontre os melhores jogos para você e divirta-se
                        </p>
                    </div>
                </div>
                <!-- CONSOLES -->
                <div class="icons-detalhes-loja">
                    <div class="imagem-descricao-icon">
                        <img src="img/consoles.png" alt="consoles">
                    </div>
                    <div class="descricao-texto">
                     <span class="titulo-descricao">CONSOLES</span>
                        <br>
                        <p class="espaco-texto">
                            Jogos para todos os tipos de plataformas, encontre já o seu 
                        </p>
                    </div>
                </div>
                <!-- ENTRETENIMENTO -->
                <div class="icons-detalhes-loja">
                    <div class="imagem-descricao-icon">
                        <img src="img/diversao.png" alt="diversao">
                    </div>
                    <div class="descricao-texto">
                     <span class="titulo-descricao">DIVERSÃO</span>
                        <br>
                        <p class="espaco-texto">
                            Aqui na SmartGames seu entretenimento está garantido
                        </p>
                    </div>
                </div>
                <!-- LOJAS -->
                <div class="icons-detalhes-loja">
                    <div class="imagem-descricao-icon">
                        <img src="img/lojas.png" alt="lojas">
                    </div>
                    <div class="descricao-texto">
                     <span class="titulo-descricao">LOJAS</span>
                        <br>
                        <p class="espaco-texto">
                            Conheça nossas unidades e adquira nossos produtos
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <!-- AREA DE PESQUISA -->
        <div class="caixa-jogos">
            <div class="caixa-busca center">
                <form name="frmPesquisa" action="index.php" method="post">
            
                    <div class="caixa-input">
                        <input type="text" name="jogoBusca" class="txt-pesquisa" placeholder="Digite o que você está procurando">
                    </div>
                    <div class="caixa-icon-pesquisa">
                        <img src="img/pesquisar.png" alt="pesquisar">
                    </div>
                    <div class="caixa-botao-pesquisar">
                        <input type="submit" class="btn-pesquisar" value="PESQUISAR" name="btnOk">
                    </div>
                </form>
            </div>
             <hr>
        </div>
        <!-- LOOPING PARA TRAZER TODOS OS JOGOS -->
        <div class="caixa-lista-jogos center">
            <?php 
                    
            
                    /*MODO PARA BUSCAR OS JOGOS PELO NOME*/
                    if(isset($_POST['btnOk'])){
                        $jogoBusca = $_POST['jogoBusca'];
                        $where = "tbl_jogo.titulo_jogo like '%".$jogoBusca."%'"; 
                    }else{
                        $where = "tbl_jogo.id_jogo >= 1";
                    }
                        
                    /*SELECT QUE TRAZ OS JOGOS*/
                     $sql = " select tbl_jogo.*, tbl_genero.titulo_genero, tbl_console.titulo_console 
                                from tbl_jogo
                                inner join tbl_genero on tbl_genero.id_genero = tbl_jogo.id_genero 
                                inner join tbl_console on tbl_console.id_console = tbl_jogo.id_console where ".$where." order by rand();";
                    
                    $select = mysqli_query($conexao, $sql);
                    
                    /*LOOPING*/
                    while($rsjogo = mysqli_fetch_array($select)){
                        
                        /*RESGATANDO OS VALORES DO ARRAY*/
                        $tituloJogo = $rsjogo['titulo_jogo'];
                        $tituloGenero = $rsjogo['titulo_genero'];
                        $tituloConsole = $rsjogo['titulo_console'];
                        $caminhoFoto = $rsjogo['foto_web'];
                        $anoLancamento = $rsjogo['ano_lancamento'];
                        $idadeJogo = $rsjogo['idade'];
                        $idJogo = $rsjogo['id_jogo'];
                        $preco = $rsjogo['preco'];
                    
                ?>
            <!-- SETANDO OS VALORES -->
            <div class="card-jogo">
                <div class="imagem-jogo center">
                    <img src="<?php echo($caminhoFoto);?>" class="form-jogo" alt="imagem-jogos">
                </div>
                <div class="titulo-jogo">
                    <?php echo($tituloJogo);?> 
                </div>
                <div class="ano-classificacao center">
                    <div class="ano-jogo">
                        <?php echo($anoLancamento . " - " . $tituloGenero . " | " . "R$ " . $preco);?> 
                    </div>
                    <div class="classificacao-jogo <?php echo("cor".$idadeJogo)?>">
                         <?php 
                            /*VERIFICACÃO DA IDADE - CLASSIFICAÇÃO LIVRE*/
                            if($idadeJogo == 0){
                                $idadeJogo = "L";
                            }
                    
                            echo($idadeJogo);
                        
                        ?>
                    </div>
                </div>
                <div class="caixa-btn-detalhes center">
                    <input type="submit" class="btn-detalhes center visualizar" onclick="verMais(<?php echo($rsjogo['id_jogo']); ?>)" value="DETALHES">
                </div>
            </div>
           <?php } ?>
       
        </div>
        <!-- RODAPE -->
        <div class="caixa-rodape">
            <div class="caixa-rodape-center center">
                <div class="smart-games-rodape">
                    SMART <br> GAMES
                </div>
                <!-- DESCRICAO -->
                <div class="descricao-rodape">
                    <span class="destaque-rodape">Aqui você encontra:</span><br>
                    Consoles<br>
                    Jogos<br>
                    Plataformas<br>
                    Lojas<br>
                    Desenvolvedores<br>
                
                </div>
                <!-- REDES SOCIAIS -->
                <div class="redes-sociais-rodape">
                    <div class="redes-sociais">
                        <img src="img/facebook.png" alt="faceboook">
                    </div>
                    <div class="redes-sociais">
                         <img src="img/instagram.png" alt="instagram">
                    </div>
                    <div class="redes-sociais">
                         <img src="img/twitter.png" alt="twitter">
                    </div>
                    <div class="redes-sociais">
                         <img src="img/email.png" alt="email">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>