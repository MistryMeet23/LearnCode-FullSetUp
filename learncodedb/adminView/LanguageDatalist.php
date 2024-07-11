<?php
include("../conn.php");
?>
<script type="text/javascript">
  $(document).ready(function () {
    $("#language").change(function () {
      var lanid = $("#language").val();

      $.ajax({
        url: "./adminView/homefetch.php",
        type: "POST",
        data: 'lanid=' + lanid,
        success: function (data) {
          $('#ans').html(data);
        }
      });
    });
  });
</script>
<div>
  <h2>Language Data</h2>
  <form method="post">
    <label>Choose a Language:</label>
    <select selected="" name="language" id="language">
      <option value="0">Select Language</option>
      <?php
      $sql = "SELECT * from language";
      $result = $cn->query($sql);
      $count = 1;
      if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
          ?>
          <option value="<?= $row["id"] ?>"><?= $row["name"] ?></option>
          <?php
          $count = $count + 1;
        }
      }
      ?>
    </select>
  </form>
  <table class="table">
    <thead>
      <tr class="text-center">
        <th class="text-center">Lan no</th>
        <th class="text-center">Language Title</th>
        <th class="text-center">Language Link</th>
        <th class="text-center" colspan="2">Action</th>
      </tr>
    </thead>
    <tbody id="ans" class="text-center">
      <?php

      ?>
    </tbody>
    <td>
      <a class="btn btn-info" href="./landata.php">Add Language Data</a>
    </td>
  </table>
</div>