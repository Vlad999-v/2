import java.io.*;
import java.time.LocalDate;

public class SerializeTXT {

    public void serializer(Actor obj, File file) throws IOException {
        try(FileWriter fw = new FileWriter(file)){
            String str = " Name= " + obj.getName() + " Surname= " + obj.getSurname() + " Birthdate= " + obj.getBirthdate() + " Birthplace= " + obj.getBirthplace()+ " Rowth= " + obj.getRowth();
            fw.write(str);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Actor deserializer(File file) throws IOException {
        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = fr.readLine()) != null && str.length() != 0) {
                String[] values = str.split(" ");
                String tempstr = values[6];
                String[] temp2str = tempstr.split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(temp2str[0]),Integer.parseInt(temp2str[1]),Integer.parseInt(temp2str[2]));
                return new Actor.Builder().withname(values[2]).withsurname(values[4]).withbirthplace(values[8]).withrowth(Double.parseDouble(values[10])).withbirthdate(date).build();
            }
            return new Actor.Builder().withname("Vasil").build();
        }
        catch (IOException e) {
            throw new RuntimeException("File is empty");
        }
    }
}

