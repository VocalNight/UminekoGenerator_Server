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
    public ArrayList<String> spritesRequest(@RequestParam(value = "name") String name, @RequestParam(value = "subFolder", required = false) String subFolder) {
        return util.getSprites(name, subFolder);
    }

}
