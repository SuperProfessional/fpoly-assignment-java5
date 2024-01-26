<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="f" uri="jakarta.tags.functions" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 Error Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom styles for this template */
        body {
            padding-top: 5rem;
            padding-bottom: 5rem;
            color: #fff;
            background-color: #007bff;
            text-align: center;
        }

        .container {
            width: auto;
            max-width: 600px;
            padding: 15px;
        }

        .container-narrow {
            margin: 0 auto;
        }

        .jumbotron {
            margin-bottom: 0;
            background-color: #fff;
        }

        .jumbotron h1 {
            font-size: 72px;
            line-height: 1;
        }

        @media (min-width: 768px) {
            .jumbotron {
                padding-top: 48px;
                padding-bottom: 48px;
            }
            .jumbotron h1 {
                font-size: 96px;
            }
        }

        .error-code {
            font-size: 96px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1 class="error-code">404</h1>
        <p class="lead">Page not found</p>
        <p>${message}</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Go to Home Page</a></p>
    </div>
</div>

</body>
</html>
