package com.sparta.trainingdatabase.model.dao;

import com.sparta.trainingdatabase.model.dto.CompanyDto;
import com.sparta.trainingdatabase.model.entity.company.Company;
import com.sparta.trainingdatabase.model.repository.CompanyRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyDao {

    private final CompanyRepository repository;

    public CompanyDao(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<CompanyDto> findAll() {
        List<Company> companies = repository.findAll();
        List<CompanyDto> convertedCompanies = new ArrayList();
        for (Company company : companies) {
            convertedCompanies.add(convert(company));
        }
        return convertedCompanies;
    }

    public CompanyDto findByid(String id) {
        Optional<Company> foundCompany = repository.findById(new ObjectId(id));
        if (foundCompany.isPresent()) {
            return convert(foundCompany.get());
        }
        return nullReturn();
    }

    public CompanyDto save(CompanyDto companyDto) {
        Company companyToSave = convertDto(companyDto);
        repository.save(companyToSave);
        return companyDto;
    }

    public CompanyDto update(CompanyDto companyDto) {
        Optional<Company> foundCompany = repository.findById(companyDto.getId());
        if (foundCompany.isPresent()) {
            if (companyDto.getName() != null) {
                foundCompany.get().setName(companyDto.getName());
            }
            if (companyDto.getPermalink() != null) {
                foundCompany.get().setPermalink(companyDto.getPermalink());
            }
            if (companyDto.getCrunchbaseUrl() != null) {
                foundCompany.get().setCrunchbaseUrl(companyDto.getCrunchbaseUrl());
            }
            if (companyDto.getHomepage() != null) {
                foundCompany.get().setHomepage(companyDto.getHomepage());
            }
            if (companyDto.getBlogUrl() != null) {
                foundCompany.get().setBlogUrl(companyDto.getBlogUrl());
            }
            if (companyDto.getBlogFeedUrl() != null) {
                foundCompany.get().setBlogFeedUrl(companyDto.getBlogFeedUrl());
            }
            if (companyDto.getTwitterUsername() != null) {
                foundCompany.get().setTwitterUsername(companyDto.getTwitterUsername());
            }
            if (companyDto.getCategoryCode() != null) {
                foundCompany.get().setCategoryCode(companyDto.getCategoryCode());
            }
            if (companyDto.getNumberOfEmployees() > -1) {
                foundCompany.get().setNumberOfEmployees(companyDto.getNumberOfEmployees());
            }
            if (companyDto.getFoundedYear() > 1800 && companyDto.getFoundedYear() < 2023 ) {
                foundCompany.get().setFoundedYear(companyDto.getFoundedYear());
            }
            if (companyDto.getFoundedMonth() > 0 && companyDto.getFoundedMonth() < 13 ) {
                foundCompany.get().setFoundedMonth(companyDto.getFoundedMonth());
            }
            if (companyDto.getFoundedDay() > 0 && companyDto.getFoundedDay() < 32 ) {
                foundCompany.get().setFoundedDay(companyDto.getFoundedDay());
            }
            if (companyDto.getDeadpooledYear() > 1800) {
                foundCompany.get().setDeadpooledYear(companyDto.getDeadpooledYear());
            }

            if (companyDto.getTagList() != null) {
                foundCompany.get().setTagList(companyDto.getTagList());
            }
            if (companyDto.getAliasList() != null) {
                foundCompany.get().setAliasList(companyDto.getAliasList());
            }
            if (companyDto.getEmail() != null) {
                foundCompany.get().setEmail(companyDto.getEmail());
            }
            if (companyDto.getPhone() != null) {
                foundCompany.get().setPhone(companyDto.getPhone());
            }
            if (companyDto.getDescription() != null) {
                foundCompany.get().setDescription(companyDto.getDescription());
            }
            if (companyDto.getCreatedAt() != null) {
                foundCompany.get().setCreatedAt(companyDto.getCreatedAt());
            }
            if (companyDto.getUpdatedAt() != null) {
                foundCompany.get().setUpdatedAt(companyDto.getUpdatedAt());
            }
            if (companyDto.getOverview() != null) {
                foundCompany.get().setOverview(companyDto.getOverview());
            }
            repository.save(foundCompany.get());
            return companyDto;
        }
        return nullReturn();
    }

    public CompanyDto delete(String id) {
        Optional<Company> foundCompany = repository.findById(new ObjectId(id));
        if (foundCompany.isPresent()) {
            repository.delete(foundCompany.get());
            return convert(foundCompany.get());
        }
        return nullReturn();
    }

    public CompanyDto convert(Company company) {
        return new CompanyDto(company.getId(), company.getName(), company.getPermalink(), company.getCrunchbaseUrl(),
                company.getHomepage(), company.getBlogUrl(), company.getBlogFeedUrl(),
                company.getTwitterUsername(), company.getCategoryCode(), company.getNumberOfEmployees(),
                company.getFoundedYear(), company.getFoundedMonth(), company.getFoundedDay(), company.getDeadpooledYear(),
                company.getTagList(), company.getAliasList(), company.getEmail(), company.getPhone(),
                company.getDescription(), company.getCreatedAt(), company.getUpdatedAt(), company.getOverview());
    }

    public Company convertDto(CompanyDto company) {
        return new Company(company.getId(), company.getName(), company.getPermalink(), company.getCrunchbaseUrl(),
                company.getHomepage(), company.getBlogUrl(), company.getBlogFeedUrl(),
                company.getTwitterUsername(), company.getCategoryCode(), company.getNumberOfEmployees(),
                company.getFoundedYear(), company.getFoundedMonth(), company.getFoundedDay(), company.getDeadpooledYear(),
                company.getTagList(), company.getAliasList(), company.getEmail(), company.getPhone(),
                company.getDescription(), company.getCreatedAt(), company.getUpdatedAt(), company.getOverview());
    }

    public CompanyDto nullReturn() {
        return new CompanyDto(null,null,null,null,null,null,null,
                null,-1,-1,-1,-1,-1,null,null,null,null,null,null,
                null,null);
    }
}
