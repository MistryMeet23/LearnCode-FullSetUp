<?php
	require 'conn.php';

	$email = $_POST['email'];

	$sql = "SELECT * FROM users where email = '$email'";
	$result = mysqli_query($cn,$sql);

	if(mysqli_num_rows($result)>0){
		$checkuser="SELECT id, name, email FROM users WHERE email='$email'";
		$r=mysqli_query($cn,$checkuser);

		if (mysqli_num_rows($r)>0) {
			while($row=$result->fetch_assoc())
			$response['user']=$row;
			$response['error']="200";
			$response['message']="Login Successful";
		}else{
			$response['user']=(object)[];
      		$response['error']="400";
      		$response['message']="Wrong credentials";
		}
	}else{
		$response['user']=(object)[];
		$response['error']="400";
		$response['message']="user does not exist";
		}
	echo json_encode($response, JSON_PRETTY_PRINT);
?>