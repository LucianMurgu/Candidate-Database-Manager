<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>List Candidates</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Candidates Database Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Candidate"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>position</th>
					<th>level</th>
					<th>action</th>
				</tr>
				
				<c:forEach var="tempCandidate" items="${candidates}">
				
				
					<c:url var="updateLink" value="/candidate/showFormForUpdate">
						<c:param name="candidateId" value="${tempCandidate.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/candidate/delete">
						<c:param name="candidateId" value="${tempCandidate.id}" />
					</c:url>					
	
					<tr>
						<td> ${tempCandidate.firstName} </td>
						<td> ${tempCandidate.lastName} </td>
						<td> ${tempCandidate.email} </td>
						<td> ${tempCandidate.position} </td>
						<td> ${tempCandidate.level} </td>
						<td>
							<a href="${updateLink}">Update</a>
							<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this candidate?'))) return false">Delete</a>
						</td>
	
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>
