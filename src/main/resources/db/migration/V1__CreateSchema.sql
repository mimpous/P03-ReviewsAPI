CREATE TABLE products (
     product_id SMALLINT NOT NULL AUTO_INCREMENT,
     product_name VARCHAR (255) NOT NULL,
     PRIMARY KEY (product_id) 
);

CREATE TABLE reviews (
    review_id SMALLINT NOT NULL AUTO_INCREMENT,
    product_id SMALLINT NOT NULL ,
	review_mongo_id VARCHAR (255) NOT NULL,    
    review_descr VARCHAR (255) NOT NULL,
   PRIMARY KEY (review_id) ,
   FOREIGN KEY (product_id)
        REFERENCES products (product_id) 
); 
  
CREATE TABLE comments (
     comment_id SMALLINT NOT NULL AUTO_INCREMENT,
     review_id SMALLINT NOT NULL ,
     comment_text VARCHAR (1000) NOT NULL,
     PRIMARY KEY (comment_id) ,
   FOREIGN KEY (review_id)
        REFERENCES reviews (review_id) 
);
 

