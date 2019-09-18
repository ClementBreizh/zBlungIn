<h1> Candidates by Company / Session</h1>

<form method="POST" action="/api/companyBySession">
  <label for="company">Company</label>
  <br>
  <input type="number" name="company" id="company" required>
  <br>
  <label for="session">Session</label>
  <br>
  <input type="number" name="session" id="session" required>
  <br>
  <label for="validated">Validated</label>
  <br>
  <input type="checkbox" name="validated" id="validated" value="false">
  <br><br>
  <input type="submit" value="Submit">
</form>
