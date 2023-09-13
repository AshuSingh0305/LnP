document.addEventListener("DOMContentLoaded", function () {
    const proposalForm = document.getElementById("proposalForm");
    const premiumDisplay = document.getElementById("premiumDisplay");

    proposalForm.addEventListener("submit", function (event) {
        event.preventDefault();
        // Collect user input from the form
        const firstName = document.getElementById("firstName").value;
        const lastName = document.getElementById("lastName").value;
        const dob = document.getElementById("dob").value;
        const email = document.getElementById("email").value;
        const mobile = document.getElementById("mobile").value;
        const gender = document.getElementById("gender").value;
        const tobacco = document.querySelector('input[name="tobacco"]:checked').value;
        const annualIncome = parseFloat(document.getElementById("annualIncome").value);
        const lifeCoverAmount = parseFloat(document.getElementById("lifeCoverAmount").value);
        const lifeCoverAge = parseInt(document.getElementById("lifeCoverAge").value);

        // Make an API call to the backend to calculate premium
        // Replace the following with actual API call logic
        const calculatedPremium = calculatePremium(
            firstName,
            lastName,
            dob,
            email,
            mobile,
            gender,
            tobacco,
            annualIncome,
            lifeCoverAmount,
            lifeCoverAge
        );
        
        // Display the calculated premium
        premiumDisplay.textContent = `Initial Premium: $${calculatedPremium.toFixed(2)}`;
    });

    // Function to simulate premium calculation (replace with actual logic)
    function calculatePremium(
        firstName,
        lastName,
        dob,
        email,
        mobile,
        gender,
        tobacco,
        annualIncome,
        lifeCoverAmount,
        lifeCoverAge
    ) {
        // Simulated premium calculation logic
        // Replace this with your actual premium calculation algorithm
        let basePremium = 100; // Initial premium
        // Additional premium calculations based on user input go here

        // Example: Additional premium for smokers
        if (tobacco === "yes") {
            basePremium += 50;
        }

        // Example: Premium based on age (adjust as per your requirements)
        if (lifeCoverAge < 30) {
            basePremium += 30;
        } else if (lifeCoverAge >= 30 && lifeCoverAge <= 50) {
            basePremium += 50;
        } else {
            basePremium += 70;
        }

        // Example: Premium based on annual income (adjust as per your requirements)
        if (annualIncome > 50000) {
            basePremium += 20;
        }

        // Example: Premium based on gender (adjust as per your requirements)
        if (gender === "female") {
            basePremium -= 10;
        }

        return basePremium;
    }
});
