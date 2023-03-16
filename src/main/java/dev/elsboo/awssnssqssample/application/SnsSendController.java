package dev.elsboo.awssnssqssample.application;

import dev.elsboo.awssnssqssample.domain.SnsSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sns")
@RequiredArgsConstructor
public class SnsSendController {
    private final SnsSendService snsSendService;

    @GetMapping("test")
    public String test(@RequestParam String msg) {
        return msg;
    }

    /**
     * SNS 메시지 전송
     * @param message
     * @return
     */
    @GetMapping("send")
    public String send(@RequestParam String message) {
        snsSendService.send(message);
        return "Send succeed: " + message;
    }
}

