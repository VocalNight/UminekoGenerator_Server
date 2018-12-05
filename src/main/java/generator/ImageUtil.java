package generator;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.servlet.ServletContext;

@Component
public class ImageUtil {

    public static final String FOLDER_LOCATION = "D:\\Programming\\Intelij\\UminekoGenerator\\Assets\\";

    public ArrayList<ImageInfo> getBackgrounds() {
        File folder = new File(FOLDER_LOCATION + "bgresize");
        ArrayList<ImageInfo> backgrounds = Arrays.asList(folder.listFiles()).stream().map(img ->
        {
            ImageInfo image = new ImageInfo();
            image.setFileName(img.getName());
            image.setFilePath(img.getAbsolutePath());
            return image;
        }).collect(Collectors.toCollection(ArrayList::new));
        return backgrounds;
    }

    public ArrayList<String> getSprites(String name, String subFolder) {
        String sub = (subFolder == null) ? "" : "\\" + subFolder;
        File folder = new File( FOLDER_LOCATION + "Sprites" + "\\" + name + sub);
        ArrayList<String> sprites = Arrays.asList(folder.listFiles()).stream().map(image -> image.getName()).collect(Collectors.toCollection(ArrayList::new));
        return sprites;
    }


    public ArrayList<ImageInfo> getChars() {
        File folder = new File(FOLDER_LOCATION + "sprites\\charchooser2");
        ArrayList<ImageInfo> characters = Arrays.asList(folder.listFiles()).stream().map(img ->
        {
            ImageInfo image = new ImageInfo();
            image.setFileName(img.getName());
            image.setFilePath(img.getAbsolutePath());
            return image;
        }).collect(Collectors.toCollection(ArrayList::new));
        return characters;
    }
}


/*
    ImageInfo image = new ImageInfo();
            image.setFileName(img.getName());
                    image.setFilePath(img.getAbsolutePath());*/
