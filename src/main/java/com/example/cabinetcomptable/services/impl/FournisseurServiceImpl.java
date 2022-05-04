package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Fournisseur;
import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.FournisseurRepository;
import com.example.cabinetcomptable.services.FileStorageService;
import com.example.cabinetcomptable.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    FileStorageService fileStorageService ;

    @Autowired
    ServletContext context;

    private String pathFolder = "fournisseurImages";

    private static Fournisseur currentFournisseur  =null;
    public  FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository;
    }


    @Override
    public ResponseEntity<Fournisseur> addFournisseur(Fournisseur fournisseur) {
        fournisseur.setData_de_transaction(new Date());
        currentFournisseur = fournisseurRepository.save(fournisseur);
        return  ResponseEntity.ok(fournisseur);
    }

    @Override
    public ResponseEntity<Fournisseur> getFournisseur(long id) {
        currentFournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("fournisseur not found for this id :: " + id));
        return ResponseEntity.ok(currentFournisseur);
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public ResponseEntity<Fournisseur> updateFournisseur(Fournisseur fournisseur, long id) {
        currentFournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("fournisseur not found for this id :: " + id));
        fournisseur.setId(id);
        fournisseur.setImage(currentFournisseur.getImage());
        currentFournisseur = fournisseurRepository.save(fournisseur);
        return ResponseEntity.ok(fournisseur);
    }
    @Override
    public void deleteFournisseur(long id) {
        currentFournisseur = fournisseurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("fournisseur not found for this id :: " + id));
        fileStorageService.deleteFile(pathFolder+"/"+currentFournisseur.getImage());
        fournisseurRepository.deleteById(id);
    }

    @Override
    public void addFile(MultipartFile file) {
        if(currentFournisseur.getImage() !=null){
            fileStorageService.deleteFile(pathFolder+"/"+currentFournisseur.getImage());
        }
        currentFournisseur.setImage(fileStorageService.uploadFile(file,pathFolder));
        currentFournisseur =fournisseurRepository.save(currentFournisseur);

    }
    @Override
    public String getFile() {
        return fileStorageService.loadFile(pathFolder+"/"+currentFournisseur.getImage());

    }





}
