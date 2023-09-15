document.addEventListener("DOMContentLoaded", function () {
    console.log("JavaScript file loaded.");

    // Function to handle clicking on links in the admin dashboard
    function handleDashboardLinks() {
        // Get references to the dashboard links
        const pendingLink = document.getElementById("pendingLink");
        const approvedLink = document.getElementById("approvedLink");
        const rejectedLink = document.getElementById("rejectedLink");

        // Add click event listeners to the links
        pendingLink.addEventListener("click", function () {
            // Redirect to the pending policies page
            window.location.href = "/AdminDashboard/pendingPolicies";
        });

        approvedLink.addEventListener("click", function () {
            // Redirect to the approved policies page
            window.location.href = "/AdminDashboard/approvedPolicies";
        });

        rejectedLink.addEventListener("click", function () {
            // Redirect to the rejected policies page
            window.location.href = "/AdminDashboard/rejectedPolicies";
        });
    }

    // Call the function to set up the behavior
    handleDashboardLinks();

    // Function to handle changing the status of a policy
    function changeStatus(proposalId, newStatus) {
        // Send an AJAX request to update the policy status
        fetch(`/AdminDashboard/pendingPolicies/changeStatus/${proposalId}?status=${newStatus}`, {
            method: 'POST',
        })
            .then(response => {
                if (response.status === 200) {
                    return response.json(); // Parse the response JSON
                } else {
                    console.error('Failed to update status');
                }
            })
            .then(data => {
                // Check if the status was updated successfully
                if (data && data.success) {
                    // Update the frontend with the new policy ID
                    const policyIdElement = document.getElementById(`policyId_${proposalId}`);
                    if (policyIdElement) {
                        policyIdElement.textContent = data.newPolicyId; // Update the content with the new policy ID
                    }
                } else {
                    console.error('Failed to update status');
                }
            })
            .catch(error => {
                console.error('Error updating status:', error);
            });
    }

    // Function to set up event listeners for approve buttons
    function setupEventListeners() {
        // Get references to the approve buttons on both pages
        const approveButtons = document.querySelectorAll('.approve-button');

        // Add click event listeners to the approve buttons
        approveButtons.forEach(button => {
            button.addEventListener('click', function () {
                const proposalId = button.getAttribute('data-proposal-id');
                changeStatus(proposalId, 'approved');
            });
        });
    }

    // Call the function to set up event listeners for approve buttons
    setupEventListeners();
});
