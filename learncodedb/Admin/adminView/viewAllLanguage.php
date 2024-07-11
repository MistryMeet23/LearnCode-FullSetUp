<div>
  <h2>Language Items</h2>
  <table class="table ">
    <thead>
      <tr>
        <th class="text-center">Lan No.</th>
        <th class="text-center">Language Image</th>
        <th class="text-center">Language Name</th>
        <th class="text-center" colspan="2">Action</th>
      </tr>
    </thead>
    <?php
    include_once "../conn.php";

    $sql = "SELECT * from language";
    $result = $cn->query($sql);
    $count = 1;
    if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
        ?>
        <tr>
          <td class="text-center">
            <?= $count ?>
          </td>

          <td class="text-center">
            <img src="<?php echo "./upload/" . $row['image']; ?>" width="70px" height="70px"> 
          </td>
          <td class="text-center">
            <?= $row["name"] ?>
          </td>
          <td class="text-center">
            <a class="btn btn-info" href="lanedit.php?id=<?php echo $row['id']; ?>">Edit</a>&nbsp;
            <a class="btn btn-danger" href="deletelan.php?id=<?php echo $row['id']; ?>">Delete</a>
          </td>
        </tr>
        <?php
        $count = $count + 1;
      }
    }
    ?>
  </table>
  <td><a class="btn btn-info" href="languagedata.php">Add Language</a></td>