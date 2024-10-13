<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        /* Custom styling for modal */
        .w3-modal-content {
            max-width: 600px;
            margin: auto;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            background-color: #f9f9f9;
        }
        .w3-modal-content header {
            background-color: #008080;
            color: white;
            padding: 10px;
            text-align: center;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
        .w3-modal-content footer {
            background-color: #008080;
            color: white;
            text-align: center;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
        }
        .w3-modal-content .w3-container {
            padding: 20px;
        }
        .w3-modal-content .w3-button {
            margin-top: 20px;
        }
        .w3-button.w3-yellow {
            background-color:blue;
        }
        .w3-button.w3-yellow:hover {
            background-color: #e6b800;
        }
        /* Style for the close button (top-right corner) */
        .w3-display-topright {
            color: white;
            font-size: 24px;
            cursor: pointer;
        }
        /* General page styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }
        h2 {
            color: #333;
            text-align: center;
            padding: 20px;
        }
        form {
            text-align: center;
            margin: 20px auto;
            max-width: 400px;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        form label, form input, form select {
            display: block;
            width: 100%;
            margin-bottom: 10px;
            font-size: 16px;
        }
        form button {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<h2>Forgot Password</h2>

<!-- Form to input role and username -->
<form method="post" action="forgotpassword">
    <label for="role">Role:</label>
    <select id="role" name="role" required>
        <option value="STUDENT">Student</option>
        <option value="LECTURER">Lecturer</option>
        <option value="REGISTRAR">Registrar</option>
        <option value="HOD">Head of Department</option>
    </select><br><br>
    
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>
    
    <button type="submit" class="w3-button w3-blue">Retrieve Password</button>
</form>

<!-- Error message display if credentials are invalid -->
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<% if (errorMessage != null) { %>
    <p style="color:red;"><%= errorMessage %></p>
<% } %>

<!-- Modal Structure to show password -->
<% String username = (String) request.getAttribute("username"); %>
<% String password = (String) request.getAttribute("password"); %>
<% if (username != null && password != null) { %>
    <button onclick="document.getElementById('forgotPasswordModal').style.display='block'" class="w3-button w3-green">Show Credentials</button>
    
    <div id="forgotPasswordModal" class="w3-modal" style="display: block;">
        <div class="w3-modal-content w3-animate-opacity w3-card-4">
            <header class="w3-container">
                <span onclick="document.getElementById('forgotPasswordModal').style.display='none'"
                      class="w3-button w3-display-topright">&times;</span>
                <h2>Your Credentials</h2>
            </header>
            <div class="w3-container">
                <p><strong>Username:</strong> <span id="modalUsername"><%= username %></span></p>
                <p><strong>Password:</strong> <span id="modalPassword"><%= password %></span></p>
            </div>
            <footer class="w3-container">
                <p>Close this modal after viewing your credentials.</p>
                <!-- Add return to login button in modal -->
                <a href="login.html" class="w3-button w3-yellow">Return to Login</a>
            </footer>
        </div>
    </div>
<% } %>

<!-- Return to login button outside modal -->
<a href="login.html" class="w3-button w3-yellow" style="margin-top: 20px;">Return to Login</a>

</body>
</html>
