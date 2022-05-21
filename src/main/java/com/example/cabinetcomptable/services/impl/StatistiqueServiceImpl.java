package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.repositories.*;
import com.example.cabinetcomptable.services.StatistiqueService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
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

    @Override
    public String getDataDepenseAndRecettePerYear(){

        Date nextDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(nextDate);
        c.add(Calendar.YEAR, -2);
        nextDate = c.getTime();


        JSONArray mainData = new JSONArray();


        for(int i=0;i<3;i++){



            JSONArray series = new JSONArray();

            JSONObject datayear = new JSONObject();

            Double totalDepenses = bonAchatRepository.selectSumofDepensePerYear(nextDate);
            Double totalRecettes = bonHonoraireRepository.selectSumofRecettePerYear(nextDate);

            if(totalDepenses == null ){
                totalDepenses = (double) 0;
            }

            if(totalRecettes == null){
                totalRecettes = (double) 0;
            }



            series.put(getBar("Dépens", totalDepenses ) );
            series.put(getBar("Recette", totalRecettes ) );

            datayear.put("name", c.get(Calendar.YEAR)+"" );
            datayear.put("series", series );
            mainData.put(datayear);

            c.add(Calendar.YEAR, 1);
            nextDate = c.getTime();

            c.setTime(nextDate);
        }


        return mainData.toString();
    }

    JSONObject  getBar(String typeBar, Double value){

        JSONObject bar = new JSONObject();
        bar .put("name", typeBar);
        bar .put("value", value);
        return bar ;
    }




}
