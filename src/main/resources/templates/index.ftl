<H1>User Create</H1>

<form action="/customs/users/create" method="POST">
  First name:<br>
  <input type="text" name="firstname" value="Mickey">
  <br>
  Last name:<br>
  <input type="text" name="lastname" value="Mouse">
  <br><br>
  DateOfBirth:<br>
  <input type="date" name="dateOfBirth" value="">
  <br><br>
  Role name:<br>
  <input type="text" name="role.name" value="Role1">
  <br><br>

  Entreprise nom:<br>
  <input type="text" name="entreprise.nom" value="nom1">
  <br><br>
  Entreprise adresse:<br>
  <input type="text" name="entreprise.adresse" value="add1">
  <br><br>
  Entreprise type:<br>
  <input type="text" name="entreprise.type" value="t1">
  <br><br>

  <input type="submit" value="Submit">
</form>
