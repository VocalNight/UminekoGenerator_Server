package generator;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
public class ImagesController {

    private ImageUtil util;

    public ImagesController(ImageUtil util) {
        this.util = util;
    }

    @GetMapping("/backgrounds")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<ImageInfo> backgroundRequest() {
        return util.getBackgrounds();
    }

    @GetMapping("/sprites")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<ImageInfo> spritesRequest(@RequestParam(value = "name") String name) {
        return util.getSprites(name);
    }

    @GetMapping("/sprites/charchooser")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<ImageInfo> charRequest() {
        return util.getChars();
    }

}
