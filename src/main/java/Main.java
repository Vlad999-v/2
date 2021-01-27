import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Actor Robert_John_Downey = new Actor.Builder().withname("Robert_John")
                .withsurname("Downey")
                .withrowth(1.75)
                .withbirthdate(LocalDate.of(1965, 4, 4))
                .withbirthplace("USA,Mangetten")
                .build();

        SerializeJSON serialize1 = new SerializeJSON();
        SerializeXML serialize2 = new SerializeXML();
        SerializeTXT serialize3 = new SerializeTXT();

        try {
            serialize1.serializer(Robert_John_Downey, new File("actor.json"));
            serialize2.serializer(Robert_John_Downey, new File("actor.XML"));
            serialize3.serializer(Robert_John_Downey, new File("actor.txt"));
        }
        catch (Exception error){
            error.printStackTrace();
        }

        Actor actorjson = new Actor();
        Actor actorxml = new Actor();
        Actor actortxt = new Actor();

        try {
            actortxt = serialize3.deserializer(new File("actor.txt"));
            actorxml = serialize2.deserializer(new File("actor.XML"));
            actorjson = serialize1.deserializer(new File("actor.json"));
        }

        catch (Exception error){
            error.printStackTrace();
        }

        System.out.println(actorjson);
        System.out.println(actorxml);
        System.out.println(actortxt);


    }
}
