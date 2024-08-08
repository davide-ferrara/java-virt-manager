import { CookieManager } from './CookieManager.js';

console.log('dashboard.js loaded...');

async function listVmByID(id) {
  const url = `http://localhost:8080/api/v1/userById?id=${id}`;

  try {
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error(`Response status: ${response.status}`);
    }

    const json = await response.json();

    vmListBody = document.getElementById('vmListBody');
    vmListBody.innerHTML = json[0].userName + ' ' + json[0].email;

    console.log(json);
  } catch (error) {
    throw new Error(error);
  }
}

listVmByID(CookieManager.read('sessionToken'));
