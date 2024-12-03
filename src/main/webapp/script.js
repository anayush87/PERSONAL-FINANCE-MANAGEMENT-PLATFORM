// Switching forms
function switchToSignup() {
    document.getElementById('login-form').classList.add('hidden');
    document.getElementById('signup-form').classList.remove('hidden');
}

function switchToLogin() {
    document.getElementById('signup-form').classList.add('hidden');
    document.getElementById('login-form').classList.remove('hidden');
}

// Mock login
function login() {
    const email = document.getElementById('login-email').value;
    const password = document.getElementById('login-password').value;

    if (email === "test@gmail.com" && password === "123") {
        window.location.href = "dashboard.html";
    } else {
        alert("Invalid login credentials");
    }
}

// Mock signup
function signup() {
    const email = document.getElementById('signup-email').value;
    const password = document.getElementById('signup-password').value;

    if (email && password) {
        alert("Account created successfully!");
        switchToLogin();
    } else {
        alert("Please fill in all fields");
    }
}

// Logout
function logout() {
    alert("Logged out successfully");
    window.location.href = "index.html";
}
