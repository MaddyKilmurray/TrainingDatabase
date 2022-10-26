package com.sparta.trainingdatabase.model.dao;

import com.sparta.trainingdatabase.model.dto.InspectionDto;
import com.sparta.trainingdatabase.model.entity.inspection.Inspection;
import com.sparta.trainingdatabase.model.repository.InspectionRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InspectionDao {

    private final InspectionRepository repository;

    public InspectionDao(InspectionRepository repository) {
        this.repository = repository;
    }

    public List<InspectionDto> findAll() {
        List<Inspection> inspections = repository.findAll();
        List<InspectionDto> convertedInspection = new ArrayList();
        for (Inspection inspection : inspections) {
            convertedInspection.add(convert(inspection));
        }
        return convertedInspection;
    }

    public InspectionDto findByid(String id) {
        Optional<Inspection> foundInspection = repository.findById(id);
        if (foundInspection.isPresent()) {
            return convert(foundInspection.get());
        }
        return nullReturn();
    }

    public InspectionDto save(InspectionDto inspectionDto) {
        Inspection inspectionToSave = convertDto(inspectionDto);
        repository.save(inspectionToSave);
        return inspectionDto;
    }

    public InspectionDto update(InspectionDto inspectionDto) {
        Optional<Inspection> foundInspection = repository.findById(inspectionDto.getId());
        if (foundInspection.isPresent()) {
            if (inspectionDto.getCertificateNumber() != null) {
                foundInspection.get().setCertificateNumber(inspectionDto.getCertificateNumber());
            }
            if (inspectionDto.getBusinessName() != null) {
                foundInspection.get().setBusinessName(inspectionDto.getBusinessName());
            }
            if (inspectionDto.getDate() != null) {
                foundInspection.get().setDate(inspectionDto.getDate());
            }
            if (inspectionDto.getResult() != null) {
                foundInspection.get().setResult(inspectionDto.getResult());
            }
            if (inspectionDto.getSector() != null) {
                foundInspection.get().setSector(inspectionDto.getSector());
            }
            if (inspectionDto.getAddress() != null) {
                foundInspection.get().setAddress(inspectionDto.getAddress());
            }
            repository.save(foundInspection.get());
            return inspectionDto;
        }
        return nullReturn();
    }

    public InspectionDto delete(String id) {
        Optional<Inspection> foundInspection = repository.findById(id);
        if (foundInspection.isPresent()) {
            repository.delete(foundInspection.get());
            return convert(foundInspection.get());
        }
        return nullReturn();
    }

    public InspectionDto convert(Inspection inspection) {
        return new InspectionDto(inspection.getId(),inspection.getSecondId(), inspection.getCertificateNumber(),
                inspection.getBusinessName(), inspection.getDate(), inspection.getResult(),
                inspection.getSector(), inspection.getAddress());
    }

    public Inspection convertDto(InspectionDto inspection) {
        return new Inspection(inspection.getId(),inspection.getSecondId(),inspection.getCertificateNumber(),
                inspection.getBusinessName(), inspection.getDate(), inspection.getResult(),
                inspection.getSector(), inspection.getAddress());
    }

    public InspectionDto nullReturn() {
        return new InspectionDto(null,null,null,null,null,null,null);
    }
}
