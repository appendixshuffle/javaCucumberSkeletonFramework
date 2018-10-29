package com.company.api.frontendBDD.supportFactory;

import com.company.api.frontendBDD.Configuration;
import com.company.api.frontendBDD.PropertiesFileReader;

import java.util.ArrayList;

public class TestDataHelper {

    public static final String ergoLoginMessage = "Melden Sie sich bitte mit Ihrem ERGO Benutzernamen und Ihrem Kennwort an.";
    public static final String mitarbeiterInfoText = "Hier tragen Sie die Gesamtanzahl der Mitarbeiter ein, die im Unternehmen beschäftigt sind. Ist der genaue Wert noch nicht bekannt, wählen Sie bitte eine Bandbreite aus, die ungefähr passt. Den genauen Wert können Sie dann später im Steckbrief eintragen. Genauso wie Detailinformationen zu den Mitarbeitern, z. B. Voll- und Teilzeitkräfte. \n" +
            "\n" +
            " Falls die konkrete Mitarbeiteranzahl bei einem Produkt erforderlich ist, können Sie den genauen Wert auch dort erfassen.";

    public static String createFullUrl(String baseUrl, String corelID) {

        return baseUrl + corelID;
    }


    public static String getUrlForDocuments(String fileName) {

        ArrayList<String> fileList = new ArrayList<>();
        fileList.add("betrieb_kranken");
        fileList.add("betrieb_alter");
        fileList.add("pdf");
        fileList.add("doc");
        fileList.add("Cyber-Versicherung");

        PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
        String testingEnvironment = propertiesFileReader.getTestingEnvironment();
        String lastPartOfPdfUrl = null;
        String devEnvUrl = Configuration.KOMPASS_DEV_URL;
        String uatEnvUrl = Configuration.KOMPASS_UAT_URL;

        switch (fileName) {

            case "betrieb_kranken":
                if (testingEnvironment.equals("DEV")) {
                    lastPartOfPdfUrl = devEnvUrl + "public/assets/documents/" + fileList.get(0) + "." + fileList.get(2);
                } else if (testingEnvironment.equals("UAT")) {
                    lastPartOfPdfUrl = uatEnvUrl + "public/assets/documents/" + fileList.get(0) + "." + fileList.get(2);
                }
                break;

            case "betrieb_alter":
                if (testingEnvironment.equals("DEV")) {
                    lastPartOfPdfUrl = devEnvUrl + "public/assets/documents/" + fileList.get(1) + "." + fileList.get(2);
                } else if (testingEnvironment.equals("UAT")) {
                    lastPartOfPdfUrl = uatEnvUrl + "public/assets/documents/" + fileList.get(1) + "." + fileList.get(2);
                }
                break;

            case "Cyber-Versicherung":
                if (testingEnvironment.equals("DEV")) {
                    lastPartOfPdfUrl = devEnvUrl + "public/assets/documents/" + fileList.get(4) + "." + fileList.get(2);
                } else if (testingEnvironment.equals("UAT")) {
                    lastPartOfPdfUrl = uatEnvUrl + "public/assets/documents/" + fileList.get(4) + "." + fileList.get(2);
                }
                break;
        }
        return lastPartOfPdfUrl;


        /*
'enquiry': '/public/assets/documents/Cyber-Versicherung.pdf',
  'valve': 'https://vertriebsportal.ergo.com/de-DE/Produkte/Ventilloesungen/Material%20und%20Download.aspx',
  'cyberInsurance': '/public/assets/documents/Cyber-Versicherung.pdf',
  'Cyberschutzbrief': '/public/assets/documents/Cyber-Versicherung.pdf',
  'betrieb_kranken.pdf': '/public/assets/documents/betrieb_kranken.pdf',
  'betrieb_alter.pdf': '/public/assets/documents/betrieb_alter.pdf',
  'dienstreisen.pdf': '/public/assets/documents/dienstreisen.pdf',
  'kaution.pdf': '/public/assets/documents/kaution.pdf',
  'Fragenbogen-SG.pdf': '/public/assets/documents/Fragenbogen-SG.pdf',
  'KOMPASS_HUB': '/public/assets/documents/ERGO_FK_Kompass_Herzstueck.pdf',
  'Bauleistung-Risikofragenbogen.pdf': '/public/assets/documents/Bauleistung-Risikofragebogen.pdf',
  'Elektronik-Risikofragenbogen.pdf': '/public/assets/documents/Elektronik-Risikofragebogen.pdf',
  'Maschinen-Risikofragenbogen.pdf': '/public/assets/documents/Maschinen-Risikofragebogen.pdf',
  'Montage-Risikofragenbogen.pdf': '/public/assets/documents/Montage-Risikofragebogen.pdf',
  'Photovoltaik-Risikofragenbogen.pdf': '/public/assets/documents/Photovoltaik-Risikofragenbogen.pdf',
  'Anfrage-HG.pdf': '/public/assets/documents/Anfrage-HG.pdf',
  'Anfrage-VH.pdf': '/public/assets/documents/Anfrage-VH.pdf',
  'Anfrage-TR.pdf': '/public/assets/documents/Anfrage-TR.pdf',
  'Anfrage-bUV.pdf': '/public/assets/documents/Anfrage-bUV.pdf'
 */
    }


}
