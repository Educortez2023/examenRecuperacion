<?php
require "operacion.php";
$objRequest     = file_get_contents('php://input');
$arrayRequest   = json_decode($objRequest, true);

$arrayResponse = array();
switch($arrayRequest['op']) {
    case 'guardarCliente':
        $arrayResponse = guardarCliente($arrayRequest['data']);
        break;
    default:
    $arrayResponse = array("mensaje"    => "OP no existe",
                           "status"     => "ERROR",
                           "code"       => 500);
}
echo json_encode($arrayResponse, JSON_UNESCAPED_UNICODE);
