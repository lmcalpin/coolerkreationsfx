package com.metatrope.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

public class IOUtil {
    public static void close(InputStream is) {
        if (is == null)
            return;
        try {
            is.close();
        } catch (IOException e) {
            throw new CheckedExceptionsAreStupidException("Could not close Reader", e);
        }
    }

    public static void close(Reader r) {
        if (r == null)
            return;
        try {
            r.close();
        } catch (IOException e) {
            throw new CheckedExceptionsAreStupidException("Could not close Reader", e);
        }
    }

    public static String readAsString(InputStream is) throws IOException {
        try {
            if (is == null)
                return null;
            return readAsString(new InputStreamReader(is));
        } finally {
            close(is);
        }
    }

    public static String readAsString(Reader r) throws IOException {
        BufferedReader br = new BufferedReader(r);
        try {
            StringWriter sw = new StringWriter();
            String line;
            while ((line = br.readLine()) != null) {
                sw.write(line + "\n");
            }
            return sw.toString();
        } finally {
            close(br);
        }
    }
}
