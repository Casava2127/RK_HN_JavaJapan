package ac.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ac.controllers.QrController;

@RestController
@RequestMapping("/api/qr")
public class QrRoutes {

    private final QrController qrController;

    @Autowired
    public QrRoutes(QrController qrController) {
        this.qrController = qrController;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generateQrCode(@RequestBody QrRequest qrRequest) {
        return qrController.generateQrCode(qrRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQrCode(@PathVariable Long id) {
        return qrController.getQrCode(id);
    }

    // Additional routes can be added here as needed
}