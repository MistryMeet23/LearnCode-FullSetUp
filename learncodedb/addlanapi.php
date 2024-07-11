<?php

    include ('conn.php');

  if(isset($_GET['add']))
   {
       $name=$_POST['t1'];
       
       if($_FILES['upload'])
        {
            $on=$_FILES['upload']['name'];
            $sn=$_FILES['upload']['tmp_name'];          
            $dn="upload/".$on;
            move_uploaded_file($sn,$dn);
            
            $qry="INSERT INTO language(name,image) VALUES ('".$name."', '".$on."')";
            $res=mysqli_query($cn,$qry)or die("Error In Insert query");
            
            if($res==true)
             $_SESSION['msg']="File Uploaded Successfully";
            else
             $_SESSION['msg']="Could not upload File";
             
             
        }
   }

?>