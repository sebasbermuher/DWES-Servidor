<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 7</title>
</head>
<body>
    
<form method="post">
	<label for="altura_piramide">Introduce la altura de la piramide:</label>
	<input id="altura" type="text"  name="altura" required>
	<input type="submit" value="Dibujar">
</form>

<% if(request.getMethod().equals("POST")){
	int alturaTotal = Integer.parseInt(request.getParameter("altura"));
    int altura = 1;
    int i = 0;
    int espacios = alturaTotal - 1;
    while (altura <= alturaTotal) {
      // inserta espacios en blanco (imagen de fondo blanco)
      for (i = 1; i <= espacios; i++) {
        out.print("<img src=\"https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/6169b41c-74fe-4235-9815-1e8d4dc87406/d3hgxl4-a6d413df-c24f-4077-b1d2-8765659ef170.png/v1/fill/w_900,h_800,strp/png_fondo_blanco_by_camilhitha124_d3hgxl4-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9ODAwIiwicGF0aCI6IlwvZlwvNjE2OWI0MWMtNzRmZS00MjM1LTk4MTUtMWU4ZDRkYzg3NDA2XC9kM2hneGw0LWE2ZDQxM2RmLWMyNGYtNDA3Ny1iMWQyLTg3NjU2NTllZjE3MC5wbmciLCJ3aWR0aCI6Ijw9OTAwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.cqTa97iqaSe0PxJFnP1-_DyuUqhlBsPnj9Yy5b3abZg\"width=\"50\">");
      }
      // pinta el triangulo
      for (i = 1; i < altura * 2; i++) {
        out.print("<img src=\"https://img1.freepng.es/20180719/cgt/kisspng-equilateral-triangle-black-triangle-equilateral-po-black-triangle-5b5027b6dd4dc8.9553907315319797029065.jpg\" width=\"50\">");
      }
      out.println("</br>");
      altura++;
      espacios--;
    }
}
  %>

</body>
</html>