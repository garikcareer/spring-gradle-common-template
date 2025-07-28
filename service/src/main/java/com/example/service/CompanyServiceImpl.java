package com.example.service;

import com.example.data.entity.Company;
import com.example.data.repository.CompanyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
  private final CompanyRepository companyRepository;

  @Autowired
  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  // Create
  @Override
  public void addCompany(Company company) {
    companyRepository.save(company);
  }

  // Read
  @Override
  @Transactional(readOnly = true)
  public Company getCompanyById(Long companyId) {
    return companyRepository
        .findById(companyId)
        .orElseThrow(() -> new EmptyResultDataAccessException("Company not found with id: ", Math.toIntExact(companyId)));
  }

  @Override
  @Transactional(readOnly = true)
  public List<Company> getCompanies() {
    return (List<Company>) companyRepository.findAll();
  }

  // Update
  @Override
  public void updateCompany(Long companyId, Company company) {
    Company existingCompany =
        companyRepository
            .findById(companyId)
            .orElseThrow(
                () -> new EmptyResultDataAccessException("Company not found with id: ", Math.toIntExact(companyId)));
    existingCompany.setName(company.getName());
    existingCompany.setLocation(company.getLocation());
    companyRepository.save(existingCompany);
  }

  // Delete
  @Override
  public void deleteCompanyById(Long companyId) {
    if (!companyRepository.existsById(companyId)) {
      throw new EmptyResultDataAccessException("Company not found with id: ", Math.toIntExact(companyId));
    }
    companyRepository.deleteById(companyId);
  }
}
