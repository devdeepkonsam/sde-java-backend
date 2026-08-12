document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('taskForm');
  if (!form) return;

  form.addEventListener('submit', function(event) {
    event.preventDefault();

    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    const gender = document.querySelector('input[name="gender"]:checked').value;
    const dob = document.getElementById('dob').value;
    const phone = document.getElementById('phone').value;
    const address = document.getElementById('address').value;
    const occupation = document.getElementById('occupation').value;
    const education = document.getElementById('education').value;
    const country = document.getElementById('country').value;
    const role = document.getElementById('role').value;
    const skills = Array.from(document.querySelectorAll('input[name="skills"]:checked')).map(i => i.value);
    const hobbies = Array.from(document.querySelectorAll('input[name="hobbies"]:checked')).map(i => i.value);

    if (!firstName){
      alert('Please enter first name');
      return;
    }

    if (!lastName){
      alert('Please enter last name');
      return;
    }

    if (!email || !email.includes('@')){
      alert('Please enter a valid email');
      return;
    }

    if (password.length < 8) {
      alert('Password must be at least 8 characters');
      return;
    }

    if (password !== confirmPassword) {
      alert('Passwords do not match');
      return;
    }

    if (skills.length === 0) {
      alert('Select at least one skill');
      return;
    }

    const data = {
      firstName,
      lastName,
      username,
      email,
      gender,
      dob,
      phone,
      address,
      occupation,
      education,
      country,
      role,
      skills,
      hobbies
    };

    console.log('Registration data:', data);
    alert('Registration submitted ');
    form.reset();
  });
});
