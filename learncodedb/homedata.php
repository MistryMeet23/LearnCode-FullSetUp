<?php
	include ('conn.php');
	if (isset($_POST['submit'])) {

		$li = $_POST['lan_id'];
		$t = $_POST['title'];
		$l = $_POST['link'];

		$query = "INSERT INTO homedata(lan_id,title,link) VALUES (".$li.",'".$t."','".$l."')";
		$data = mysqli_query($cn,$query)or die("Error In Insert query");
		if ($data) {
			echo "Data Insert";
		}else{
			echo " : Data Failed";
		}
	}	
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Data</title>
</head>
<body>
	<?php
		$con = mysqli_connect("localhost","root","","sub_data") or die("Error to connect");
		if($con){
			$sql = "SELECT * FROM language";
			$result = mysqli_query($con,$sql);
		}
	?>
	<form method="post">
		<label >Language List</label><br>
		<select name="lan_id" required>
			<option>--Select--</option>
			<?php
				while ($r=mysqli_fetch_array($result)) {?>
					<option value="<?php echo $r['id'];?>">
						<?php echo $r['name'];?></option>
			<?php }?>
		</select>
		Enter Title : <input type="text" name="title">
		Enter Link : <input type="link" name="link">
		<input type="submit" name="submit">
	</form>
</body>
</html>