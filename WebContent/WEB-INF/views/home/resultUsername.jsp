
<c:if test="${fn:length(userList) gt 0}">
	<div>
	
		<table style="border: 1px solid black; text-align: center;">
			<thead><th>id</th><th>Username</th><th>Age</th></thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr><td>${user.id}</td><td>${user.username}</td><td>${user.age}</td></tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>
</c:if>

<p>Pseudo : ${searchedUser.username}</p>
<p>Id 	  : ${searchedUser.id}</p>
<p>Age    : ${searchedUser.age}</p>

<p style="color: green;">${validation}</p>
<p style="color: red;">${error}</p>