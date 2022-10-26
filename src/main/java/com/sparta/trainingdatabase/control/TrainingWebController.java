package com.sparta.trainingdatabase.control;

import com.sparta.trainingdatabase.model.dao.CompanyDao;
import com.sparta.trainingdatabase.model.dao.InspectionDao;
import com.sparta.trainingdatabase.model.dao.UserDao;
import com.sparta.trainingdatabase.model.dto.CompanyDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TrainingWebController {

    private final UserDao userDao;
    private final CompanyDao companyDao;
    private final InspectionDao inspectionDao;


    public TrainingWebController(UserDao userDao, CompanyDao companyDao, InspectionDao inspectionDao) {
        this.userDao = userDao;
        this.companyDao = companyDao;
        this.inspectionDao = inspectionDao;
    }


    @GetMapping("/companies")
    public String allCompanies(Model model) {
        List<CompanyDto> companies = companyDao.findAll();
        model.addAttribute("allCompanies", companies);
        model.addAttribute("deleted",false);
        model.addAttribute("added",false);
        return "allCompanies";
    }

    @GetMapping("/companies/{id}")
    public String findCompany(@PathVariable String id, Model model) {
        CompanyDto foundCompany = companyDao.findByid(id);
        if (foundCompany.getName() != null) {
            model.addAttribute("foundCompany", foundCompany);
            return "companyDetail";
        }
        return "error";
    }

    @GetMapping("/companies/delete/{id}")
    public String deleteCompany(@PathVariable String id, Model model) {
        CompanyDto foundCompany = companyDao.delete(id);
        if (foundCompany.getName() != null) {
            model.addAttribute("deleted", true);
            return "allCompanies";
        }
        return "error";
    }

    @GetMapping("/companies/add")
    public String addCompany(Model model) {
        model.addAttribute("addedCompany", new CompanyDto());
        model.addAttribute("addingError", false);
        return "addCompany";
    }

    @PostMapping("/companies/add")
    public String addNewCompany(@ModelAttribute CompanyDto newCompany, Model model) {
        CompanyDto addedCompany = companyDao.save(newCompany);
        if (addedCompany.getName() != null) {
            model.addAttribute("addedCompany", addedCompany);
            model.addAttribute("added", true);
            return "allCompanies";
        }
        model.addAttribute("addingError", true);
        return "addCompany";
    }

    @GetMapping("/companies/edit/{id}")
    public String editCompany(@PathVariable String id, Model model) {
        CompanyDto companyToEdit = companyDao.findByid(id);
        model.addAttribute("editCompany", companyToEdit);
        model.addAttribute("editError", false);
        return "editCompany";
    }

    @PatchMapping("/companies/edit")
    public String editCompanyAction(@ModelAttribute CompanyDto companyDto, Model model) {
        CompanyDto editedCompany = companyDao.update(companyDto);
        if (editedCompany.getName() != null) {
            model.addAttribute("foundCompany", editedCompany);
            return "companyDetail";
        }
        model.addAttribute("editError", true);
        return "editCompany";
    }
}
