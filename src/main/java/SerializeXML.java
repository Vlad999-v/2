import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class SerializeXML {
    XmlMapper object;

    public SerializeXML() {
        object = new XmlMapper();
        object.registerModule(new JavaTimeModule());
        object.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }

    public void serializer(Actor obj, File file) throws IOException {
        try {
            object.writeValue(file, obj);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Actor deserializer(File file) {
        try {
            return object.readValue(file, Actor.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
