<?php
    require 'conn.php';

    // Assuming you have a database connection object, $cn

    $name = $_POST['name'];
    $email = $_POST['email'];
    $number = $_POST['number'];

    // Use prepared statement to check for existing user
    $checkuser = "SELECT * FROM users WHERE email=?";
    $stmt = mysqli_prepare($cn, $checkuser);
    mysqli_stmt_bind_param($stmt, "s", $email);
    mysqli_stmt_execute($stmt);
    mysqli_stmt_store_result($stmt);

    if (mysqli_stmt_num_rows($stmt) > 0) {
        $response['error'] = "002";
        $response['message'] = "User Exist";
    } else {
        // Use prepared statement for insertion
        $sql = "INSERT INTO users(name, email, number) VALUES(?, ?, ?)";
        $stmt = mysqli_prepare($cn, $sql);
        mysqli_stmt_bind_param($stmt, "sss", $name, $email, $number);
        $result = mysqli_stmt_execute($stmt);

        if ($result) {
            $response['error'] = "000";
            $response['message'] = "Registration Successful!";
        } else {
            $response['error'] = "001";
            $response['message'] = "Registration Failed";
        }
    }

    echo json_encode($response, JSON_PRETTY_PRINT);

    // Close the statement and connection
    mysqli_stmt_close($stmt);
    mysqli_close($cn);
?>
