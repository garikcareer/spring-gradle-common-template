package com.example.service;

import com.example.data.entity.Company;
import java.util.List;

public interface CompanyService {
    void addCompany(Company company);

    Company getCompanyById(Long companyId);

    List<Company> getCompanies();

  /**
   * Updates the company information based on the provided company ID and new company data.
   *
   * @param companyId the unique identifier of the company to be updated
   * @param company the new company information containing updated name and location
   */
  void updateCompany(Long companyId, Company company);

    /**
     * Deletes a company from the system based on the given company ID.
     *
     * @param companyId the unique identifier of the company to be deleted
     */
    void deleteCompanyById(Long companyId);
    
    
}
