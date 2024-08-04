import { Backend } from './backend.js';

function main() {
  console.log('Main.js loaded...');

  // Create an instance of Backend and make it globally accessible
  window.backend = new Backend('http://localhost:8080');

  // Attach event listener to the form
  const form = document.getElementById('signupForm');
  form.addEventListener('submit', backend.signUpFormSubmit);
}

document.addEventListener('DOMContentLoaded', main);
