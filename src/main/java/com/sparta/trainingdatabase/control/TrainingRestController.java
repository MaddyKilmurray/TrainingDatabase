package com.sparta.trainingdatabase.control;

import com.sparta.trainingdatabase.model.dao.CompanyDao;
import com.sparta.trainingdatabase.model.dao.InspectionDao;
import com.sparta.trainingdatabase.model.dao.UserDao;
import com.sparta.trainingdatabase.model.dto.CompanyDto;
import com.sparta.trainingdatabase.model.dto.InspectionDto;
import com.sparta.trainingdatabase.model.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingRestController {

    private final InspectionDao inspectionDao;
    private final UserDao userDao;
    private final CompanyDao companyDao;

    public TrainingRestController(InspectionDao inspectionDao, UserDao userDao, CompanyDao companyDao) {
        this.inspectionDao = inspectionDao;
        this.userDao = userDao;
        this.companyDao = companyDao;
    }

    @GetMapping("/inspection/all")
    public List<InspectionDto> findAllInspections() {
        return inspectionDao.findAll();
    }

    @GetMapping("/inspection/{id}")
    public InspectionDto findInspectionById(@PathVariable String id) {
        return inspectionDao.findByid(id);
    }

    @PostMapping("/inspection/add")
    public InspectionDto saveInspection(@RequestBody InspectionDto inspectionDto) {
        return inspectionDao.save(inspectionDto);
    }

    @PatchMapping("/inspection/update")
    public InspectionDto updateInspection(@RequestBody InspectionDto inspectionDto) {
        return inspectionDao.update(inspectionDto);
    }

    @DeleteMapping("/inspection/delete/{id}")
    public InspectionDto deleteInspection(@PathVariable String id) {
        return inspectionDao.delete(id);
    }

    @GetMapping("/user/all")
    public List<UserDto> findAllUsers() {
        return userDao.findAll();
    }

    @GetMapping("/user/{id}")
    public UserDto findUsersById(@PathVariable String id) {
        return userDao.findByid(id);
    }

    @PostMapping("/user/add")
    public UserDto saveUsers(@RequestBody UserDto userDto) {
        return userDao.save(userDto);
    }

    @PatchMapping("/user/update")
    public UserDto updateUsers(@RequestBody UserDto userDto) {
        return userDao.update(userDto);
    }

    @DeleteMapping("/user/delete/{id}")
    public UserDto deleteUsers(@PathVariable String id) {
        return userDao.delete(id);
    }

    @GetMapping("/company/all")
    public List<CompanyDto> findAllCompanies() {
        return companyDao.findAll();
    }

    @GetMapping("/company/{id}")
    public CompanyDto findCompaniesById(@PathVariable String id) {
        return companyDao.findByid(id);
    }

    @PostMapping("/company/add")
    public CompanyDto saveCompanies(@RequestBody CompanyDto companyDto) {
        return companyDao.save(companyDto);
    }

    @PatchMapping("/company/update")
    public CompanyDto updateCompanies(@RequestBody CompanyDto companyDto) {
        return companyDao.update(companyDto);
    }

    @DeleteMapping("/company/delete/{id}")
    public CompanyDto deleteCompanies(@PathVariable String id) {
        return companyDao.delete(id);
    }
}
