<h1> Candidates by Company / Session</h1>

<form method="POST" action="/api/candidBySessionAndCompany">
  <label for="company">Company</label>
  <br>
  <input type="number" name="company" id="company" required>
  <br>
  <label for="candidates">Candidates</label>
  <br>
  <input type="number" name="candidates" id="candidates" required>
  <br>
  <label for="session">Session</label>
  <br>
  <input type="number" name="session" id="session" required>
  <br><br>
  <input type="submit" value="Submit">
</form>
