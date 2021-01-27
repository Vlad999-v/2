import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;


public class SerializeJSON {
    ObjectMapper mapper;

    public SerializeJSON() {
       mapper = new ObjectMapper();
       ////
       mapper.registerModule(new JavaTimeModule());
       mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public void serializer(Actor obj, File file) throws IOException {
        try {
            mapper.writeValue(file, obj);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Actor deserializer(File file) {
        try {

            return mapper.readValue(file, Actor.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}




