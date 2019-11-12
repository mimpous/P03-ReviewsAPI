CREATE TABLE products (
     product_id MEDIUMINT NOT NULL AUTO_INCREMENT,
     product_name VARCHAR (255) NOT NULL,
     PRIMARY KEY (product_id) 
);

CREATE TABLE reviews (
    review_id MEDIUMINT NOT NULL AUTO_INCREMENT,
     review_descr VARCHAR (255) NOT NULL,
     PRIMARY KEY (review_id) ,
   FOREIGN KEY (review_id)
        REFERENCES products (product_id) 
);  
CREATE TABLE comments (
     comment_id MEDIUMINT NOT NULL AUTO_INCREMENT,
     comment_text VARCHAR (1000) NOT NULL,
     PRIMARY KEY (comment_id) ,
   FOREIGN KEY (comment_id)
        REFERENCES reviews (review_id) 
);

create sequence hibernate_sequence;
