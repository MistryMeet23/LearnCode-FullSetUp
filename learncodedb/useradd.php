<?php
include('conn.php');

if (isset($_POST['submit'])) {

    $name = $_POST['name'];
    $email = $_POST['email'];
    $num = $_POST['number'];
    $query = "INSERT INTO users(name,email,number) VALUES ('" . $name . "', '" . $email . "', '" . $num . "')";
    $data = mysqli_query($cn, $query) or die("Error In Insert query");
    if ($data) {
        echo "Data Insert";
        header("Location:index.php");
        exit();
    } else {
        echo " : Data Failed";
    }
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Add User To LearnCode</title>
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900'
        rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/animate.css">
    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="./assets/css/style2.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
    <div class="container">
        <div class="top">
            <h1 id="title" class="hidden"><span id="logo">Learn <span>Code</span></span></h1>
        </div>
        <div class="login-box animated fadeInUp">
            <div class="box-header">
                <h2>Add user</h2>
            </div>
            <form method="post" enctype="multipart/form-data" >
                Enter Your Name : <input type="text" name="name" required><br>
                Enter Your email : <input type="email" name="email" required><br>
                Enter Your Number : <input type="number" name="number" required><br>
                <input type="submit" name="submit" value="Add User" required>
            </form>
        </div>
    </div>
</body>

</html>