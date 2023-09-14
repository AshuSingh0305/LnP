// JavaScript code for client dashboard functionality

// Mock data for existing policies (replace with actual data from your backend)
const policies = [
    { id: 1, type: 'Term Insurance', holder: 'John Doe' },
    { id: 2, type: 'Whole Life', holder: 'Jane Smith' },
    { id: 3, type: 'Moneyback', holder: 'Bob Johnson' },
];

// Function to populate the policy list based on the selected policy type
function populatePolicyList(selectedType) {
    const policyList = document.getElementById('policyList');
    policyList.innerHTML = ''; // Clear previous entries

    // Filter policies based on the selected type
    const filteredPolicies = policies.filter(policy => policy.getToi === selectedType);

    if (filteredPolicies.length === 0) {
        policyList.innerHTML = '<li>No policies found for the selected type.</li>';
    } else {
        filteredPolicies.forEach(policy => {
            const listItem = document.createElement('li');
           listItem.textContent = `${policy.getToi()} Policy - Holder: ${policy.getName()}`;
            policyList.appendChild(listItem);
        });
    }
}

// Event listener for the policy type dropdown
document.getElementById('policyTypeInput').addEventListener('change', function () {
    const selectedType = this.value;
    populatePolicyList(selectedType);
});

// Event listener for the form submission
document.getElementById('addPolicyForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent the form from submitting the traditional way

    const policyTypeInput = document.getElementById('policyTypeInput');
    const holderNameInput = document.getElementById('holderNameInput');

    const selectedType = policyTypeInput.value;
    const holderName = holderNameInput.value;

    // Log the selectedType and holderName
    console.log('Selected Policy Type:', selectedType);
    console.log('Holder Name:', holderName);

    // Create a new policy object
    const newPolicy = { id: policies.length + 1, type: selectedType, holder: holderName };

    // Log the new policy
    console.log('New Policy:', newPolicy);

    // Add the new policy to the policies array (replace mock data)
    policies.push(newPolicy);

    // Log the updated policies array
    console.log('Updated Policies:', policies);

    // Populate the policy list again with the updated data
    populatePolicyList(selectedType);
    
    const policyList = document.getElementById('policyList');
    const listItem = document.createElement('li');
    listItem.textContent = `${newPolicy.type} Policy - Holder: ${newPolicy.holder}`;
    policyList.appendChild(listItem);

    // Clear the form inputs
    policyTypeInput.value = '';
    holderNameInput.value = '';
});


// Initial population of policy list with the default selected type
const initialSelectedType = document.getElementById('policyTypeInput').value;
populatePolicyList(initialSelectedType);
