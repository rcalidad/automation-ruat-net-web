package main.tasks.inmuebles.commonInm;

import main.helpers.common.Inmuebles.ConstantsINM;
import main.helpers.dataUtility.ExcelData;

import java.util.ArrayList;
import java.util.List;

public class GetTaxpayers {
    public static List<String> ofTwoTypes(int numNaturalTexpayer, int numLegalTaxpayer, String town){
        List<String> taxpayersList = new ArrayList<>();
        taxpayersList.addAll(ofOneType(numNaturalTexpayer, "NATURAL", town));
        taxpayersList.addAll(ofOneType(numLegalTaxpayer, "JURIDICO", town));
        return taxpayersList;
    }
    public static ArrayList<String> ofOneType(int numTaxpayers, String taxpayerType, String town){
        ArrayList<String> auxiliaryTaxpayersList;
        ArrayList<String> taxpayerList = new ArrayList<>();
        if (numTaxpayers > 0){
            auxiliaryTaxpayersList = ExcelData.getTaxpayerList(ConstantsINM.GENERATOR_DATA_FILE, town, taxpayerType);
            int max = auxiliaryTaxpayersList.size() - 1;
            for (int i = 0; i < numTaxpayers; i++){
                int index = (int) (Math.random() * ((max) + 1));
                String taxpayer = auxiliaryTaxpayersList.get(index);
                while (taxpayerList.contains(taxpayer)){
                    index = (int) (Math.random() * ((max) + 1));
                    taxpayer = auxiliaryTaxpayersList.get(index);
                }
                taxpayerList.add(taxpayer);
            }
        }
        return taxpayerList;
    }
}
