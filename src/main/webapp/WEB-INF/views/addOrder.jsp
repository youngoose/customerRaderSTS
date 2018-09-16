<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
	<title>Order List page</title>
  </head>
  <body>
    <h2>Customer Order List</h2>

	<form action="addOrder" method="post">
		<fieldset>
		<legend>Please type new order information:</legend>
			Customer Name: <input type="text" name="customer_name"><br>
			Delivery Number: <input type="text" name="delivery_number"><br>
			Product: <input type="text" name="product"><br>
			Price: <input type="text" name="price"><br>
		</fieldset>
	
		<input type="submit" value="Add a new order">
	</form>

  </body>
</html>
