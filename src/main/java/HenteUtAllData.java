import com.complexible.stardog.api.Connection;
import com.complexible.stardog.api.ConnectionConfiguration;

import java.util.Comparator;


public class HenteUtAllData {

    static ConnectionConfiguration connectionConfiguration = Delt.getConnectionConfiguration("java");


    public static void main(String[] args) {


        try (Connection connection = connectionConfiguration.connect()) {

            connection.begin();

            connection
                .get()
                .statements()
                .sorted(Comparator.comparing(a -> a.getSubject().toString()))
                .forEach(System.out::println);

            connection.commit();

        }

    }


}
