<H1>Appointment Creation</H1>

<form action="/api/appointments" method="POST">
  Date:<br>
  <input type="datetime-local" name="dateTime" value="">
  <br>
  Informations:<br>
  <input type="text" name="informations" value="">
  <br><br>
  Report:<br>
  <input type="text" name="report" value="">
  <br>
  <h3>Realized</h3>
  <label>
    <input type="radio" value="true" name="status" />Yes</label>
<br><br>

  <input type="submit" value="Submit">
</form>
