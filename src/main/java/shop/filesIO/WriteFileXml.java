package shop.filesIO;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import shop.models.flowers.ChamomileFlower;
import shop.models.flowers.RoseFlower;

import java.io.File;

public class WriteFileXml {

    public static void main(String[] args) throws Exception {
        new WriteFileXml().writeToFile(new RoseFlower(1, "f", "df", 1), "flower.xml");
    }

    public void writeToFile(RoseFlower roseFlower, String fileName) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(fileName), roseFlower);
    }

    public void writeToFile(ChamomileFlower chamomileFlower, String fileName) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(fileName), chamomileFlower);
    }
}
