<H1>Feedback Creation</H1>

<form action="/api/feedbacks" method="POST">
    <label for="typeOfContract">Contract Type</label>
    <br>
    <input type="text" name="typeOfContract" id="typeOfContract" required>
    <br>
    <label for="durationOfContract">Contract Duration</label>
    <br>
    <input type="number" name="durationOfContract" min="0" max="36" id="durationOfContract">
    <br>
    <label for="comment">Comment</label>
    <br>
    <input type="text" name="comment" id="comment">
    <br><br>
    <input type="submit" value="Submit">
</form>
