package shop.filesIO;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import shop.models.flowers.ChamomileFlower;
import shop.models.flowers.RoseFlower;

import java.io.*;

public class ReadFileXml {

    public static void main(String[] args) throws Exception {
        RoseFlower roseFlower = new ReadFileXml().getRoseFlower("flower.xml");
        System.out.println(roseFlower);
    }

    public RoseFlower getRoseFlower(String fileName) throws Exception {

        File file = new File(fileName);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        RoseFlower value = xmlMapper.readValue(xml, RoseFlower.class);
        return value;
    }

    public ChamomileFlower getChamomileFlower(String fileName) throws Exception {
        File file = new File(fileName);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        ChamomileFlower value = xmlMapper.readValue(xml, ChamomileFlower.class);
        return value;
    }

    private String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }




}

