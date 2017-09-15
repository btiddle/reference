package quick_start_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.Header;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpPostSnippet {

  public static void main(String[] args) throws IOException {

    HttpClient httpclient = HttpClients.createDefault();
    HttpPost httppost = new HttpPost("http://httpbin.org/post");

    // Request parameters and other properties.
    List<NameValuePair> params = new ArrayList<NameValuePair>(2);
    params.add(new BasicNameValuePair("param-1", "12345"));
    params.add(new BasicNameValuePair("param-2", "Hello!"));
    httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

    //Execute and httpGet the response.
    HttpResponse response = httpclient.execute(httppost);
    HttpEntity entity = response.getEntity();
    
    if (entity != null) {
        InputStream instream = entity.getContent();
        try {
          // do something useful
          
          // Entity Content Body - Version #2
          InputStream in = entity.getContent();
          BufferedReader reader = new BufferedReader(new InputStreamReader(in));
          boolean status = reader.ready();
          //System.out.println("reader.ready():               " + status);
          
          String line = reader.readLine();
          while (line != null) {
            System.out.println("Entity Content:               " + line);
            line = reader.readLine();
          }

        } finally {
            instream.close();
        }
    }
  }

}