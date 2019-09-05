<h1>Candidate form</h1>

<form method="POST" action="/api/candidates">
  <label for="firstname">Firstname</label>
  <br>
  <input type="text" name="firstname" id="firstname">
  <br>
  <label for="lastname">Lastname</label>
  <br>
  <input type="text" name="lastname" id="lastname">
  <br>
  <label for="email">Email</label>
  <br>
  <input type="email" name="email" id="email">
  <br>
  <label for="cellPhone">Cell phone</label>
  <br>
  <input type="text" name="cellPhone" id="cellPhone">
  <br>
  <label for="homePhone">Home Phone</label>
  <br>
  <input type="text" name="homePhone" id="homePhone">
  <br>
  <label for="commentary">Commentary</label>
  <br>
  <textarea name="commentary" id="commentary"></textarea>
  <br>
  <label for="mainContact">Main contact</label>
  <br>
  <input type="checkbox" name="mainContact" id="mainContact" value="true">
  <br>
  <label for="address">Address</label>
  <br>
  <input type="number" name="address" id="address">
  <br>
  <label for="ranking">Ranking</label>
  <br>
  <select name="ranking" id="ranking">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  </select>
  <br>
  <label for="feedback">Feedback</label>
  <br>
  <input type="number" name="feedback" id="feedback">
  <br>
  <label for="degrees">Degrees</label>
  <br>
  <input type="number" name="degrees" id="degrees">
  <br>
  <label for="matters">Matters</label>
  <br>
  <input type="number" name="matters" id="matters">
  <br>
  <label for="sessions">Sessions</label>
  <br>
  <input type="number" name="sessions" id="sessions">
  <br><br>
  <input type="submit" value="Submit">
</form>
