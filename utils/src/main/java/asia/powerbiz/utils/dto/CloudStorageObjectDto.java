package asia.powerbiz.utils.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@Builder
@ToString
public class CloudStorageObjectDto {

    private String objectKey;
    private byte[] objectContent;
    private String contentType;
    private Map<String, String> metadata;

}
