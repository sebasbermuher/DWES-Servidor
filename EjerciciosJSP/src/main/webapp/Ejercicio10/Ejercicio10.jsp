<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 10</title>
</head>
<body>

<h1>Serie de Fibonacci</h1>

<form method="post">
      Introduce un numero:
      <input type="number" name="num">
      <p><input type="submit" value="Aceptar"></p>
</form>

<% if(request.getMethod().equals("POST")){
	
	int num = Integer.parseInt(request.getParameter("num"));
	
	switch (num) {
    case 1:
    	out.print("0");
      break;
    case 2:
    	out.print("0 , 1");
      break;
    default:
    	out.print("0 , 1");
      int f1 = 0;
      int f2 = 1;
      int aux;
      while(num > 2) {
          aux = f1;
          f1 = f2;
          f2 = aux + f2;
          out.print(" " + " , " + f2);
          num--;
      }
  }
}
%>
</body>
</html>