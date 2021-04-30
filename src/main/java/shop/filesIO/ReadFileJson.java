package shop.filesIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import shop.models.bouquet.FlowersBouquet;
import shop.models.flowers.Flower;


public class ReadFileJson {
    public List<Flower> getFlowers() throws Exception {
        ObjectReader reader = new ObjectMapper().enableDefaultTyping().reader();
        JsonParser jsonParser = new JsonFactory().createJsonParser(new File("test.txt"));

        return Arrays.asList(reader.readValue(jsonParser, Flower[].class));

    }
}
