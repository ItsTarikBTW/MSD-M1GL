<%@ page import="java.util.List" %>
<%@ page import="root.carnet.Model.Carnet" %>
<%@ page import="root.carnet.Model.Personne" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
  <%List<Carnet> carnerList= (List<Carnet>) request.getAttribute("listCarnet");
      for (Carnet carnet : carnerList) {
      %>
      <a href="listerPersonne?carnet=<%=carnet.nom%>">
      <div class="flex justify-center items-center ">

          <div class="flex flex-col gap-2 bg-gray-800 hover:bg-gray-700 p-4 rounded-lg m-4">
            <h2 class="text-2xl font-bold text-blue-500 text-center">
            <%= carnet.nom %>
          </h2>
          <hr>
          <table class="text-center w-full">

            <tr class="text-lg flex gap-4 items-center">
              <% for (Personne s : carnet.ensemble.keySet()) { %>
                <td class="text-2xl font-bold">
                  <%= s.nom %>
                </td>
                <td class="flex flex-col w-26 ">
                  <%= carnet.ensemble.get(s).nom %>
                  <hr>
                  <%= carnet.ensemble.get(s).numRue %>
                  <hr>
                  <%= carnet.ensemble.get(s).ville %>
                </td>
              <%}%>
            </tr>
          </table>
          <hr>
          <div class="flex gap-1 justify-center items-center">
            <a href="deleteCarnet?carnet=<%=carnet.nom%>" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
              Del
            </a>
            <a href="updateCarnet?carnet=<%=carnet.nom%>" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
              Upd
            </a>
        </div>
        </div>
      </a>

      </div>
      <%}%>
    </div>
</body>

</html>