<?php

class DB_Functions {

    private $db;

    //put your code here
    // constructor
    function __construct() {
        include_once './db_connect.php';
        // connecting to database
        $this->db = new DB_Connect();
        $this->db->connect();
    }

    // destructor
    function __destruct() {
        
    }

    /**
     * table name bi_directional_sync  and stores user
     * Storing new user
     * returns user details
     */
    public function storeUser($User) {
        // Insert user into database
        $result = mysql_query("INSERT INTO bi_directional_sync(Name) VALUES('$User')");
		
        if ($result) {
			return true;
        } else {			
				// For other errors
				return false;
		}
    }
    
    /*
    * Store new users created from phn
    */
    
        public function storeUserFromPhn($Id,$User) {
        // Insert user into database
        $Status = 1;
        $result = mysql_query("INSERT INTO bi_directional_sync(phoneId,Name,syncsts) VALUES($Id,'$User','$Status')");
 
        if ($result) {
            return true;
        } else {
            if( mysql_errno() == 1062) {
                // Duplicate key - Primary Key Violation
                return true;
            } else {
                // For other errors
                return false;
            }            
        }
    }
	 /**
     * Getting all users
     */
    public function getAllUsers() {
        $result = mysql_query("select * FROM bi_directional_sync");
        return $result;
    }
	/**
     * Get Yet to Sync row Count
     */
    public function getUnSyncRowCount() {
        $result = mysql_query("SELECT * FROM bi_directional_sync WHERE syncsts = FALSE");
        return $result;
    }
	
	public function updateSyncSts($id, $sts){
		$result = mysql_query("UPDATE bi_directional_sync SET syncsts = $sts WHERE Id = $id");
		return $result;
	}
}

?>
