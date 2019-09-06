<h1>Has Done Assessment</h1>

<form method="POST" action="/api/hasdone">
	<label for="score">Score</label>
	<br>
	<input type="number" name="score" id="score" required>
	<br>
	<label for="validationDate">Validation Date</label>
	<br>
	<input type="date" name="validationDate" id="validationDate" required>
	<br>
	<label for="assessment">Assessment</label>
	<br>
	<input type="number" name="assessment" id="assessment" required>
	<br>
	<label for="candidate">Candidate</label>
	<br>
	<input type="number" name="candidate" id="candidate" required>
	<br><br>
	<input type="submit" value="Submit">
</form>