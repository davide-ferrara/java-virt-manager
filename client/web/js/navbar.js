import { CookieManager } from './CookieManager.js';

document.addEventListener('DOMContentLoaded', () => {
  console.log('navbar.js loaded...');

  $('#navbar').load('../html/navbar.html', function () {
    const loginBtn = document.getElementById('loginBtn');

    if (!loginBtn) {
      console.error("Elemento con ID 'loginBtn' non trovato.");
      return;
    }

    const sessionToken = CookieManager.read('sessionToken');

    if (sessionToken) {
      loginBtn.innerHTML = 'My Profile';
      loginBtn.classList.remove('btn-primary');
      loginBtn.classList.add('btn-dark');
      loginBtn.onclick = () => {
        location.href = '/html/profile.html';
      };
    } else {
      loginBtn.onclick = () => {
        location.href = '/html/login.html';
      };
    }
  });
});
