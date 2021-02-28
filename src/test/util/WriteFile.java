package test.util;

import newmath.numbertheory.Utils;
import java.io.FileOutputStream;
import java.io.IOException;


public class WriteFile {

    public static void write(String pathToWrite) throws IOException {
        FileOutputStream out = new FileOutputStream(pathToWrite);
        int limit = 500;
        long a = 1, b = 1;

        long result;

        byte[] buffer;
        for (int i = 1; i < limit; i++) {
            for (int j = 1; j < limit; j++) {
                result = Utils.greatestCD(i, j);
                String resultStr = String.valueOf(result);
                buffer = resultStr.getBytes();
                out.write(buffer);
                out.flush();
                out.write("\n".getBytes());
                out.flush();
            }
            out.flush();
        }
        out.flush();
        out.close();
    }
}

