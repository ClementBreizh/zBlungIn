<H1>Company Creation</H1>

<form action="/api/companies" method="POST">
  <label for="name">Name</label>
  <br>
  <input type="text" name="name" id="name" required>
  <br>
  <label for="antennaName">Antenna Name</label>
  <br>
  <input type="text" name="antennaName" id="antennaName">
  <br>
  <label for="siret">Siret<label>
  <br>
  <input type="text" name="siret">
  <br>
  <label for="apeCode">APE Code</label>
  <br>
  <input type="text" name="apeCode">
  <br><br>
    <input type="submit" value="Submit">
</form>
