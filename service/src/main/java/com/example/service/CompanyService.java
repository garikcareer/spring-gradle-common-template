package com.example.service;

import com.example.data.entity.Company;
import java.util.List;

public interface CompanyService {
    void addCompany(Company company);

    Company getCompanyById(Long companyId);

    List<Company> getCompanies();

    /**
     *
     * @param companyId
     * @param company
     */
    void updateCompany(Long companyId, Company company);

    /**
     * Deletes a company from the system based on the given company ID.
     *
     * @param companyId the unique identifier of the company to be deleted
     */
    void deleteCompanyById(Long companyId);
    
    
}
