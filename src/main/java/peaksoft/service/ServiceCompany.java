package peaksoft.service;

import peaksoft.model.Company;

import java.util.List;

public interface ServiceCompany {

    Company saveCompany(Company company);

    List<Company> getAllCompanies();

    Company getByIdCompany(Long id);

    void updateCompany(Company company, Long id);

    void deleteCompany(Long id);

}
