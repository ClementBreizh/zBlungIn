<H1>User Create</H1>

<form action="/customs/users/createRich" method="POST">
  First name:<br>
  <input type="text" name="user.firstname" value="Mickey">
  <br>
  Last name:<br>
  <input type="text" name="user.lastname" value="Mouse">
  <br><br>
  DateOfBirth:<br>
  <input type="date" name="user.dateOfBirth" value="">
  <br><br>

  Created For:<br>
  <input type="date" name="createdFor" value="">
  <br><br>

  Number Item:<br>
  <input type="number" name="numberItem" value="10">
  <br><br>

  <input type="submit" value="Submit">
</form>
