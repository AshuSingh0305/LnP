document.addEventListener("DOMContentLoaded", function() {
	const proposalForm = document.getElementById("proposalForm");
	const premiumDisplay = document.getElementById("premiumDisplay");

	proposalForm.addEventListener("submit", async function(event) {
		event.preventDefault();

		try {
			// Collect user input from the form
			const formData = new FormData(proposalForm);

			// Send user input to the backend for premium calculation
			const response = await fetch("/calculate-premium", {
				method: "POST",
				body: formData,
			});

			if (!response.ok) {
				throw new Error(`HTTP error! Status: ${response.status}`);
			}

			const data = await response.json();

			if (data.premium !== undefined) {
				// Display the calculated premium
				premiumDisplay.textContent = `Initial Premium: $${data.premium.toFixed(2)}`;
			} else {
				// Handle errors or invalid responses from the backend
				premiumDisplay.textContent = "Error calculating premium.";
			}
		} catch (error) {
			console.error("Error:", error);
			premiumDisplay.textContent = "Error calculating premium.";
		}
	});
});
