<h1>AcquiredMatters</h1>

<form method="POST" action="/api/acquiredmatters">
  <label for="score">Score</label>
   <br>
  <input type="number" name="score" id="score">
  <br>
  <label for="validationDate">Validation Date</label>
  <br>
  <input type="date" name="validationDate" id="validationDate">
  <br>
  <label for="matter">Matter</label>
  <br>
  <input type="number" name="matter" id="matter" required>
  <br>
  <label for="candidate">Candidate</label>
  <br>
  <input type="number" name="candidate" id="candidate" required>
  <br><br>
  <input type="submit" value="Submit">
</form>
