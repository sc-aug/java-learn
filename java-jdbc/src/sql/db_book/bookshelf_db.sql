CREATE DATABASE BookShelfDB;

USE BookShelfDB;

CREATE TABLE Book (
    Book_Id INT NOT NULL AUTO_INCREMENT,
    Book_Name VARCHAR(50) NOT NULL,
    Author VARCHAR(50) NOT NULL,
    Category VARCHAR(50) NOT NULL,
    Price NUMERIC(10,2) NOT NULL,
    Page_No INT NOT NULL,
    PRIMARY KEY (Book_Id)
);

INSERT INTO Book VALUES (NULL, "Harry Potter", "JK Rowling", 'Fiction', 21.5, 364);
INSERT INTO Book VALUES (NULL, "GOT I", "Martin", 'Fiction', 11.5, 573);
INSERT INTO Book VALUES (NULL, "The Universe in a Nutshell", "Hawking", "Science", 13.4, 322);

## TEST
## SELECT * FROM BookShelfDB.Book;