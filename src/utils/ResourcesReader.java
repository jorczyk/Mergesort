package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ResourcesReader {

    public BufferedReader readFile(String filePath) throws FileNotFoundException {
        InputStream is = new FileInputStream(filePath);
        return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    }
}
