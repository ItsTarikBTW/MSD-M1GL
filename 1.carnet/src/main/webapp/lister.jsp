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

        <body class="bg-gray-950 text-white flex flex-col justify-center items-center">
          <h1 class="text-4xl font-bold mx-auto flex justify-center items-center ">
            <%= "MSD TP1: JEE" %>
          </h1>
          <br />
          <div class="flex justify-center items-center">
            <%List<Carnet> carnerList= (List<Carnet>) request.getAttribute("listCarnet");
                for (Carnet carnet : carnerList) {
                %>
                <div>
                  <div class="flex justify-center items-center ">

                    <div class="flex flex-col gap-2 bg-gray-800 hover:bg-gray-700 p-4 rounded-lg m-4">
                      <h2 class="text-2xl font-bold text-blue-500 text-center">
                        <%= carnet.nom %>
                      </h2>
                      <hr>
                      <table class="text-center w-full">

                        <tr class="text-lg flex gap-4 justify-center items-center">
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
                        <form action="delete" method="post">
                          <input type="hidden" name="carnet" value="<%=carnet.nom%>">
                          <button type="submit"
                            class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-trash-2"><path d="M3 6h18"/><path d="M19 6v14c0 1-1 2-2 2H7c-1 0-2-1-2-2V6"/><path d="M8 6V4c0-1 1-2 2-2h4c1 0 2 1 2 2v2"/><line x1="10" x2="10" y1="11" y2="17"/><line x1="14" x2="14" y1="11" y2="17"/></svg>
                          </button>
                        </form>
                        <a href="update.jsp?id=<%=carnet.nom%>"
                          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-pencil"><path d="M17 3a2.85 2.83 0 1 1 4 4L7.5 20.5 2 22l1.5-5.5Z"/><path d="m15 5 4 4"/>
                          </svg>
                        </a>
                      </div>
                    </div>
                </div>

          </div>
          <%}%>
            </div>
            <a href="add.jsp" class=" bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
              Add
            </a>
        </body>

        </html>