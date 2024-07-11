<?php 
	require 'conn.php';

	$name = $_POST['name'];
	$email = $_POST['email'];
	$number = $_POST['number'];

	$checkuser = "SELECT * FROM users WHERE email='$email'";
	$checkdata = mysqli_query($cn,$checkuser);

	if (mysqli_num_rows($checkdata)>0) {
		$response['error']="002";
		$response['message']="User Exist";
	}else{

		$sql = "INSERT INTO users(name,email,number) VALUES('$name','$email','$number');";
		$result = mysqli_query($cn,$sql);

		if($result){
			$response['error']="000";
			$response['message']="Register Successful!";
		}else{
			$response['error']="001";
			$response['message']="Registeration Failed";
		}
	}
	echo json_encode($response, JSON_PRETTY_PRINT);
?>