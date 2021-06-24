var users = []
submitBtn.addEventListener('click', () => {
	var username = document.querySelector("#username")
	var password = document.querySelector("#password")
	
	if (username.value == '' || password.value == '') {
		alert("Please register a valid username and password")
	} else {
		console.log("Inputs look valid, proceed with form submission")
		var user = {
			"username" : username.value,
			"password" : password.value
		}
		
		users.push(user);
	}
})
username.addEventListener('focus', () => {
	var username = document.querySelector("#username")
	var password = document.querySelector("#password")

	var user = {
		"username": username.value,
		"password": password.value
	}
	fetch(`http://localhost:8080/users/exists`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(user)
	})
	.then((response) => response.json())
	.then((data) => {
		console.log(data)
	})
})