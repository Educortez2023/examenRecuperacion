<?php

$db = mysqli_connect('localhost', 'root', '', 'empresa_electrica');

if(!$db){
    echo 'Error al conectar con la base de datos';
    echo "errno de depuración: " . mysqli_connect_errno();
    echo "error de depuración: " . mysqli_connect_error();
    exit;
}