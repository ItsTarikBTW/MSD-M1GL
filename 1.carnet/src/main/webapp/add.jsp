<%@ page import="java.util.List" %> <%@ page import="root.carnet.Model.Carnet"
%> <%@ page import="root.carnet.Model.Personne" %> <%@ page
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>JSP - Hello World</title>
    <script src="https://cdn.tailwindcss.com"></script>
  </head>

  <body class="bg-gray-950 text-white">
    <h1 class="text-4xl font-bold mx-auto flex justify-center items-center">
      <%= "MSD TP1: JEE" %>
    </h1>
    <br />
    <div class="flex justify-center items-center">
      <form
        class="flex flex-col gap-4 justify-center items-center ring-2 rounded-lg ring-blue-500 p-5"
        method="post"
        action="create"
      >
        <h1 class="text-center text-3xl">Add to carnet</h1>
        <div class="flex items-start justify-center gap-4">
          <div
            class="flex flex-col gap-4 justify-center items-center ring-2 ring-red-500 p-2 rounded-md"
          >
            <h2 class="text-center text-2xl">Person</h2>
            <div class="flex gap-4 justify-center items-center py-2">
              <label for="name">name:</label>
              <input
                type="text"
                name="name"
                class="text-black border-2 border-blue-500 rounded-lg p-2"
                placeholder="Enter your name"
              />
            </div>
          </div>
          <div
            class="flex flex-col gap-4 justify-center items-center ring-2 ring-red-500 p-2 rounded-md"
          >
            <h2 class="text-center text-2xl">Address</h2>
            <div class="flex gap-4 justify-center items-center py-2">
              <label for="nomA">nom:</label>
              <input
                name="nomA"
                type="text"
                class="text-black border-2 border-blue-500 rounded-lg p-2"
                placeholder="Enter your name"
              />
            </div>
            <div class="flex gap-4 justify-center items-center py-2">
              <label for="numRue">Rue:</label>
              <input
                name="numRue"
                type="number"
                class="text-black border-2 border-blue-500 rounded-lg p-2"
                placeholder="Enter your name"
              />
            </div>
            <div class="flex gap-4 justify-center items-center py-2">
              <label for="ville">Ville:</label>
              <input
                name="ville"
                type="text"
                class="text-black border-2 border-blue-500 rounded-lg p-2"
                placeholder="Enter your name"
              />
            </div>
          </div>
        </div>
        <button
          type="submit"
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
        >
          Submit
        </button>
      </form>
    </div>
  </body>
</html>
