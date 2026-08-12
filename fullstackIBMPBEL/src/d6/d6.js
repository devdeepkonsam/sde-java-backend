document.addEventListener('DOMContentLoaded', () => {
	const form = document.getElementById('emp');
	if (!form) return;

	form.addEventListener('submit', function (event) {
		event.preventDefault();

		const name = document.getElementById('name').value;
		const email = document.getElementById('email').value;
		const password = document.getElementById('password').value;

		if (name === '') {
			alert('Please enter name');
			return;
		}

		if (!email.includes('@')) {
			alert('Please enter valid email');
			return;
		}

		if (password.length < 8) {
			alert('Please write password of minimum 8 characters');
			return;
		}

		console.log('Form submitted', { name, email });
		alert('Form submitted successfully (demo)');
		form.reset();
	});
});

