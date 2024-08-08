import { CookieManager } from './CookieManager.js';
import { Backend } from './backend.js';

function main() {
  console.log('Main.js loaded...');

  // Create an instance of Backend and make it globally accessible
  window.backend = new Backend('http://localhost:8080');

  // Attach event listener to the form
  //const form = document.getElementById('signupForm');
  //form.addEventListener('submit', backend.signupstudent);

  // Attach event listener to the form
  const loginForm = document.getElementById('loginForm');
  if (loginForm) {
    console.log('Login form ready!');
    loginForm.addEventListener('submit', backend.loginRequest);
  }
}

document.addEventListener('DOMContentLoaded', main);
