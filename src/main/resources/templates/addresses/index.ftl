<h1>Address form</h1>

<form method="POST" action="/api/addresses">
	<label for="address">Address</label>
	<br>
	<input type="text" name="address" id="address" required>
	<br>
	<label for="postalCode">Postal Code</label>
	<br>
	<input type="text" name="postalCode" id="postalCode" required>
	<br>
	<label for="town">Town</label>
	<br>
	<input type="text" name="town" id="town" required>
	<br><br>
	<input type="submit" value="Submit">
</form>
