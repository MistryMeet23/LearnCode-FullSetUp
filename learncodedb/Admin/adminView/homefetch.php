<?php
include("../conn.php");
$lan = $_POST['lanid'];
$lan = trim($lan);
$data = '';
$sql = "SELeCT * FROM homedata WHERE lan_id=" . $lan;
$res = mysqli_query($cn, $sql);
$count = 1;
while ($row = mysqli_fetch_array($res)) {

    $data .= "<tr>
                <td>" . $count . " </td>
                <td>" . $row['title'] . "</td>
                <td>" . $row['link'] . "</td> 
                <td> <a href='editlandata.php?id=" . $row['id'] . "'>Edit</a> </td>
                <td><a href='deletelandata.php?id=" . $row['id'] . "'>Delete</a></td>
                </tr>";
    $count = $count + 1;
}
echo $data;
?>