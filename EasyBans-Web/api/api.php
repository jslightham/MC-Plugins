<?php
	define("key", KEY); // TODO: Make key customizable. 
	
	function get_mysql(){
		$mysql = new MySQLi("", "", "", ""); // login details removed
		
		if($mysql->connect_error){
			die($mysql->connect_error);
		}
		return $mysql;
	}
	
	function add($uuid, $reason){
		get_mysql()->query("INSERT INTO bans (uuid, date, reason) values ('$uuid', '" date("Y-M-D H:M:S") "', ");	
	}
?>
