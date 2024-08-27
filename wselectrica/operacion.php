<?php
//bind variables
function guardarCliente($arrayParametros)
{
    $arrayResponse = array();
    require 'database.php';

    $strSql = "INSERT INTO tbl_cliente (
                                            nombre_usuario,
                                            correo,
                                            contrasena)
                VALUES (?, ?, ?)";
    $stmt   = $db->prepare($strSql);
    $stmt->bind_param('sss', $nombre_usuario,
                                $correo,
                                $contrasena);
    
    $nombre_usuario      = $arrayParametros['nombre_usuario'];
    $correo     = $arrayParametros['correo'];
    $contrasena= $arrayParametros['contrasena'];

    $boolGuarda = $stmt->execute();

    if($boolGuarda){
        $arrayResponse = array("mensaje"    => "Se guardo correctamente",
                               "status"     => "OK",
                               "code"       => 200);
    } else {
        $arrayResponse = array("mensaje"    => "No se guardo!!!",
                               "status"     => "ERROR",
                               "code"       => 500);
    }
    return $arrayResponse;

#Registro de usuario
    <?php
include 'db_connect.php';

$username = $_POST['username'];
$email = $_POST['email'];
$password = password_hash($_POST['password'], PASSWORD_BCRYPT);

$sql = "INSERT INTO users (username, email, password) VALUES ('$username', '$email', '$password')";

if ($conn->query($sql) === TRUE) {
    echo json_encode(["status" => "success", "message" => "Usuario registrado exitosamente"]);
} else {
    echo json_encode(["status" => "error", "message" => "Error: " . $sql . "<br>" . $conn->error]);
}

$conn->close();
?>

}

#Inicio de sesion
<?php
include 'db_connect.php';

$email = $_POST['email'];
$password = $_POST['password'];

$sql = "SELECT * FROM users WHERE email = '$email'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    if (password_verify($password, $row['password'])) {
        echo json_encode(["status" => "success", "message" => "Inicio de sesión exitoso", "user_id" => $row['id']]);
    } else {
        echo json_encode(["status" => "error", "message" => "Contraseña incorrecta"]);
    }
} else {
    echo json_encode(["status" => "error", "message" => "Correo no registrado"]);
}

$conn->close();
?>

#Regitro de consumo
<?php
include 'db_connect.php';

$user_id = $_POST['user_id'];
$month = $_POST['month'];
$value = $_POST['value'];

$sql = "INSERT INTO consumption (user_id, month, value) VALUES ('$user_id', '$month', '$value')";

if ($conn->query($sql) === TRUE) {
    echo json_encode(["status" => "success", "message" => "Consumo registrado exitosamente"]);
} else {
    echo json_encode(["status" => "error", "message" => "Error: " . $sql . "<br>" . $conn->error]);
}

$conn->close();
?>

#Listar Consumo
<?php
include 'db_connect.php';

$user_id = $_GET['user_id'];

$sql = "SELECT * FROM consumption WHERE user_id = '$user_id'";
$result = $conn->query($sql);

$consumptions = array();
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        $consumptions[] = $row;
    }
    echo json_encode($consumptions);
} else {
    echo json_encode([]);
}

$conn->close();
?>

#Actualizar consumo
<?php
include 'db_connect.php';

$consumption_id = $_POST['consumption_id'];
$status = "Pagado";

$sql = "UPDATE consumption SET status='$status' WHERE id='$consumption_id'";

if ($conn->query($sql) === TRUE) {
    echo json_encode(["status" => "success", "message" => "Consumo pagado exitosamente"]);
} else {
    echo json_encode(["status" => "error", "message" => "Error: " . $sql . "<br>" . $conn->error]);
}

$conn->close();
?>
