package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Client;

import com.example.cabinetcomptable.exception.ResourceNotFoundException;
import com.example.cabinetcomptable.repositories.ClientRepository;
import com.example.cabinetcomptable.services.ClientService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    ServletContext context;
    String path = "src/main/resources/Images/";

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ResponseEntity<Client> addClient(@RequestParam("file") MultipartFile file,
                                            @RequestParam("client") String clientData) throws JsonParseException, JsonMappingException, Exception {

        Client client = new ObjectMapper().readValue(clientData, Client.class);
        System.out.println("Ok .............");

        System.out.println(context.getRealPath("/clientImages/"));

        boolean isExit = new File(context.getRealPath("/clientImages/")).exists();
        if (!isExit) {
            new File (context.getRealPath("/clientImages/")).mkdir();
            System.out.println("mk dir.............");
        }

        String filename = file.getOriginalFilename();
        String newFileName;

        if(filename.equals("avatar.png") &&  file.getSize() == 8229){
            newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        }
        else{
            newFileName = FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
        }


        File serverFile = new File (context.getRealPath("/clientImages/"+File.separator+newFileName));
        System.out.println(newFileName);
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());


        }catch(Exception e) {
            e.printStackTrace();
        }


        client.setImage(newFileName);
        client.setData_de_transaction(new Date());
        clientRepository.save(client);

        return ResponseEntity.ok(client);

    }

    @Override
    public ResponseEntity<Map> getClient(long id) throws ResourceNotFoundException ,Exception {
        Client client= clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
        Map<String,Object> map=new HashMap<>();
        map.put("client",client);

        String image =null ;
        String folderPath = context.getRealPath("/clientImages/");
        File file = new File(folderPath+client.getImage());

        String encodeBase64;
        try {
            String extension = FilenameUtils.getExtension(file.getName());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStream.read(bytes);
            encodeBase64 = Base64.getEncoder().encodeToString(bytes);
            image = "data:image/"+extension+";base64,"+encodeBase64;
            fileInputStream.close();
        }
        catch (Exception e){
            System.out.println("download failed!!");
        }



        map.put("file",image);
        return ResponseEntity.ok(map);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ResponseEntity<Client> updateClient(long id, MultipartFile file,String clientData ) throws JsonParseException, JsonMappingException, Exception{

        Client oldClient =clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
        Client newClient = new ObjectMapper().readValue(clientData, Client.class);

        oldClient.setNom(newClient.getNom());
        oldClient.setEmail(newClient.getEmail());
        oldClient.setTele_portable(newClient.getTele_portable());
        oldClient.setTele_fix(newClient.getTele_fix());
        oldClient.setVille(newClient.getVille());
        oldClient.setAdresse(newClient.getAdresse());
        oldClient.setCode_postale(newClient.getCode_postale());
        oldClient.setSite_web(newClient.getSite_web());
        oldClient.setIfi(newClient.getIfi());
        oldClient.setIce(newClient.getIce());
        oldClient.setTp(newClient.getTp());
        oldClient.setCnss(newClient.getCnss());
        oldClient.setRc(newClient.getRc());
        oldClient.setBilan(newClient.getBilan());
        oldClient.setPv_bilan(newClient.getPv_bilan());
        oldClient.setRegime(newClient.getRegime());
        oldClient.setR_tva(newClient.getR_tva());
        oldClient.setR_cnss(newClient.getR_cnss());





        //Client updateClient =clientRepository.save(oldClient);
        return (ResponseEntity<Client>) ResponseEntity.ok();
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }


}
