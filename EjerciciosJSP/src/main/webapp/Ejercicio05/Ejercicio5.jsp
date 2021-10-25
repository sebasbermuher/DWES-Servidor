<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 5</title>
</head>
<body>
<h1>Conversor de euros a dolares</h1>




<form method="post">
	<label for="euros">Introduce la cantidad:</label>
	<input id="cantidad" type="text"  name="cantidad" required>
	<p><input type="submit" name="dae" value="Calcular de dolares a euros">
	<input type="submit" name="ead" value="Calcular de euros a dolares"></p>
</form>

<% if(request.getMethod().equals("POST")){

    double cantidad = Double.parseDouble(request.getParameter("cantidad"));
    double cant2;

    if(request.getParameter("ead")!=null){
    	cant2 = cantidad;
        cantidad = 0.86 * cantidad;
        out.println(cant2 + "$ = " + cantidad + "€");
    } else{
    	cant2 = cantidad;
        cantidad = 1.16 * cantidad;
        out.println(cant2 + "€ = " + cantidad + "$");
    }
}
%>
<p><img src="https://es.calcuworld.com/wp-content/uploads/sites/2/2019/11/euro-a-dolar.png" width="75"
     height="75" /></p>

</body>
</html>