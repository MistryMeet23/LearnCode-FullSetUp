<?php
	require 'conn.php';

	if (isset($_POST['submit'])) {

		$name = $_POST['name'];
		$email = $_POST['email'];
		$number = $_POST['number'];

		$sql = "SELECT * FROM users where email = '$email'";
		$result = mysqli_query($cn,$sql);

		if (mysqli_num_rows($result)>0) {

			$status = "Already Exist";
			$result_code=0;
			echo json_encode(array('status'=>$status,'result_code'=>$result_code));

		}else{
			$sql = "INSERT INTO users(name,email,number) VALUES('$name','$email','$number');";
			if (mysqli_query($cn,$sql)) {
				$status = "Done";
				$result_code = 1;
				echo json_encode(array('status'=>$status,'result_code'=>$result_code));
			}else{
				$status = "Fail";
				echo json_encode(array('status'=>$status),JSON_FORCE_OBJECT);
			}
		}
		header("Location:login.php");
		exit();
	}
	mysqli_close($cn);
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Registertion Page</title>
</head>
<body style="background-color: lightblue;">
	<center>
		<h1>
			Registration Page
		</h1>
		<h2>Make your account and join with us!</h2>
		<h3>
			<form method="post" >
				Enter Your Name : <input type="text" name="name" required><br>
				Enter Your Email : <input type="email" name="email" required><br>
				Enter Your Number : <input type="number" name="number" required><br>
				<input type="submit" name="submit">
			</form>
		</h3>
	</center>
</body>
</html>