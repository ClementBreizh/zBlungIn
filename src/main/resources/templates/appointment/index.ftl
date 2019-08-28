<H1>Appointment Creation</H1>

<form action="/appointment/insert" method="POST">
  Date:<br>
  <input type="date" name="dateTime" value="">
  <br>
  Informations:<br>
  <input type="text" name="informations" value="">
  <br><br>
  Report:<br>
  <input type="text" name="report" value="">
  <br>
  <h3>Realized</h3>
  <label>
    <input type="radio" class="radio" value="1" name="status" />Yes</label>
  <label>
    <input type="radio" class="radio" value="-1" name="status" />No</label>
<br><br>

  <input type="submit" value="Submit">
</form>
