<%--<%!	int doble(int x) {return 2 * x;}	--%>

<%-- <h1>Hola mundo</h1>--%>
<%-- 
<% 
for (int i=1;i<5;i++){
	out.println("<h"+i+">HOLA</h"+i+">");
} 
%>
<%=doble(10) %>
--%>
	<%-- Esto no se ve  --%>
	<!-- Esto si se ve -->
<%-- <br/>
<%= "-----------------"%>
<br/>
<%=(doble(15)) %>

<h1>Adios</h1>
--%>
<%@page import="java.util.Random" %>
<% 
Random r = new Random();

for(int i=0;i<15;i++){
	String tamanyo = ""+(r.nextInt(6)+1);
	out.println(
			"<h"+
	tamanyo+
	">HOLA</h"+
	tamanyo+
	">"
			);
}

%>