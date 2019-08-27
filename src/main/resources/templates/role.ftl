<H1>User Create</H1>

<form action="/role/create" method="POST">
  nom du rôle:<br>
  <input type="text" name="role.name">
  <br>
  type de données à faker:<br>
  <input type="number" name="fakeType">
  <br><br>
  borne min:<br>
  <input type="number" name="min">
  <br><br>

  borne max For:<br>
  <input type="number" name="max">
  <br><br>

  nombre d'itérations:<br>
  <input type="number" name="number" >
  <br><br>

  <input type="submit" value="Submit">
</form>
