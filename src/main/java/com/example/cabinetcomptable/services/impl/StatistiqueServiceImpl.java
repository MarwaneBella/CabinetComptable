package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.repositories.*;
import com.example.cabinetcomptable.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatistiqueServiceImpl implements StatistiqueService {

    @Autowired
    ClientRepository clientRepository ;

    @Autowired
    FournisseurRepository fournisseurRepository ;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    BonAchatRepository bonAchatRepository;

    @Autowired
    BonHonoraireRepository bonHonoraireRepository;

    @Autowired
    ReglementFournisseurRepository reglementFournisseurRepository;

    @Autowired
    ReglementClientRepository reglementClientRepository;

    @Autowired
    FactureRepository factureRepository;


    @Override
    public Map<String,Long> countNumberOfAll(){
        Map<String,Long> map = new HashMap<String, Long>() ;

        map.put("client", clientRepository.count());
        map.put("fournisseur", fournisseurRepository.count());
        map.put("produit", produitRepository.count());
        map.put("categorie", categorieRepository.count());
        map.put("bonAchat", bonAchatRepository.count());
        map.put("bonHonoraire", bonHonoraireRepository.count());
        map.put("reglementClient", reglementClientRepository.count());
        map.put("reglementFournisseur", reglementFournisseurRepository.count());
        map.put("facture", factureRepository.count());

        return map;

    }




}
