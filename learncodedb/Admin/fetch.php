<?php
  require 'conn.php';
 
  $user="SELECT id, name, email FROM users";
  $result=mysqli_query($cn,$user);
 
  if(mysqli_num_rows($result)>0){ 
    while($row=$result->fetch_assoc()){
 
      $response['users'][]=$row;
      $response['error']="200";
    }
  }
  else{
    $response['error']="400";
    $response['users']=(object)[];
  }
  echo json_encode($response);
?>