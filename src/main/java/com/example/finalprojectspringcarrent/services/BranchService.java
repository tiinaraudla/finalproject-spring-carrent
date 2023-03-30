package com.example.finalprojectspringcarrent.services;

import com.example.finalprojectspringcarrent.exceptions.BranchNotFoundException;
import com.example.finalprojectspringcarrent.models.Branch;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */

public interface BranchService {
    /**
     * To create a new branch
     *
     * @param branch Branch
     */
    void createBranch(Branch branch);

    /**
     * To find a branch by ID
     *
     * @param id Branch ID
     * @return Branch
     */
    Branch findBranchById(Long id) throws BranchNotFoundException;

    /**
     * To find a Branch by address
     *
     * @param address Branch address
     * @return Branch
     */
    Branch findBranchByAddress(String address) throws BranchNotFoundException;

    /**
     * To find all branches
     *
     * @return a list of Branches
     */
    List<Branch> findAllBranches();

    /**
     * To update an existing Branch
     *
     * @param branch Branch
     */
    void updateBranch(Branch branch) throws BranchNotFoundException;

    /**
     * To delete a Branch by ID
     *
     * @param id Branch ID
     */
    void deleteBranchById(Long id) throws BranchNotFoundException;

    /**
     * To restore a Branch by ID
     *
     * @param id Branch ID
     */
    void restoreBranchById(Long id) throws BranchNotFoundException;
}
