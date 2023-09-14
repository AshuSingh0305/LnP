//Manages insurance proposals

package com.VMABB.service;

import com.VMABB.model.Proposal;

import java.util.List;
import java.util.Optional;

public interface ProposalService {

    // Save a new proposal to the database
    void saveProposal(Proposal proposal);

    // Retrieve a proposal by its ID
    Optional<Proposal> getProposalById(Long id);

    // Retrieve all proposals from the database
    List<Proposal> getAllProposals();

    // Update an existing proposal
    void updateProposal(Proposal proposal);

    // Delete a proposal by its ID
    void deleteProposal(Long id);
}

