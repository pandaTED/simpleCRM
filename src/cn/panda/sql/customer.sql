CREATE TABLE crm_customer(
		customer_id VARCHAR(40) primary key NOT NULL,
		customer_name VARCHAR(40) NOT NULL,
		customer_gender VARCHAR(4) NOT NULL,
		customer_birthday DATE,
		customer_cellphone VARCHAR(20) NOT NULL,
		customer_email VARCHAR(40),
		customer_type VARCHAR(100) NOT NULL,
		customer_description VARCHAR(255),
		customer_user_id VARCHAR(40),
		constraint crm_user_id_FK foreign key(customer_user_id) references crm_user(user_id)
		);