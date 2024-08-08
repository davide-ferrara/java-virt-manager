export class Backend {
  constructor(hostname) {
    this.hostname = hostname;
  }

  async signupstudent(event) {
    const url = 'http://localhost:8080/api/signup/student';

    event.preventDefault(); // Prevent the default form submission

    const name = document.getElementById('inputName').value;
    const lastname = document.getElementById('inputLastname').value;
    const dateOfBirth = document.getElementById('inputDateOfBirth').value;
    const studentID = document.getElementById('inputstudentID').value;
    const userName = document.getElementById('inputUserName').value;
    const email = document.getElementById('inputEmail').value;
    const password = document.getElementById('inputPassword').value;

    const formObject = {
      name,
      lastname,
      dateOfBirth,
      studentID,
      userName,
      email,
      password,
    };

    try {
      const response = await fetch(url, {
        method: 'POST', // Use POST method
        headers: {
          'Content-Type': 'application/json', // Indicate the content type
        },
        body: JSON.stringify(formObject), // Convert the formObject to JSON
      });

      if (!response.ok) {
        throw new Error(`Response status: ${response.status}`);
      }
      console.log('Form submitted with:', formObject);
    } catch (error) {
      console.error('Error:', error);
    }
  }

  async testConnection(id) {
    const endPoint = '/API/test';

    const url = this.hostname + endPoint;

    try {
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error(`Response status: ${response.status}`);
      }

      const json = await response.json();

      let datetime = document.getElementById(id);
      datetime.textContent = json.current_time;
    } catch (error) {
      throw new Error(error);
    }
  }
}
