<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Jstl</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>

	<div class=" row bg-light p-5"
		style="width: 100%; margin-left: auto; margin-right: auto; margin-top: 50px; text-align: center;">
		<div class="col-11">
		
			<h3>Liste des voitures de ${connectedClient.getNom()}</h3> 
			<table class="table">
				<thead class="thead-dark">
					<tr>			
						<th scope="col">Reference</th>
						<th scope="col">Marque</th>
						<th scope="col">Couleur</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="voiture" items="${voituresClient}">
								<tr>
									<td><c:out value="${voiture.getReference()}" /></td>
									<td><c:out value="${voiture.getMarque()}" /></td>
									<td><c:out value="${voiture.getCouleur()}" /></td>
								</tr>
					</c:forEach>
				</tbody>
			</table> <br>
			
			<h4>Liste des coordoonées du compte de ${connectedClient.getNom()}</h4>
			<table class="table">
				<thead class="thead-dark">
					<tr>			
						<th scope="col">Id du compte</th>
						<th scope="col">Reference du compte</th>
						<th scope="col">Solde</th>
					</tr>
				</thead>
				<tbody>
					<tr>			
						<th scope="col">${compte.getId_compte()}</th>
						<th scope="col">${compte.getReference()}</th>
						<th scope="col">${compte.getSolde()}</th>
					</tr>
				</tbody>
			</table> <br>
			<h3>Liste des commandes de ${connectedClient.getNom()}</h3> 
			<table class="table">
				<thead class="thead-dark">
					<tr>			
						<th scope="col">Produit</th>
						<th scope="col">Nombre</th>
						<th scope="col">Prix</th>
						<th scope="col">Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="commande" items="${commandesClient}">
								<tr>
									<td><c:out value="${commande.getProduit()}" /></td>
									<td><c:out value="${commande.getNombre()}" /></td>
									<td><c:out value="${commande.getPrix()}" /></td>
									<td><c:out value="${commande.getDate()}" /></td>
								</tr>
					</c:forEach>
				</tbody>
			</table>
<!-- 			<form method="post" action="jstl"> -->
<!--                 <label for='txtNom'>Nouveau produit :</label> -->
<!--                 <input id='txtNom' name='txtNom' type='text' value='' autofocus /> <br /> -->
<!--                 <br /> -->
<!--                 <input name='btnConnect' type='submit' value='Ajouter Nom' /> <br /> -->
<!--             </form> -->
<br> 
       <form method="post" action="AjoutCmd.jsp">
            <input name='btnConnect' value='Ajouter Commande' type='submit' /> <br/>
        </form>  
		</div>
		

	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>