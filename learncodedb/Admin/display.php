<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Learn Code</title>
</head>
<body style="background-color: white;">
	<center>
		<h1>
			Welcome To Learn
		</h1>
		<h2>The collection of programming languages</h2>
		<table>
			<?php

				include ('conn.php');

				$result = mysqli_query($cn,"SELECT * FROM language")or die("Error to Connect");

				if(mysqli_num_rows($result)>0){ ?>
				
					<th>Language</th>
					<th>Logo</th>
					<th>Edit</th>
					<th>Delete</th>
					
				<?php
				while ($r = mysqli_fetch_array($result)) {?>
						<tr>
							<td><h3><?php echo $r['name']; ?></h3></td>
							<td><img src="<?php echo "upload/".$r['image'];?>" width="150px"></td>					
							<td><a href="edit.php?id=<?php echo $r['id']; ?>">Edit</a></td>
							<td><a href="delete.php?id=<?php echo $r['id']; ?>">Delete</a></td>
						</tr>
					<?php
					}	
				}
			?>
		</table>
	</center>
</body>
</html>