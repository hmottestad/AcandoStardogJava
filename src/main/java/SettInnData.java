import com.complexible.stardog.api.Connection;
import com.complexible.stardog.api.ConnectionConfiguration;
import org.openrdf.model.IRI;
import org.openrdf.model.Literal;
import org.openrdf.model.impl.SimpleValueFactory;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;

import java.util.UUID;


public class SettInnData {

    static SimpleValueFactory valueFactory = SimpleValueFactory.getInstance();
    static ConnectionConfiguration connectionConfiguration = Delt.getConnectionConfiguration("java");

    public static void main(String[] args) {


        try (Connection connection = connectionConfiguration.connect()) {
            connection.begin();

            UUID uuid = UUID.randomUUID();

            IRI subject = valueFactory.createIRI("http://example.com/" + uuid);
            Literal hurra = valueFactory.createLiteral("HURRA_" + uuid);
            IRI NoeFraJava = valueFactory.createIRI("http://example.com/NoeFraJava");

            System.out.println(subject);
            System.out.println(hurra);

            connection.add()
                .statement(subject, RDFS.LABEL, hurra)
                .statement(subject, RDF.TYPE, NoeFraJava);

            connection.commit();
        }


        System.out.println();
        System.out.println("Gå hit for å se om dataene ble lagt inn");
        System.out.println("http://128.199.32.62:5820/java#!/browse/http%3A%2F%2Fexample.com%2FNoeFraJava");

    }

}
