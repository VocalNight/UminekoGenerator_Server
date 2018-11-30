package generator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;

@Component
public class ImageUtil {

    public static final String FOLDER_LOCATION = "D:\\Programming\\Intelij\\UminekoGenerator\\Assets\\";

    public ArrayList<String> getBackgrounds() {
        File folder = new File(FOLDER_LOCATION + "Backgrounds");
        ArrayList<String> backgrounds = Arrays.asList(folder.listFiles()).stream().map(image -> image.getName()).collect(Collectors.toCollection(ArrayList::new));
        return backgrounds;
    }

    public ArrayList<String> getSprites(String name, String subFolder) {
        String sub = (subFolder == null) ? "" : "\\" + subFolder;
        File folder = new File( FOLDER_LOCATION + "Sprites" + "\\" + name + sub);
        ArrayList<String> sprites = Arrays.asList(folder.listFiles()).stream().map(image -> image.getName()).collect(Collectors.toCollection(ArrayList::new));
        return sprites;
    }
}
