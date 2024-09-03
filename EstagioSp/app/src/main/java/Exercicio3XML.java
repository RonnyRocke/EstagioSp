import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class Exercicio3XML {
    public static void main(String[] args) {
        try {
            // Carregar o arquivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("dados.xml");

            NodeList rows = document.getElementsByTagName("row");

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;

            // Processar os dados do XML
            for (int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                double valor = Double.parseDouble(row.getElementsByTagName("valor").item(0).getTextContent());

                if (valor > 0) {
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                    somaFaturamento += valor;
                    diasComFaturamento++;
                }
            }

            double mediaMensal = somaFaturamento / diasComFaturamento;
            int diasAcimaMedia = 0;

            // Reprocessar os dados para contar os dias acima da média
            for (int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                double valor = Double.parseDouble(row.getElementsByTagName("valor").item(0).getTextContent());

                if (valor > mediaMensal) {
                    diasAcimaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaMedia);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
