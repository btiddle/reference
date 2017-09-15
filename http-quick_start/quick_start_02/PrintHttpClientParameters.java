package quick_start_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.Header;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PrintHttpClientParameters {

  public static void main(String[] args) throws IOException {

    String url;

    url = "http://example.com";
    url = "http://yuzu.com";
    url = "https://yuzu.com:443";
      url = "https://auth.yuzu.com/majors";
    url = "https://auth.yuzu.com/health-check";
    url = "https://yes-stg-pathfinder.yuzu-es.com/endpoints";
    url = "https://pathfinder.yuzu.com/endpoints";
    url = "https://yes-stg-pathfinder.yuzu-es.com/endpoints";
    url = "https://pathfinder.yuzu.com/endpoints";

    url = "http://example.com";

    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(url);
    CloseableHttpResponse response1 = httpclient.execute(httpGet);
    // The underlying HTTP connection is still held by the response object
    // to allow the response content to be streamed directly from the network
    // socket.
    // In order to ensure correct deallocation of system resources
    // the user MUST call CloseableHttpResponse#close() from a finally clause.
    // Please note that if response content is not fully consumed the underlying
    // connection cannot be safely re-used and will be shut down and discarded
    // by the connection manager.
    try {

      /*
       * HttpGet
       */

      System.out.println("========================================");
      System.out.println("HttpGet");
      System.out.println("========================================");

      // Config
      System.out.println("Config:                       " +  httpGet.getConfig());

      // Protocol Version
      System.out.println("Protocol Version:             " +  httpGet.getProtocolVersion());

      // Request Line
      System.out.println("Request Line:                 " +  httpGet.getRequestLine());

      // URI
      System.out.println("URI:                          " +  httpGet.getURI());


      /*
       * CloseableHttpResponse
       */

      System.out.println();
      System.out.println("========================================");
      System.out.println("CloseableHttpResponse");
      System.out.println("========================================");

      // Locale
      System.out.println("Locale:                       " + response1.getLocale());

      // Status Line
      System.out.println("Status Line:                  " + response1.getStatusLine());

      // Protocol Version
      System.out.println("Protocol Version:             " + response1.getProtocolVersion());

      // Status Code
      System.out.println("Status Code:                  " + response1.getStatusLine().getStatusCode());

      // Reason Phrase
      System.out.println("Reason Phrase:                " + response1.getStatusLine().getReasonPhrase());

      // Contains Header 'Date'
      System.out.println("Contains Header 'Date':       " + response1.containsHeader("Date"));

      // All Headers
      Header[] header1 = response1.getAllHeaders();
      for (Object h : header1) {
        System.out.println("Header:                       " + h);
      }

      // First Header 'Server'
      System.out.println("First header 'Server':        " + response1.getFirstHeader("Server"));

      // Headers with 'ETag'
      Header[] header2 = response1.getHeaders("ETag");
      for (Object h : header2) {
        System.out.println("Headers with 'ETag':          " + h);
      }

      // Last header 'Content Type'
      System.out.println("Last header 'Content Type':   " + response1.getLastHeader("Content-Type"));

      // Count headers using headerIterator()
      HeaderIterator headerIterator1 = response1.headerIterator();
      int count1 = 0;
      while (headerIterator1.hasNext()) {
        headerIterator1.next();
        count1++;
      }
      System.out.println("Number of headers:            " + count1);

      // Count headers with using headerIterator() containing Set-Cookie
      HeaderIterator headerIterator2 = response1.headerIterator("Set-Cookie");
      int count2 = 0;
      while (headerIterator2.hasNext()) {
        headerIterator2.next();
        count2++;
      }
      System.out.println("Headers as 'Set-Cookie':      " + count2);


      // Get the Entity
      HttpEntity entity = response1.getEntity();


      // Entity
      System.out.println("Entity:                       " + entity);

      // Entity String
      System.out.println("Entity String:                " + entity.toString());

      // Entity Class
      System.out.println("Entity Class:                 " + entity.getClass());

      // Entity Hashcode
      System.out.println("Entity Hashcode:              " + entity.hashCode());

      // Entity Content Encoding
      System.out.println("Entity Content Encoding:      " + entity.getContentEncoding());

      // Entity Content Length
      // Returns value in Content-Length header (when present), otherwise returns -1
      System.out.println("Entity Content Length:        " + entity.getContentLength());

      // Entity Content Type
      System.out.println("Entity Content Type:          " + entity.getContentType());

      // Entity Content Type Name
      System.out.println("Entity Content Type Name:     " + entity.getContentType().getName());

      // Entity Content Type Value
      System.out.println("Entity Content Type Value:    " + entity.getContentType().getValue());

      // Entity Content Type Elements
      System.out.println("Entity Content Type Elements: " + entity.getContentType().getElements());

      // Entity Chunked
      System.out.println("Entity Chunked:               " + entity.isChunked());

      // Entity Repeatable
      System.out.println("Entity Repeatable:            " + entity.isRepeatable());

      // Entity Streaming
      System.out.println("Entity Streaming:             " + entity.isStreaming());

      // Entity Content Body - Version #1
//      String responseString = EntityUtils.toString(entity);
//      System.out.println("Entity Response Body:         " + responseString);

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

      // do something useful with the response body
      // and ensure it is fully consumed
      EntityUtils.consume(entity);
    } catch (Exception e) {
        System.err.println("Caught Exception: " + e.getMessage());
    } finally {
        response1.close();
    }

  }

}