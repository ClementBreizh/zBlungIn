<h1> Candidates by Company / Session</h1>

<form method="POST" action="/api/valCandidBySessionAndCompany">
  <label for="company">Company</label>
  <br>
  <input type="number" name="company" id="company" required>
  <br>
  <label for="validatedCandidates">Validated Candidates</label>
  <br>
  <input type="number" name="validatedCandidates" id="validatedCandidates" required>
  <br>
  <label for="session">Session</label>
  <br>
  <input type="number" name="session" id="session" required>
  <br><br>
  <input type="submit" value="Submit">
</form>
