<?php

include('../models/news.php');

$news_model = new News();


if(isset($_POST)&&!empty($_POST)){
    $news_model->news_title = $_POST['title'];
    $news_model->news_details = $_POST['details'];


    $news_model->news_title = strip_tags($news_model->news_title);
    $news_model->news_details = strip_tags($news_model->news_details);


    if($news_model->addRow()){
        $feedback['code'] =1250;
        $feedback['message']="data inserted successfully";
    }
    else{
        $feedback['code'] =1251;
        $feedback['message']="failed to insert data";
    }

    echo json_encode($feedback);
}


else if(isset($_GET['id'])){

   echo json_encode($news_model->getRows($_GET['id']));

}

else {
    //echo json_encode($news_model->getRows([$id]));
}

?>