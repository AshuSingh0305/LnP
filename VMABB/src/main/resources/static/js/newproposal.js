document.addEventListener("DOMContentLoaded", function() {
	const proposalForm = document.getElementById("proposalForm");
	const premiumDisplay = document.getElementById("premiumDisplay");
	const finalSubmitButton = document.getElementById("finalSubmitButton");

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
				const PaymentTenure = parseInt(formData.get("PaymentTenure"));
				data.premium += paymentTenureAdjustment(PaymentTenure);

				// 2. Premium Reduction Based on Payment Mode
				const paymentMode = formData.get("paymentMode");
				data.premium -= paymentModeAdjustment(paymentMode, data.premium);

				// 3. Display Updated Premium
				premiumDisplay.textContent += `\n \n Updated Premium: $${data.premium.toFixed(2)}`;

				// Show the Final Submit button
				finalSubmitButton.style.display = "block";
			} else {
				premiumDisplay.textContent = "Error calculating premium.";
				finalSubmitButton.style.display = "none";
			}
		} catch (error) {
			console.error("Error:", error);
			premiumDisplay.textContent = "Error calculating premium.";
			finalSubmitButton.style.display = "none";
		}
	});

	// Function to calculate Payment Tenure Adjustment
	function paymentTenureAdjustment(PaymentTenure) {
		// Customize this adjustment logic based on requirements
		return PaymentTenure * 5; 
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

	// Add an event listener for the Final Submit button
	finalSubmitButton.addEventListener("click", async function(event) {
		event.preventDefault();

		// Gather user input from the form fields
		const proposalData = {
			proposalName: document.getElementById("proposalName").value,
			age: parseInt(document.getElementById("age").value),
			isSmoker: document.getElementById("isSmoker").checked,
			lifeCoverAmount: parseFloat(document.getElementById("lifeCoverAmount").value),
			annualIncome: parseFloat(document.getElementById("annualIncome").value),
			accidentDeathBenefit: document.getElementById("accidentDeathBenefit").checked,
			accidentDeathCoverage: parseFloat(document.getElementById("accidentDeathCoverage").value),
			comprehensiveCare: document.getElementById("comprehensiveCare").checked,
			comprehensiveCareCoverage: parseFloat(document.getElementById("comprehensiveCareCoverage").value),
			PaymentTenure: parseInt(document.getElementById("PaymentTenure").value),
			city: document.getElementById("city").value,
			qualification: document.getElementById("qualification").value,
			occupation: document.getElementById("occupation").value,
			paymentMode: document.getElementById("paymentMode").value,
			premium: parseFloat(premiumDisplay.textContent.split("$")[1]), // Extract and parse premium value
		};
		console.log(proposalData);

		try {
			// Send the proposal data to your server for processing and database storage
			const response = await fetch("/proposals/create", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(proposalData),
			});

			if (!response.ok) {
				throw new Error(`HTTP error! Status: ${response.status}`);
			}

			const responseData = await response.json();

			// Handle the response 
			if (responseData.proposalId) {
				alert("Proposal submitted successfully with Proposal ID: " + responseData.proposalId);
				
			} else {
				throw new Error("Proposal submission failed.");
			}
		} catch (error) {
			console.error("Error submitting proposal:", error);
			alert("Error submitting proposal. Please try again later.");
		}
		
	});
});
