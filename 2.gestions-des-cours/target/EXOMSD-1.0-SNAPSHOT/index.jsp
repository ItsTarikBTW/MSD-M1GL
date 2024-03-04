<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cours Management</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="antialiased h-full w-full">
<div class="flex flex-col items-center justify-center space-y-6 py-24">
    <h1 class="text-blue-500 font-bold">Cours Management</h1>
    <a href="${pageContext.request.contextPath}/index"
       class="bg-blue-600 hover:bg-blue-500 px-4 py-2 text-white rounded-md transition-all duration-200">Add
        and view Cours</a>
</div>
</body>
</html>