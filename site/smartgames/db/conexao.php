<?php 

function ConexaoMySql(){
    $conexao = null;
    $server = "localhost";
    $user = "root";
    $password = "bcd127";
    $database = "db_smart_games";
    
    $conexao = mysqli_connect($server, $user, $password, $database);
    return $conexao;

}


?>