document.addEventListener("DOMContentLoaded", function() {

	console.log("JavaScript file loaded.");



	// Function to handle clicking on links in the admin dashboard

	function handleDashboardLinks() {

		// Get references to the dashboard links

		const pendingLink = document.getElementById("pendingLink");

		const approvedLink = document.getElementById("approvedLink");

		const rejectedLink = document.getElementById("rejectedLink");



		// Add click event listeners to the links

		pendingLink.addEventListener("click", function() {

			// Redirect to the pending policies page

			window.location.href = "/AdminDashboard/pendingPolicies";

		});



		approvedLink.addEventListener("click", function() {

			// Redirect to the approved policies page

			window.location.href = "/AdminDashboard/approvedPolicies";

		});



		rejectedLink.addEventListener("click", function() {

			// Redirect to the rejected policies page

			window.location.href = "/AdminDashboard/rejectedPolicies";

		});
	}
	// Call the function to set up the behavior

	handleDashboardLinks();



	// Function to handle changing the status of a policy

	function changeStatus(proposalId, newStatus) {

		// Send an AJAX request to update the policy status

		fetch(`/AdminDashboard/pendingPolicies/${proposalId}?status=${newStatus}`, {

			method: 'POST'

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

					// Reload the page to reflect the updated status

					location.reload();

				} else {

					console.error('Failed to update status');

				}

			})

			.catch(error => {

				console.error('Error updating status:', error);

			});

	}

});