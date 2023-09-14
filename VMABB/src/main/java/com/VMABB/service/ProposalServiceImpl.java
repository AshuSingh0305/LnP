package com.VMABB.service;

import com.VMABB.model.Proposal;
import com.VMABB.repository.ProposalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;

    @Autowired
    public ProposalServiceImpl(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @Override
    public void saveProposal(Proposal proposal) {
        proposalRepository.save(proposal);
    }

    @Override
    public Optional<Proposal> getProposalById(Long id) {
        return proposalRepository.findById(id);
    }

    @Override
    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    @Override
    public void updateProposal(Proposal proposal) {
        proposalRepository.save(proposal);
    }

    @Override
    public void deleteProposal(Long id) {
        proposalRepository.deleteById(id);
    }
}
