package Net;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.System.*;

public class HttpURLDemo {
    public static void main(String args[]) throws Exception {
        URL hp = new URL("http://ecpd.stageserver.org");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();
        out.println("Method: " + hpCon.getRequestMethod());
        out.println("Code: " + hpCon.getResponseCode());
        out.println("Response message: " + hpCon.getResponseMessage());

        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();

        out.println("Header: ");

        for (String k: hdrField) {
            out.println("Key: " + k + "Value: " + hdrMap.get(k));
        }
    }
}
