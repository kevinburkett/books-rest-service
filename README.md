# Books Rest Service

## Rest Endpoint with the following methods

- Add new books
- Get an book by id
- Update an existing book
- Search for books by any field, or any combination of fields. Exact matches only are ok.
- Search for books published within a certain date range.
- Show aggregates for entities
  - Count of Books, grouped by Year
  - Count of Books, grouped by Author

## Tasks

- Complete the search and count aggregate features
- Fix bug "Cannot find symbol" in BookController
- Add in more error checking

## Run project

```Bash
./mvnw clean spring-boot:run
```

## Endpoints

### Create Books

```Bash
curl -X POST localhost:8080/books -H 'Content-type:application/json' -d '{"id": "618346252", "authorName": "J.R.R. Tolkien", "title": "The Fellowship of the Ring (The Lord of the Rings, #1)", "publishDate": "07/29/1954", "tags": "Fantasy"}'
```

```Bash
curl -X POST localhost:8080/books -H 'Content-type:application/json' -d '{"id": "439023483", "authorName": "Suzanne Collins", "title": "The Hunger Games", "publishDate": "09/14/2008", "tags": "Drama"}'
```

```Bash
curl -X POST localhost:8080/books -H 'Content-type:application/json' -d '{"id": "618260307", "authorName": "J.R.R. Tolkien", "title": "The Hobbit", "publishDate": "09/21/1937", "tags": "Fantasy"}'
```

### Update Book by Id

```Bash
curl -X PUT localhost:8080/books/618346252 -H 'Content-type:application/json' -d '{"id": "618346252", "authorName": "J.R.R. Tolkien", "title": "The Fellowship of the Ring (The Lord of the Rings, #1)", "publishDate": "07/29/1954", "tags": "Fantasy,Drama"}'
```

### Get All Books

```Bash
curl -v localhost:8080/books
```

### Get Book By Id

```Bash
curl -v localhost:8080/books/618346252
```

### Delete Book by Id

```Bash
curl -X DELETE localhost:8080/books/618346252
```

### Search Books by Keyword (Still needs to be implemented)

```Bash
curl -X GET localhost:8080/search/Hobbit
```

### Count Books by Year (Still needs to be implemented)

```Bash
curl -X GET localhost:8080/count-by-year/1954
```

### Count Books by AuthorName (Still needs to be implemented)

```Bash
curl -X GET localhost:8080/count-by-author-name/Suzanne Collins
```
