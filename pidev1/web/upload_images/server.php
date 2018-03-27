<?php

$temp_file = $_FILES['image']['tmp_name'] ;

$filename = $_FILES['image']['name'];

move_uploaded_file($temp_file,'C:/wamp64/www/pidev1/web/upload_images/upload_img/'. $filename);

 ?>
