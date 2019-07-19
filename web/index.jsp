<%-- 
    Document   : index
    Created on : 17-jul-2019, 21:02:12
    Author     : dany
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora JSP</title>
    </head>
    <body>
        
       	<%! private String a = "0";%> 
  	<%! private String b = "0";%> 
        <%! private String value = "0";%>
        <%! private String op = "plus";%>
        <%! private String msg = "";%>
        
        <h1>Mi calculadora!</h1>
                
        <% 
            if (null != request.getAttribute("a")) {
                a = String.valueOf(request.getAttribute("a"));
            }
            if (null != request.getAttribute("b")) {
                b = String.valueOf(request.getAttribute("b"));
            }
            if (null != request.getAttribute("value")) {
                value = String.valueOf(request.getAttribute("value"));
            }
            if (null != request.getAttribute("msg")) {
                msg = String.valueOf(request.getAttribute("msg"));
            }
            if (null != request.getAttribute("op")) {
                op = String.valueOf(request.getAttribute("op"));
            }
        %>
        
        <form action="process" method="POST">
            <table>
                <thead>
                <th>Valor1</th>
                <th>Operación</th>
                <th>Valor2</th>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <input name="a" type="text" value="<%=a%>">
                        </td>
                        <td>
                            <select name="o">
                                <option value="plus" ${op == 'plus' ? 'selected': ''}> + </option>
                                <option value="minus" ${op == 'minus' ? 'selected': ''}> - </option>
                                <option value="times" ${op == 'times' ? 'selected': ''}> * </option>
                                <option value="divided" ${op == 'divided' ? 'selected': ''}> / </option>
                            </select>
                        </td>
                        <td>
                            <input name="b" type="text" value="<%=b%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Calcular">
                        </td>
                        <td>
                            Resultado:
                        </td>
                        <td>
                            <strong><%=value%></strong>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <textarea disabled="disabled" cols="40" rows="10">
                                <%=msg%>
                            </textarea>
                            
                        </td>
                    </tr>
                </tbody>
            </table>
           <%= (new java.util.Date()).toLocaleString()%>
        </form>
    </body>
</html>
