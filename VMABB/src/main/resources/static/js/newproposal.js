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

				// Additional functionalities:
				// 1. Payment Tenure Adjustment
				const PaymentTenure = parseInt(document.getElementById("PaymentTenure").value);
				data.premium += paymentTenureAdjustment(PaymentTenure);

				// 2. Premium Reduction Based on Payment Mode
				const paymentMode = document.getElementById("paymentMode").value;
				data.premium -= paymentModeAdjustment(paymentMode, data.premium);

				// 3. Display Updated Premium
				premiumDisplay.textContent += `\nUpdated Premium: $${data.premium.toFixed(2)}`;
			} else {
				// Handle errors or invalid responses from the backend
				premiumDisplay.textContent = "Error calculating premium.";
			}
		} catch (error) {
			console.error("Error:", error);
			premiumDisplay.textContent = "Error calculating premium.";
		}
	});

	// Function to calculate Payment Tenure Adjustment
	function paymentTenureAdjustment(PaymentTenure) {
		// Customize this adjustment logic based on your requirements
		return PaymentTenure * 5; // Example adjustment
	}

	// Function to calculate Premium Reduction Based on Payment Mode
	function paymentModeAdjustment(paymentMode, premium) {
		if (paymentMode === "half-yearly") {
			return premium * 0.1; // 10% reduction for half-yearly
		} else if (paymentMode === "annual") {
			return premium * 0.15; // 15% reduction for annual
		} else {
			return 0; // No reduction for monthly
		}
	}
});
