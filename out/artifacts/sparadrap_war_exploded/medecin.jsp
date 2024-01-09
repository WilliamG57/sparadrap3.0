<%--
  Created by IntelliJ IDEA.
  User: User-09
  Date: 08/01/2024
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<section class="info_client">
    <label for="choice" class="info_client_details">Selectionner un client :
        <select id="choice" name="choice">
            <c:forEach items="${medecins}" var="medecin">
                <option value="${medecin.id}">${medecin.nom}</option>
            </c:forEach>
        </select></label>
    <label for="nom" class="info_client_details">Nom :
    <input type="text" name="name" id="nom" required/></label>
    <label for="prenom" class="info_client_details">Prénom :
    <input type="text" name="prenom" id="prenom" required/></label>
    <label for="adresse" class="info_client_details">Adresse :
    <input type="text" name="adresse" id="adresse" required/></label>
    <label for="postal" class="info_client_details">Code postal :
    <input type="text" name="postal" id="postal" required/></label>
    <label for="ville" class="info_client_details">Ville :
    <input type="text" name="ville" id="ville" required/></label>
    <label for="telephone" class="info_client_details">Telephone :
    <input type="tel" name="telephone" id="telephone"></label>
    <label for="email" class="info_client_details">Email :
    <input type="email" name="email" id="email"></label>
    <label for="agreement" class="info_client_details">Agreement :
    <input type="text" name="agreement" id="agreement"></label>
</section>

