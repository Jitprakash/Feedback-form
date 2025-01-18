<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
    <div class="container">
    <h1>&quotWe all need people who will give us feedback. That&apos;s how we improve.&quot</h1>
    <form action ="<%= application.getContextPath()%>/FeedbackServlet" method ="post" class="feedback-form">
      <label for="email" id="mail-label">Enter your email:</label>
      <input type="email" name="email" id="email"/ required>
      <label for="message">Enter your feedback:</label>
      <textarea name="message" id="message" required></textarea>
       <div class="btn">
        <button type="submit"><strong>SUBMIT</strong></button>
        <button type="reset"><strong>RESET</strong></button>
       </div>
    </form>
    </div>
</body>
</html>