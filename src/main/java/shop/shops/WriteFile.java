package shop.shops;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import shop.models.bouquet.FlowersBouquet;

public class WriteFile {
    private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    public void writeFile(String json){
        Charset charset = Charset.forName("US-ASCII");
        Path currentRelativePath = Paths.get("");
        Path sibling = currentRelativePath.resolveSibling("test.txt");
        try (
                BufferedWriter writer = Files.newBufferedWriter(sibling.toAbsolutePath(), charset)) {
            writer.write(json, 0, json.length());
        } catch (
                IOException x) {
            System.err.format("IOException: %s%n", x);
    }

}
    public void storesBouquet(FlowersBouquet bouquet)  throws Exception{
        String json = ow.writeValueAsString(bouquet);
        writeFile(json);
    }

}
