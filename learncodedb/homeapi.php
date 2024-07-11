<?php
    include_once "conn.php";
    ?>
<?php
	//$con = mysqli_connect("localhost","root","","learncodedb");
	$response = array();
	if($cn){
		$sql = "SELECT * FROM homedata where lan_id = ".$_REQUEST['lid'];
		$result = mysqli_query($cn,$sql);
		if($result){
			header("Content-Type: JSON");
			$i = 0;
			while ($row = mysqli_fetch_assoc($result)){

				$response[$i]['id']=$row['id'];
				$response[$i]['lan_id'] = $row['lan_id'];
				$response[$i]['title'] = $row['title'];
				$response[$i]['link'] = $row['link'];
				$i++;
			}
			echo json_encode($response, JSON_PRETTY_PRINT);
		}
	}
	else  {
		echo "Data Base Failed";
	}
?>