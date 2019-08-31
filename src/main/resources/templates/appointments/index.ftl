<H1>Appointment Creation</H1>

<form action="/api/appointments" method="POST">
  <label for="dateTime">Date<label>
  <input type="datetime-local" name="dateTime" value="">
  <br>
  <label for="informations">Informations</label>
  <input type="text" name="informations" value="">
  <br><br>
  <label for="report">Report</label>
  <input type="text" name="report" value="">
  <br>
  <h3>Realized</h3>
  <label>
  <input type="radio" value="true" name="status" />Yes</label>
  <br><br>

  <input type="submit" value="Submit">
</form>
