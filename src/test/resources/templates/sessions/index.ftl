<h1>Session</h1>

<form method="POST" action="/api/sessions">
  <label for="name">Name</label>
  <input type="text" name="name" id="name" required>
  <br>
  <label for="startDate">Start Date</label>
  <input type="date" name="startDate" id="startDate" required>
  <br>
  <label for="endDate">End Date</label>
  <input type="date" name="endDate" id="endDate" required>
  <br><br>
  <input type="submit" value="Submit">
</form>
