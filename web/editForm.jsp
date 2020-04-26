<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Edit book</title>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <c:set var="book" scope="request" value="${requestScope['book']}"/>
    <h1>Edit book : ${book.getTitle()}</h1>
    <hr>
    <form method="post" action="${pageContext.request.contextPath}/bookManager?action=editBook&id=${book.getId()}">
        <div class="form-group">
            <label for="inputTitle">Title</label>
            <input type="text" class="form-control" id="inputTitle" value="${book.getTitle()}" name="title" max>
        </div>
        <div class="form-group">
            <label for="inputPrice">price</label>
            <input type="text" class="form-control" id="inputPrice" value="${book.getPrice()}" name="price">
        </div>
        <div class="form-group">
            <label for="inputBookNumber">Book Number</label>
            <input type="number" class="form-control" id="inputBookNumber" name="bookNumber"
                   value="${book.getBookNumber()}">
        </div>
        <div class="form-group">
            <label for="inputCategory">Category</label>
            <input type="text" class="form-control" id="inputCategory" name="category" value="${book.getCategory()}">
        </div>
        <div class="form-group">
            <label for="inputAuthor">Author</label>
            <input type="text" class="form-control" id="inputAuthor" name="author" value="${book.getAuthor()}">
        </div>
        <div class="form-group">
            <label for="inputImage">Image src</label>
            <input type="text" class="form-control" id="inputImage" name="image" value="${book.getImage()}">
        </div>
        <div class="form-group">
            <label for="inputPublisher">Publisher</label>
            <input type="text" class="form-control" id="inputPublisher" name="publisher" value="${book.getPublisher()}"
                   maxlength="1000">
        </div>
        <div class="form-group">
            <label for="inputInfo">Info</label>
            <input type="text" class="form-control" id="inputInfo" name="info" value="${book.getInfo()}"
                   maxlength="1000">
        </div>
        <button class="btn btn-primary" type="submit">Submit</button>
    </form>
    <a href="${pageContext.request.contextPath}/bookManager">Back</a>
</div>
</body>
</html>