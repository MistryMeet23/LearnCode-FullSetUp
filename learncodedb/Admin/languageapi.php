<?php
include ('conn.php');
	$response = array();
	if($cn){
		$sql = "SELECT * FROM language";
		$result = mysqli_query($cn,$sql);
		if($result){
			header("Content-Type: JSON");
			$i = 0;
			while ($row = mysqli_fetch_assoc($result)){
				$response[$i]['id']=$row['id'];
				$response[$i]['name'] = $row['name'];
				$response[$i]['image'] = $row['image'];
				$i++;
			}
			echo json_encode($response, JSON_PRETTY_PRINT);
		}
	}
	else  {
		echo "Data Base Failed";
	}
?>