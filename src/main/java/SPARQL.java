import com.complexible.stardog.api.Connection;
import com.complexible.stardog.api.ConnectionConfiguration;
import info.aduna.iteration.Iterations;
import org.openrdf.query.TupleQueryResult;


public class SPARQL {


    static ConnectionConfiguration connectionConfiguration = Delt.getConnectionConfiguration("testDB");


    public static void main(String[] args) {


        try (Connection connection = connectionConfiguration.connect()) {
            connection.begin();

            TupleQueryResult acando = connection
                .select(
                    "select ?a ?b ?c where {" +
                        "   ?a <http://brreg.no/navn> ?navn." +
                        "   ?a ?b ?c. " +
                        "}"
                )
                .parameter("navn", "ACANDO AS")
                .execute();


            Iterations.stream(acando).forEach(System.out::println);

            connection.commit();
        }


    }


}
