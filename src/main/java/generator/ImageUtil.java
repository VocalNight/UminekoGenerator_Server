package generator;

import org.apache.commons.io.FilenameUtils;
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

    public ArrayList<ImageInfo> getSprites(String name) {
        File folder = new File( FOLDER_LOCATION + "sprites" + "\\" + name);
        ArrayList<ImageInfo> sprites = Arrays.asList(folder.listFiles()).stream().map(img -> {

            ImageInfo image = new ImageInfo();
            image.setFileName(img.getName());
            image.setFilePath(img.getAbsolutePath());
            return image;

        }).collect(Collectors.toCollection(ArrayList::new));
        return sprites;
    }


    public ArrayList<ImageInfo> getChars() {
        File folder = new File(FOLDER_LOCATION + "sprites\\charchooser2");
        ArrayList<ImageInfo> characters = Arrays.asList(folder.listFiles()).stream().map(img ->
        {
            ImageInfo image = new ImageInfo();
            image.setName(FilenameUtils.removeExtension(img.getName()));
            image.setFilePath(img.getAbsolutePath());
            image.setFileName(img.getName());
            return image;
        }).collect(Collectors.toCollection(ArrayList::new));
        return characters;
    }
}


/*
    ImageInfo image = new ImageInfo();
            image.setFileName(img.getName());
                    image.setFilePath(img.getAbsolutePath());*/
