<h1>Address form</h1>

<form method="POST" action="/api/addresses">
	<label for="street">Street</label>
	<br>
	<input type="text" name="street" id="street" required>
	<br>
	<label for="postalCode">Postal Code</label>
	<br>
	<input type="text" name="postalCode" id="postalCode" required>
	<br>
	<label for="city">City</label>
	<br>
	<input type="text" name="city" id="city" required>
	<br><br>
	<input type="submit" value="Submit">
</form>
