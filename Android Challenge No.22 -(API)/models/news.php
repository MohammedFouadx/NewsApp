<?php
include('../db_config.php');
class News{
    public $id;
    public $news_title;
    public $news_details;
    public $news_images;
    public $news_date;

    public $conn;


    function __construct(){
        $this->conn = new DBConfig();
    }



        

    function getRows($id){
        $pdo = $this->conn->connect();
        //select news.news_title,news_details,news_images,news_date,category.cat_title
        $stmt = $pdo->prepare("select news.*,category.cat_title from news , category where news.cat_id=category.cat_id and news.cat_id = ? ");
        $stmt->execute([$id]);
        return (object) array("getAllRows"=>$stmt->fetchAll(PDO::FETCH_OBJ));

        $data = array();
        foreach($row as $row){
            $content['id'] = $row->id;
            $content['title'] = $row->news_title;
            $content['date'] = $row->news_date;

            array_push($data,$content);
        }
        return $data;

        

    }


    }


    
    // function getRows(){
    //     $pdo = $this->conn->connect();
    //     //select news.news_title,news_details,news_images,news_date,category.cat_title
    //     $stmt = $pdo->prepare("select news.*,category.cat_title from news , category where news.id=category.cat_id");
    //     $stmt->execute();
    //     return (object) array("getAllRows"=>$stmt->fetchAll(PDO::FETCH_OBJ));

    //     $data = array();
    //     foreach($row as $row){
    //         $content['id'] = $row->id;
    //         $content['title'] = $row->news_title;
    //         $content['date'] = $row->news_date;

    //         array_push($data,$content);
    //     }
    //     return $data;





?>