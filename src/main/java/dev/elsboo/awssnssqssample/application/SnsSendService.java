package dev.elsboo.awssnssqssample.application;

import com.amazonaws.jmespath.JmesPathMultiSelectList;
import dev.elsboo.awssnssqssample.domain.SnsSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class SnsSendService {
    private final SnsSender snsSender;

    public void send(String message) {
        verifyMessage(message);
        snsSender.send(message);
    }

    /**
     * 전송하기에 유효한 메시지인지 검사
     * @param message
     */
    private void verifyMessage(String message) {
        if(ObjectUtils.isEmpty(message))
            throw new IllegalArgumentException("Invalid message: " + message);
    }
}
