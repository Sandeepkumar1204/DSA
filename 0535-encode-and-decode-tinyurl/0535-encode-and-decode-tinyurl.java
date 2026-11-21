
import java.util.HashMap;
import java.util.Map;

public class Codec {
    private Map<String, String> map = new HashMap<>();
    private int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = "http://tinyurl.com/" + id;
        map.put(shortUrl, longUrl);
        id++;

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
