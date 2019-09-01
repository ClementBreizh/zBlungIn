<h1>Person</h1>

<form method="POST" action="/api/persons">
	<label for="firstname">Firstname</label>
	<br>
	<input type="text" name="firstname">
	<br>
	<label for="lastname">Lastname</label>
	<br>
	<input type="text" name="lastname">
	<br>
	<label for="email">Email</label>
	<br>
	<input type="email" name="email">
	<br>
	<label for="cellPhone">Cell phone</label>
	<br>
	<input type="text" name="cellPhone">
	<br>
	<label for="homePhone">Home Phone</label>
	<br>
	<input type="text" name="homePhone">
	<br>
	<label for="commentary">Commentary</label>
	<br>
	<textarea name="commentary"></textarea>
	<br>
	<label for="mainContact">Main contact</label>
	<br>
	<input type="checkbox" name="mainContact" value="true">
	<br>
	<label for="address">Address</label>
	<br>
	<input type="number" name="address">
	<br><br>
	<input type="submit" value="Submit">
</form>