package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.CompanyDao;
import peaksoft.model.Company;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceCompanyImpl implements ServiceCompany{

    private final CompanyDao companyDao;

    @Autowired
    public ServiceCompanyImpl(CompanyDao companyDao){
        this.companyDao = companyDao;
    }

    @Override
    public Company saveCompany(Company company){
        return companyDao.saveCompany(company);
    }

    @Override
    public List<Company> getAllCompanies(){
        return companyDao.getAllCompanies();
    }

    @Override
    public Company getByIdCompany(Long id){
        return companyDao.getByIdCompany(id);
    }

    @Override
    public void updateCompany(Company company, Long id){
        companyDao.updateCompany(company, id);
    }

    @Override
    public void deleteCompany(Long id){
        companyDao.deleteCompany(id);
    }








}
