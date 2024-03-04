<%@ page import="com.example.exomsd.Models.Cours" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= ((Cours) request.getAttribute("cour")).getTitre() %> | Modification</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="antialiased h-full w-full my-20">


<div class="mx-auto flex flex-col items-center space-y-4">
    <div class="flex w-96 flex-col rounded-xl bg-white bg-clip-border text-gray-700 shadow-md">
        <div class="p-6">
            <h5 class="mb-2 block font-sans text-xl font-semibold leading-snug tracking-normal text-blue-gray-900 antialiased">
                <%= ((Cours) request.getAttribute("cour")).getTitre() %> | Auteur
                : <%= ((Cours) request.getAttribute("cour")).getAuteur() %>
            </h5>
            <p class="block font-sans text-base font-light leading-relaxed text-inherit antialiased">
                <%= ((Cours) request.getAttribute("cour")).getContenu() %>
            </p>
        </div>
    </div>
    <form class="w-full max-w-lg p-5" action="index" method="POST">
        <input type="hidden" name="_method" value="PUT">
        <input type="hidden" name="id" value="<%= ((Cours) request.getAttribute("cour")).getId() %>">
        <div class="flex flex-wrap -mx-3 mb-6">
            <div class="w-full px-3">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                    Titre
                </label>
                <input
                        class="block w-full text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none"
                        placeholder="Contenu" type="text" name="titre"/>
            </div>
        </div>
        <div class="flex flex-wrap -mx-3 mb-6">
            <div class="w-full px-3">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                    Contenu
                </label>
                <input
                        class="block w-full text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none"
                        placeholder="Contenu" type="text" name="contenu"/>
            </div>
        </div>
        <div class="flex flex-wrap -mx-3 mb-6">
            <div class="w-full px-3">
                <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                    Auteur
                </label>
                <input
                        class="block w-full text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none"
                        placeholder="Contenu" type="text" name="auteur"/>
            </div>
        </div>
        <div class="flex items-center justify-center">
            <div class="w-full">
                <button
                        class="shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded w-full"
                        type="submit">
                    Update
                </button>
            </div>
        </div>
    </form>
</div>
</body>
</html>