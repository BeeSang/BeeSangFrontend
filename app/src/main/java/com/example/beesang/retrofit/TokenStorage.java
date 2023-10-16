package com.example.beesang.retrofit;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TokenStorage {

    public static String getToken(Context applicationContext) {
        int c;
        StringBuilder sb = new StringBuilder();
        try {
            String path =  applicationContext.getFilesDir().getPath() + "/token.txt";
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);

            while(-1 != (c = fis.read())) {
                sb.append((char)c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    public static void setToken(Context applicationContext, String token) throws IOException {
        try {
            String path = applicationContext.getFilesDir().getPath() + "/token.txt";
            File file = new File(path);

            FileOutputStream fos = new FileOutputStream(file);
            fos.write( token.getBytes() );
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}