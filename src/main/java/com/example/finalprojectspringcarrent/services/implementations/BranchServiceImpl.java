package com.example.finalprojectspringcarrent.services.implementations;

import com.example.finalprojectspringcarrent.exceptions.BranchNotFoundException;
import com.example.finalprojectspringcarrent.models.Branch;
import com.example.finalprojectspringcarrent.services.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */
@Service
public class BranchServiceImpl implements BranchService {
    @Override
    public void createBranch(Branch branch) {

    }

    @Override
    public Branch findBranchById(Long id) throws BranchNotFoundException {
        return null;
    }

    @Override
    public Branch findBranchByAddress(String address) throws BranchNotFoundException {
        return null;
    }

    @Override
    public List<Branch> findAllBranches() {
        return null;
    }

    @Override
    public void updateBranch(Branch branch) throws BranchNotFoundException {

    }

    @Override
    public void deleteBranchById(Long id) throws BranchNotFoundException {

    }

    @Override
    public void restoreBranchById(Long id) throws BranchNotFoundException {

    }
}
