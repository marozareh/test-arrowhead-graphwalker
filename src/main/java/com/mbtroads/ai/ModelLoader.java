package com.mbtroads.ai;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ModelLoader {

    public static String load(String modelName) throws Exception {

        String path = "src/main/resources/graphwalker/" +
                modelName + ".json";

        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
