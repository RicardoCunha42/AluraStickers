import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://api.mocki.io/v2/549a5d8b";
		URI endereço = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereço).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body(); 
		
		var parser = new JsonParser ();
		List<Map<String, String>> listaDeFIlmes = parser.parse(body);
		for (Map<String, String> filme : listaDeFIlmes) {
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
		}
    }
}
