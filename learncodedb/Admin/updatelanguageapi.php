<?php 
    require 'conn.php';

    $id=$_POST['id'];
    $uname=$_POST['name'];
    $image=$_POST['image'];

    $update_query="UPDATE language SET name='".$uname."', image='".$image."' WHERE id=".$id;
    $result=mysqli_query($cn,$update_query);
    
    if($result>0){

      $fetchuser=mysqli_query($cn,"SELECT id, name, image FROM language WHERE id='$id'");

    if(mysqli_num_rows($fetchuser)>0){

      while($row=$fetchuser->fetch_assoc()){
        $response["user"]=$row;
        }
        $response['error']="200";
        $response['message']="language update success";
      }
    else{
      $response["user"]=(object)[];
      $response['error']="400";
      $response['message']="language update but detail not fetch";

    }
    }
    else{
      $response["user"]=(object)[];
      $response['error']="400";
      $response['message']="language update failed";
    }
    echo json_encode($response);
 ?>