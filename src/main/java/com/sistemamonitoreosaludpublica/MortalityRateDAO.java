package com.sistemamonitoreosaludpublica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MortalityRateDAO{
    
    List<MortalityRate> listMortalityRates;
    
    public MortalityRateDAO(){
        readData();
    }
    
    public List<MortalityRate> all(){
        return listMortalityRates;
    }
    
    private void readData(){
    
        listMortalityRates = new ArrayList<>();
        // Cargar el archivo
        File file = new File("D:\\eclipse-workspace\\SistemaMonitoreoVigilanciaSaludPublica\\doc\\data.csv");
        try {
            Scanner inputStream = new Scanner(file);
            // Leer cada linea
            // Cada linea tiene 11 campos
            String data = inputStream.next();
            while(inputStream.hasNext()){
                data = inputStream.next();
                
                // Separar campos
                String[] values = data.split(",");

                MortalityRate mortalityRate = new MortalityRate();
                mortalityRate.setYear(Integer.parseInt(values[0]));
                mortalityRate.setDepartment(values[1]);
                mortalityRate.setGender(values[2]);
                mortalityRate.setDisease(values[3]);
                mortalityRate.setNumberDeath(Integer.parseInt(values[4]));
                mortalityRate.setGrossRate(Float.parseFloat(values[5]));
                mortalityRate.setAdjusmentRate(Float.parseFloat(values[6]));
                mortalityRate.setError(Float.parseFloat(values[7]));
                mortalityRate.setLowerLimit(Float.parseFloat(values[8]));
                mortalityRate.setUpperLimit(Float.parseFloat(values[9]));
                mortalityRate.setCluster(Integer.parseInt(values[10]));
                
                listMortalityRates.add(mortalityRate);
                
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
        }
    }
}