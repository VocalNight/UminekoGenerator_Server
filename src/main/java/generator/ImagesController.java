package generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
public class ImagesController {

    private ImageUtil util;

    public ImagesController(ImageUtil util) {
        this.util = util;
    }

    @RequestMapping("/backgrounds")
    public ArrayList<String> backgroundRequest() {
        return util.getBackgrounds();
    }

    @RequestMapping("/sprites")
    public ArrayList<String> spritesRequest(@RequestParam(value = "name") String name, @RequestParam(value = "subFolder", required = false) String subFolder) {
        return util.getSprites(name, subFolder);
    }

}
