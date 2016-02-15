CREATE TABLE crm_user(
			user_id VARCHAR(40) primary key NOT NULL,
 		 	user_name VARCHAR(40) NOT NULL,
 		 	user_loginName VARCHAR(40) NOT NULL,
 		 	user_password VARCHAR(40) NOT NULL,
	 		user_email VARCHAR(40) NOT NULL,
		 	user_registerDate DATETIME
		);