<?php 
    include "conn.php"; 
    header("Location:index.php");
    if (isset($_GET['id'])) {
        $user_id = $_GET['id'];
        $sql = "DELETE FROM users WHERE `id`='$user_id'";
        $result = $cn->query($sql);
        if ($result == TRUE) {
            echo "Record deleted successfully.";
        }else{
            echo "Error:" . $sql . "<br>" . $cn->error;
        }
    }    
    exit();
?>