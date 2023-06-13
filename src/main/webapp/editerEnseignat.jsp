<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="Css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>
<div class="container">
<div class="card">
			<header id="header">
			
				<div class="inner">
					
					<nav id="nav" style="text-align: center;"><centre>
						  <a class="nav-link" href="chercherensgn.do?motCle1=" title="Consultez la liste des enseignants">
    <!--  <i class="fa fa-users"></i>-->
    Liste des Enseignants
  </a>
						
						 <a class="nav-link" href="saisie.do" title="Cliquez ici pour ajouter un enseignant !">
    
    Ajouter un Enseignant
  </a>
  
  <a href="Vue.html" class="w3-bar-item w3-button tablink">Logout</a> 
  </centre>
					</nav>
					<a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
				</div>
				
			</header>
			</div>
			</div>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Modification des Enseignant
  </div>
  <div class="card-body">
      <form action="updateEnseignant.do" method="post" >
      <div hidden class="form-group"  >
       <label class="control-label">ID Enseignant :</label>
       <input type="text" name="id" class="form-control" value="${enseignant.id_enseignant}" style="display: inline-block; color:  black;  "/>
      </div>
      <div class="form-group">
       <label class="control-label">Nom :</label>
       <input type="text" name="nom" class="form-control" value="${enseignant.nom}" style="display: inline-block; color:  black;  "/>
      </div>
      <div class="form-group">
       <label class="control-label">Prenom :</label>
       <input type="text" name="prenom" class="form-control" value="${enseignant.prenom}" style="display: inline-block; color:  black;  "/>
      </div>
      
      
      <div class="form-group">
       <label class="control-label">heur :</label>
       <input type="text" name="heur" class="form-control" value="${enseignant.heur}"style="display: inline-block; color:  black;  "/>
      </div>
      <div>
        <button type="submit" class="btn btn-primary">Modifier</button>
      </div>
      </form>     
  </div>
</div>
</div>
</body>
</html>
<style>
.card-header {
        background-color: #f4cccc;
        color: white;
        padding: 10px;
    }
   button[type="submit"] {
 		margin: 10px;     
        padding: 5px 10px;
        background-color: rgb(117, 117, 154);
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

  .form-group label {
    font-weight: bold;
  }

  .form-control[readonly] {
    background-color: rgb(117, 117, 154);
    cursor: not-allowed;
  }

  .btn-primary {
    background-color: rgb(117, 117, 154);
    border-color: #007bff;
  }

  .btn-primary:hover {
    background-color: #0069d9;
    border-color: #0062cc;
  }
</style>

