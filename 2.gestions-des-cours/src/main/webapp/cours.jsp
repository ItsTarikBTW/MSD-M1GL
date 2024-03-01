<%@ page import="com.example.exomsd.Models.Cours" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cours Management</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="antialiased h-full w-full my-20">
<div class="container mx-auto px-4">
    <h1 class="text-3xl font-bold mb-4">Cours Management</h1>

    <!-- Form to add a new Cours -->
    <div class="flex items-center justify-center p-12">
        <div class="mx-auto w-full max-w-[550px]">
            <form action="index" method="POST">
                <div class="mb-5">
                    <label
                            class="mb-3 block text-base font-medium text-[#07074D]"
                    >
                        Titre
                    </label>
                    <input
                            type="text"
                            name="titre"
                            placeholder="Titre"
                            class="w-full rounded-md border border-[#e0e0e0] bg-white py-2 px-4 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                    />
                </div>
                <div class="mb-5">
                    <label
                            class="mb-3 block text-base font-medium text-[#07074D]"
                    >
                        Auteur
                    </label>
                    <input
                            type="text"
                            name="auteur"
                            placeholder="Auteur"
                            class="w-full rounded-md border border-[#e0e0e0] bg-white py-2 px-4 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                    />
                </div>
                <div class="mb-5">
                    <label
                            class="mb-3 block text-base font-medium text-[#07074D]"
                    >
                        Contenu
                    </label>
                    <input
                            type="text"
                            name="contenu"
                            placeholder="Contenu"
                            class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                    />
                </div>

                <div class="mt-8">
                    <button type="submit"
                            class="hover:shadow-form rounded-md bg-blue-600 hover:bg-blue-500 transition-all duration-100 py-3 px-8 w-full text-base font-semibold text-white outline-none"
                    >
                        Submit
                    </button>
                </div>
            </form>
        </div>
    </div>

    <!-- List of Cours -->
    <h2 class="text-2xl font-bold mt-8 mb-2">List of Cours</h2>

    <div class="flex flex-col">
        <div class="overflow-x-auto sm:mx-0.5 lg:mx-0.5">
            <div class="py-2 inline-block min-w-full sm:px-6 lg:px-8">
                <div class="overflow-hidden">
                    <table class="min-w-full">
                        <thead class="bg-gray-200 border-b">
                        <tr>
                            <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                                #Id
                            </th>
                            <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                                Titre
                            </th>
                            <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                                Contenu
                            </th>
                            <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-left">
                                Auteur
                            </th>
                            <th scope="col" class="text-sm font-medium text-gray-900 px-6 py-4 text-center">
                                Actions
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Cours> cours = (List<Cours>) request.getAttribute("cours");
                            if (cours != null) {
                                for (Cours cour : cours) {
                        %>
                        <tr class="bg-white border-b transition duration-300 ease-in-out hover:bg-gray-100">
                            <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><%= cour.getId() %>
                            </td>
                            <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                <%= cour.getTitre() %>
                            </td>
                            <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                <%= cour.getContenu() %>
                            </td>
                            <td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                                <%= cour.getAuteur() %>
                            </td>
                            <td class="flex space-x-4 items-center justify-center my-3">
                                <form action="index/<%= cour.getId() %>" method="POST">
                                    <input type="hidden" name="_method" value="DELETE">
                                    <button type="submit"
                                            class="bg-red-600 hover:bg-red-500 transition-all duration-200 px-3 py-1 text-white rounded-md">
                                        Delete
                                    </button>
                                </form>
                                <a href="/index/<%= cour.getId() %>"
                                   class="bg-blue-600 hover:bg-blue-500 transition-all duration-200 px-3 py-1 text-white rounded-md">
                                    Edit
                                </a>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>