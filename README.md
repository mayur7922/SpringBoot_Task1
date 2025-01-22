# Created a REST API using Spring Boot for keeping track of books

## Routes

- GET route (/api/books) : To view all of the books
- GET route with query parameter (AuthorName) (/api/books/getByAuthor?authorName=name) : To view books written by a particular author
- GET route with path variable (ID) (/api/books/{id}): To view a particular book using ID
- POST route (/api/books): To make a new entry of the book
- PATCH route with path variable (ID) (/api/books/{id}): To make some changes related to a particular book
- DELETE route with path variable (ID) (/api/books/{id}) : To delete an entry of a book

## Technologies Used
- Spring Boot
- JAVA Programming language
