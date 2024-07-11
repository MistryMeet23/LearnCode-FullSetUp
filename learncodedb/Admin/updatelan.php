<?php
include('conn.php');

if (isset($_POST['submit'])) {

	$n = $_POST['name'];
	//$img = $_POST['pic'];

	$query = "INSERT INTO language(name,image) VALUES ('" . $n . "','" . $_FILES['pic']['name'] . "')";
	$data = mysqli_query($cn, $query) or die("Error In Insert query");
	if ($data) {
		echo "Data Insert";
	} else {
		echo " : Data Failed";
	}
}
?>
<?php
if (isset($_POST['submit'])) {
	if ($_FILES['pic']['size'] > 0) {
		//echo "File Name : ".$_FILES['image']['name']."<br>";
		//echo "File Size : ".$_FILES['image']['size']."<br>";
		//echo "File Temp Name : ".$_FILES['image']['tmp_name']."<br>";
		//echo "File Type : ".$_FILES['image']['type']."<br>";
		move_uploaded_file($_FILES['pic']['tmp_name'], "upload/" . $_FILES['pic']['name']);
	}
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Daily UI - Day 1 Sign In</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="./assets/css/style2.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="top">
			<h1 id="title" class="hidden"><span id="logo">Daily <span>UI</span></span></h1>
		</div>
		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>Log In</h2>
			</div>
			<form method="post" enctype="multipart/form-data" action="index.php">
			Language Name : <input type="text" name="name" required><br>
			Select Your File : <input type="file" name="pic" required><br>
			<input type="submit" name="submit" value="Update" required>
			</form>
		</div>
	</div>
</body>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

</html>