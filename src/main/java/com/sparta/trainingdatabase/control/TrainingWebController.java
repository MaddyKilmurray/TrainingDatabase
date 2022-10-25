package com.sparta.trainingdatabase.control;

import com.sparta.trainingdatabase.model.dao.CompanyDao;
import com.sparta.trainingdatabase.model.dao.InspectionDao;
import com.sparta.trainingdatabase.model.dao.UserDao;
import com.sparta.trainingdatabase.model.dto.CompanyDto;
import com.sparta.trainingdatabase.model.dto.UserDto;
import com.sparta.trainingdatabase.model.entity.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
        return "allCompanies";
    }

    @GetMapping("/companies/byid")
    public String findCompany(@RequestParam String id, Model model) {
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
}
