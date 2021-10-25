<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <%   	
	int imagen = (int)(Math.random()*3) + 1;
	double dinero = Double.parseDouble(request.getParameter("dinero"));
            
	if(imagen==1) {
		out.print("<img src=\"https://w7.pngwing.com/pngs/1015/213/png-transparent-skull-and-crossbones-drawing-skull-face-head-skull-and-crossbones.png\" width=\"150\">");
		dinero = 0;
		out.print("<br>Has perdido tu dinero apostado.");
	} 
	if(imagen==2) {
		out.print("<img src=\"https://e7.pngegg.com/pngimages/967/39/png-clipart-meyer-lemon-citron-key-lime-lemonade-half-a-lemon-yellow-food-citrus.png\" width=\"150\">");
		dinero = dinero / 2.0;
		out.print("<br>Te quedas con la mitad del dinero apostado.");
	}
	if(imagen==3) {
		out.print("<img src=\"https://img2.freepng.es/20180311/jhe/kisspng-cat-maneki-neko-luck-feng-shui-ceramic-lucky-cat-decoration-5aa4d59ac53911.1184890615207520268078.jpg\" width=\"150\">");
		dinero = dinero * 2.0;
		out.print("<br>Tu dinero apostado se multiplica por 2.");
	}

	out.print("<br>Tienes " + dinero + " euros.");
	out.print("<br>¿Qué quieres hacer ahora?"); 
	out.print("<br> <br>");
        %>
        
<%
	if (dinero != 0) { 
%>
        <div>
        <form  method="post" action="juego.jsp">
                <input type="hidden" name="dinero" value="<%= dinero %>"> <!-- hidden=campo oculto -para la variable dinero*/-->
                <input type="submit" value="Volver a apostar!">
        </form>
        <form method="post" action="retirada.jsp">
        <br>
                <input type="hidden" name="dinero" value="<%= dinero %>"> <!-- hidden=campo oculto -para la variable dinero*/-->
                <input type="submit" value="Retirarme">
        </form>
        </div>
        <%
            } else {
        %>
          <form method="post" action="Ejercicio15.jsp">
            <input type="submit" value="Volver a jugar">
          </form>
        <%
            }     
        %>

</body>
</html>