<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel='stylesheet' type='text/css' href='styles.css' />
<title>Ajouter COmmande</title>
</head>
<body>
<h1>je suis ${connectedClient.getNom()}  et je suis connecté</h1>
<br>
        <form method="post" action="ajout">
            <label for='txtProduit'>Produit :</label>
            <input id='txtProduit' name='txtProduit' type='text' value='' autofocus /> <br/>
            
            <label for='txtNombre'>Nombre :</label>
            <input name='txtNombre' type='text' value='' /> <br/>
            
            <label for='txtPrix'>Prix :</label>
            <input id='txtPrix' name='txtPrix' type='text' value=''  /> <br/>

            <br/>
            <input name='btnConnect' value='Ajouter Commande' type='submit' /> <br/>
        </form>  
</body>
</html>