<H1>Feedback Creation</H1>

<form action="/api/feedbacks" method="POST">
    <label for="typeOfContract">Contract Type</label>
    <input type="text" name="typeOfContract">
    <br>
    <label for="durationOfContract">Contract Duration</label>
    <input type="number" name="durationOfContract" min="0" max="36">
    <br>
    <label for="comment">Comment</label>
    <input type="text" name="comment">
    <br><br>
    <input type="submit" value="Submit">
</form>
