//Manages proposal data

package com.VMABB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VMABB.model.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}