import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extratorDeConteudoDaNasa implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String body) {
        
        var parser = new JsonParser ();
		List<Map<String, String>> listaDeAtributos = parser.parse(body);

        List<Conteudo> conteudos = new  ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
        String titulo = atributos.get("title");
		String urlImagem = atributos.get("url");

        Conteudo conteudo = new Conteudo(titulo,  urlImagem);

        conteudos.add(conteudo);
        }
        return conteudos;
    }
}