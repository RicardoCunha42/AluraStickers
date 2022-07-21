import java.io.InputStream;
import java.net.URL;
import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        
		ExtratorDeConteudo extratorDeConteudo = new extratorDeConteudoDaNasa();
		String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";

		//ExtratorDeConteudo extratorDeConteudo = new extratorDeConteudoDoIMDB();
		//String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
		
		ClienteHttp cliente = new ClienteHttp();
		String body = cliente.buscaDados(url);

		List<Conteudo> conteudos = extratorDeConteudo.extraiConteudos(body);

		var geradora = new GeradoraDeFigurinhas ();
		
		for (int i = 0; i < 3; i++) {
			
			Conteudo conteudo = conteudos.get(i);
		
			String nomeArquivo = "Saida/" + conteudo.getTitulo() + ".png";
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			
			geradora.cria (inputStream, nomeArquivo);

			System.out.println(conteudo.getTitulo());
			System.out.println();
		
		}
    }
}
