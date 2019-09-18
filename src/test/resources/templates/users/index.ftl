<h1>User form</h1>

<form method="POST" action="/api/users">
  <label for="firstname">Firstname</label>
  <br>
  <input type="text" name="firstname" id="firstname" required>
  <br>
  <label for="lastname">Lastname</label>
  <br>
  <input type="text" name="lastname" id="lastname" required>
  <br>
  <label for="email">Email</label>
  <br>
  <input type="email" name="email" id="email" required>
  <br>
  <label for="cellPhone">Cell phone</label>
  <br>
  <input type="text" name="cellPhone" id="cellPhone">
  <br>
  <label for="homePhone">Home Phone</label>
  <br>
  <input type="text" name="homePhone" id="homePhone">
  <br>
   <label for="login">Login</label>
  <br>
  <input type="text" name="login" id="login" required>
  <br>
  <label for="password">Password</label>
  <br>
  <input type="password" name="password" id="password" required>
  <br>
  <label for="role">Role</label>
  <br>
  <select name="role" required>
    <option value="ROLE_1">1</option>
    <option value="ROLE_2">2</option>
    <option value="ROLE_3">3</option>
  </select>
  <br><br>
  <input type="submit" value="Submit">
</form>
