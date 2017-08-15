package com.realscores.util;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Mitch on 14/08/2017.
 */
public class HttpRequestUtil {

  public static <T> Object getJsonObject(Object[] params, Object returnType)
  {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      HttpClient client = new DefaultHttpClient();
      HttpGet httpGet = new HttpGet("http://192.168.2.12:8080/courses/" + String.valueOf(params[0]));
      try {
        HttpResponse response = client.execute(httpGet);
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 200) {
          HttpEntity entity = response.getEntity();
          InputStream content = entity.getContent();
          BufferedReader reader = new BufferedReader(
              new InputStreamReader(content));
          String line;
          while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
          }
        } else {
          Log.e("JSON", "Failed to download file");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      ObjectMapper ojbMapper = new ObjectMapper();
      return ojbMapper.readValue(stringBuilder.toString(), returnType.getClass());
    } catch (Exception ex) {
      Log.wtf("Other Stuff", ex.getMessage());
      throw new RuntimeException(ex);
    }
  }

  public static <T> Object[] getJsonObjects(Object[] params, Object[] returnType)
  {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      HttpClient client = new DefaultHttpClient();
      HttpGet httpGet = new HttpGet("http://192.168.2.12:8080/courses/" + String.valueOf(params[0]));
      try {
        HttpResponse response = client.execute(httpGet);
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 200) {
          HttpEntity entity = response.getEntity();
          InputStream content = entity.getContent();
          BufferedReader reader = new BufferedReader(
              new InputStreamReader(content));
          String line;
          while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
          }
        } else {
          Log.e("JSON", "Failed to download file");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      ObjectMapper ojbMapper = new ObjectMapper();
      return ojbMapper.readValue(stringBuilder.toString(), returnType.getClass());
    } catch (Exception ex) {
      Log.wtf("Other Stuff", ex.getMessage());
      throw new RuntimeException(ex);
    }
  }

}
