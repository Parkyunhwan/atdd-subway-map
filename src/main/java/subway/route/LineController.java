package subway.route;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping("/lines")
    public ResponseEntity<LineResponse> createStation(@RequestBody LineRequest routeRequest) {
        LineResponse lineResponse = lineService.saveLine(routeRequest);
        return ResponseEntity.created(URI.create("/lines/1")).body(lineResponse);
    }

    @GetMapping("/lines")
    public ResponseEntity<List<LineResponse>> showStations() {
        List<LineResponse> lineResponses = lineService.findAllStations();
        return ResponseEntity.ok(lineResponses);
    }
}
