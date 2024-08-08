// auth.js
import { CookieManager } from './CookieManager.js';

export async function loginRequest(event) {
  const url = 'http://localhost:8080/api/v1/auth/login';

  event.preventDefault();

  const userName = document.getElementById('inputUserName').value;
  const password = document.getElementById('inputPassword').value;

  const formObject = {
    userName,
    password,
  };

  console.log(formObject);

  try {
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formObject),
    });

    if (!response.ok) {
      throw new Error(`Response status: ${response.status}`);
    }

    const responseData = await response.json();

    const sessionToken = responseData.token;
    CookieManager.create('sessionToken', sessionToken, 7); // Corretto l'uso di CookieManager.create
    console.log('Session token saved:', sessionToken);
    location.href = '/html/dashboard.html';
  } catch (error) {
    console.error('Error:', error);
  }
}

export function logoutRequest() {
  CookieManager.erase('sessionToken');
  console.log('Session token erased!');
  location.href = '/html/login.html';
}

// Assicurati che il DOM sia caricato prima di accedere agli elementi
document.addEventListener('DOMContentLoaded', () => {
  console.log('auth.js loaded...');

  const loginForm = document.getElementById('loginForm');
  if (loginForm) {
    console.log('Login form ready!');
    loginForm.addEventListener('submit', loginRequest);
  }

  window.logoutRequest = logoutRequest;
});
