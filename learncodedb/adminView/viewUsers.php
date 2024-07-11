<div>
  <h2>All Customers</h2>
  <table class="table ">
    <thead>
      <tr>
        <th class="text-center">S.N.</th>
        <th class="text-center">Username </th>
        <th class="text-center">Email</th>
        <th class="text-center">Contact Number</th>
        <th class="text-center">Joining Date</th>
        <th class="text-center">Action</th>

      </tr>
    </thead>
    <?php
    include_once "../conn.php";
    $sql = "SELECT * from users";
    $result = $cn->query($sql);
    $count = 1;
    if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
        ?>
        <tr>
          <td class="text-center">
            <?= $count ?>
          </td>
          <td >
            <?= $row["name"] ?>
          </td>
          <td >
            <?= $row["email"] ?>
          </td>
          <td >
            <?= $row["number"] ?>
          </td>
          <td >
            <?= $row["registerdate"] ?>
          </td>
          <td class="text-center">
            <a class="btn btn-danger" href="deleteuser.php?id=<?php echo $row['id']; ?>">Delete</a>
          </td>
        </tr>
        <?php
        $count = $count + 1;
      }
    }
    ?>
  </table>