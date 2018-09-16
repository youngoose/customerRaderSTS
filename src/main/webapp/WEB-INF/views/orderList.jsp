<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
	<title>Order List page</title>
  </head>
  <body>
    <h2>Customer Order List</h2>

    <c:forEach var="customerList" items="${customerList}"> 
   	  * Order ID : <c:out value="${customerList.orderId}"/><br>
   	  Customer Name : <c:out value="${customerList.customerName}"/><br>
   	  Delivery Number : <c:out value="${customerList.deliveryNumber}"/><br>
   	  Product : <c:out value="${customerList.product}"/><br>
   	  Price : <c:out value="${customerList.price}"/><br><br>
    </c:forEach>

  </body>
</html>
