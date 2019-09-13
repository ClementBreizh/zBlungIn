<H1>Appointment Creation</H1>

<form action="/api/appointments" method="POST">
  <label for="appointmentDate">Date<label>
  <br>
  <input type="datetime-local" name="appointmentDate" id="appointmentDate" required>
  <br>
  <label for="informations">Informations</label>
  <br>
  <input type="text" name="informations" id="informations">
   <br>
      <label for="organizer">Organizer</label>
      <br>
      <input type="number" name="organizer" id="organizer">
  <br>
  <label for="persons">Invités</label>
  <br>
  <input type="number" name="persons" id="persons">
  <br>
  <label for="report">Report</label>
  <br>
  <input type="text" name="report" id="report">
  <br>
  <h3>Realized</h3>
  <label for="status">Yes</label>
  <input type="radio" value="true" name="status" id="status">
  <br><br>

  <input type="submit" value="Submit">
</form>
