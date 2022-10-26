package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //bizim basta bir properties objesi olusturmamız
    //bu properties obje'sine static blokla gidip
    //configuration properties'deki degeri okuyabilmesi icin
    //FileInputStream uzerinden yolu gostermemiz ve FileInputStream'in
    //okudugu degerleri load etmemiz gerekir
    //Dolayısıyla static method her seyden once baslıyordu ya,
    //her seyden once baslayıp gidip FileInputStream'le bizim
    //configuration properties dosyamızı okuyor,sonra bunu gelip
    //properties'e yukluyor properties.load(fis)
    //yukleyince artık properties'in ustunde tum bilgiler oluyor
    //biz istedigimiz key'i yolladıgımızda
    //o da bize bu key'e karsılık gelen value'u donduruyor

    public static Properties properties;

    static { //static blok her seyden once calısıyordu
        //FileInputStream ile configuration properties'e gidip okuyo
        String dosyaYolu="configuration.properties";

        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fis);  //fis'in okudugu bilgileri properties'e yukledi

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key){
        /*
        test method'undan yolladıgımız string key degerini alıp
        Properties class'ından getProperty() method'unu kullanarak
        bu key'e ait value'u bize getirdi
         */
        return properties.getProperty(key);
    }
}

