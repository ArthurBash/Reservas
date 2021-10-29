<%@page import="dao.impl.UsuarioDAOHibernateJPA"%>  
<%@page import="modelos.Usuario"%>  

<jsp:useBean id="u" class="modelos.Usuario"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
UsuarioDAOHibernateJPA dao = new UsuarioDAOHibernateJPA();

Usuario i = dao.persistir(u);  

%>  