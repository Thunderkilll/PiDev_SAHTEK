<?php

$temp_file = $_FILES['image']['tmp_name'] ;

$filename = $_FILES['image']['name'];

move_uploaded_file($temp_file,'upload_img/'. $filename);
 ?>
