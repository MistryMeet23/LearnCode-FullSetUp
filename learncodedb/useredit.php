<!DOCTYPE html>
<html>

<head>
    <title>Insert Data</title>
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900'
        rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="css/animate.css">
    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="./assets/css/style2.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
    <?php
    include('conn.php');

    if (isset($_POST['edit'])) {

        $result = mysqli_query($cn, "UPDATE users SET name='" . $_POST['name'] . "',email='" . $_POST['email'] . "',number='" . $_POST['number'] . "' WHERE id=" . $_REQUEST['id']) or die("Error to update");
        header("Location:index.php");
        exit();
    }
    $result = mysqli_query($cn, "SELECT * FROM users WHERE id=" . $_REQUEST['id']) or die("Error to select");
    $r = mysqli_fetch_array($result);
    ?>
    <div class="container">
        <div class="top">
            <h1 id="title" class="hidden"><span id="logo">Learn <span>Code</span></span></h1>
        </div>
        <div class="login-box animated fadeInUp">
            <div class="box-header">
                <h2>Edit Page</h2>
            </div>
            <form method="post" enctype="multipart/form-data">
                User Name : <input type="text" name="name" value="<?php echo $r['name']; ?> " required><br>
                User email : <input type="email" name="email" value="<?php echo $r['email']; ?> " required><br>
                User Number : <input type="text" name="number" value="<?php echo $r['number']; ?> " required><br>
                <input type="submit" name="edit" value="Update" required>
            </form>
        </div>
    </div>
</body>

</html>