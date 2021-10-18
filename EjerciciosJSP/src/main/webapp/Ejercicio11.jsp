<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Ejercicio11.css" type="text/css">
<title>Ejercicio 11</title>
</head>
<body>

<%!
  static boolean esPrimo(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
%>

<%
	int n;
	for (int i = 0; i < 100; i++) {
		n = (int)(Math.random() * 200) + 1;
		if (esPrimo(n)) {
			out.print("<span class=\"primos\">" + n + "</span> ");
		} else {
			out.print(n + " ");
		}
	}
%>

</body>
</html>