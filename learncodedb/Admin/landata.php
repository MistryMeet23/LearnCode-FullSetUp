<?php
include('conn.php');
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Add Language Data To LearnCode</title>
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
                <h2>Add Language Data</h2>
            </div>
            <form method="post" enctype="multipart/form-data">

                <label>Choose a Language:</label>
                <select name="language" id="language">
                    <option selected="" value="0">Select Language</option>
                    <?php
                    $sql = "SELECT * from language";
                    $result = $cn->query($sql);
                    $count = 1;
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            ?>
                            <option value="<?= $row["id"] ?>"><?= $row["name"] ?></option>
                            <?php
                            $count = $count + 1;
                        }
                    }
                    ?>
                </select><br><br>
                Enter Title : <input type="text" name="title" required><br>
                Enter Link : <input type="text" name="link" required><br>
                <input type="submit" name="submit" value="Add Language Data" required>
            </form>
        </div>
    </div>
</body>

</html>
<?php

if (isset($_POST['submit'])) {

    $lan = $_POST["language"];
    $title = $_POST['title'];
    $link = $_POST['link'];

    $query = "INSERT INTO homedata(lan_id,title,link) VALUES ('" . $lan . "','" . $title . "','" . $link . "');";
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