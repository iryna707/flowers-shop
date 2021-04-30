package shop.filesIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import shop.models.bouquet.FlowersBouquet;
import shop.models.flowers.Flower;

public class WriteFileJson {
    private ObjectWriter ow = new ObjectMapper().enableDefaultTyping().writer().withDefaultPrettyPrinter();

    private void writeFile(String json) {
        Charset charset = StandardCharsets.US_ASCII;
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

    public void storeFlowers(List<Flower> flowers) throws Exception {
        String json = ow.writeValueAsString(flowers);
        writeFile(json);
    }

}
