<form method="POST" action="/WS-IS-FIRST/user/login">

	<div>
		<label>Username :</label> <input type="text" placeholder="Your username" name="inputUsername" />
	</div>
	<div>
		<label>Password :</label> <input type="password" placeholder="Your password" name="inputPassword" />
	</div>
	<div>
		<input type="submit" value="Connect" />
	</div>

</form>

<p style="color: red;">${error}</p>
<p style="color: green;">${validation}</p>