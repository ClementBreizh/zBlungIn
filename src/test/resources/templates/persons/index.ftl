<h1>Person</h1>

<form method="POST" action="/api/persons">
	<label for="firstname">Firstname</label>
	<br>
	<input type="text" name="firstname" id="firstname" required>
	<br>
	<label for="lastname">Lastname</label>
	<br>
	<input type="text" name="lastname" id="lastname" required>
	<br>
	<label for="email">Email</label>
	<br>
	<input type="email" name="email" id="email" required>
	<br>
	<label for="cellPhone">Cell phone</label>
	<br>
	<input type="text" name="cellPhone" id="cellPhone">
	<br>
	<label for="homePhone">Home Phone</label>
	<br>
	<input type="text" name="homePhone" id="homePhone">
	<br>
	<label for="commentary">Commentary</label>
	<br>
	<textarea name="commentary" id="commentary"></textarea>
	<br>
	<label for="mainContact">Main contact</label>
	<br>
	<input type="checkbox" name="mainContact" id="mainContact" value="true">
	<br>
	<label for="address">Address</label>
	<br>
	<input type="number" name="address" id="address">
	<br><br>
	<input type="submit" value="Submit">
</form>