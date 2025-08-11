package ac.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/qr")
public class QrController {

    @GetMapping("/generate")
    public String generateQrCode() {
        // Logic for generating QR code will be implemented here
        return "QR code generated successfully!";
    }

    // Additional methods for QR code management can be added here
}