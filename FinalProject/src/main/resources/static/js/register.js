var usernameTextbox = document.querySelector('#username')
var eyeIcons = document.querySelectorAll('.fa-eye')

eyeIcons.forEach( (eyeIcon) => {
	eyeIcon.addEventListener('click', () => {
		if (eyeIcon.classList.contains('fa-eye')) {
			eyeIcon.classList.replace('fa-eye', 'fa-eye-slash')
			if (eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
				document.querySelector("#password").type = 'text'
			} else {
				document.querySelector("#confirmPassword").type = 'text'
			}
		} else {
			eyeIcon.classList.replace('fa-eye-slash', 'fa-eye')
			if (eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
				document.querySelector("#password").type = 'password'
			} else {
				document.querySelector("#confirmPassword").type = 'password'
			}
		}
	})
})

// this is for demonstration purposes
function myPromise () {
	return new Promise( (resolve, reject) => {
		let i = 1
		
		if (i === 1) {
			resolve("hey, i === 1, so we're cool!")
		} else {
			reject("Absolute fail. i is not 1, booooo")
		}
		
	})
}

usernameTextbox.addEventListener('blur', () => {
	var user = {
			'username': usernameTextbox.value,
	}
	fetch('/users/exists', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
	})
	.then( (responseEntity) => responseEntity.json() )
	.then( (data) => {
		if (data === true) {
			// this users already exists!
			console.log("username already exists")
			usernameTextbox.focus()
			usernameTextbox.select()
			showErrorAnimation().then((message) => {
				// animation is completed at this point
				console.log("We're now in the callback function")
				console.log(message)
				usernameTextbox.style.backgroundColor = 'rgb(255,255,255)'
			})
		}
	})
})
function showErrorAnimation () {
	return new Promise( (resolve, reject) => {
		console.log("We're in the showErrorAnimation function")
		var i = 0
		
		var animationInterval = setInterval(() => {
			i++
			usernameTextbox.style.backgroundColor = `rgb(${i}, 0, 0)`
				if (i >= 255) {
					clearInterval(animationInterval);
					resolve("Done executing animation code")
				}
		}, 1)
	}
)}