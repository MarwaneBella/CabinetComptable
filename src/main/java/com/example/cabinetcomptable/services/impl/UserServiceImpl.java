package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.User;
import com.example.cabinetcomptable.repositories.UserRepository;
import com.example.cabinetcomptable.services.UserService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean check(User dataUser){
        User user = userRepository.findByUsernameAndPassword(dataUser.getUsername(), dataUser.getPassword());

        if(user != null){
            return true;
        }

        return false;
    }
    @Override
    public void importToDb(List<MultipartFile> multipartfiles){
        if (!multipartfiles.isEmpty()) {
            List<User> users = new ArrayList<>();
            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

                    XSSFSheet sheet = workBook.getSheetAt(0);
                    // looping through each row
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) - 1; rowIndex++) {
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }

                        String username =String.valueOf(row.getCell(0));
                        String password =String.valueOf(row.getCell(1));

                        User user = User.builder().username(username).password(password).build();
                        users.add(user);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            if (!users.isEmpty()) {
                // save to database
                userRepository.saveAll(users);
            }
        }
    }


    public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
        int numOfNonEmptyCells = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                XSSFCell cell = row.getCell(columnIndex);
                if (cell != null ) {
                    numOfNonEmptyCells++;
                }
            }
        }
        return numOfNonEmptyCells;
    }

}
