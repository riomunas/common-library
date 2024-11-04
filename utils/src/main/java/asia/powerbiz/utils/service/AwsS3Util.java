package asia.powerbiz.utils.service;

import asia.powerbiz.utils.dto.CloudStorageObjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
@RequiredArgsConstructor
public class AwsS3Util {

    @Value("${aws.bucket}")
    private String bucket;
    @Value("${aws.region}")
    private String region;
    private final S3Client s3Client;

    public void putObject(CloudStorageObjectDto cloudStorageObjectDto) {
        PutObjectRequest putObjectRequest = getObjectRequestBuilder(cloudStorageObjectDto).build();
        putObjectToS3(putObjectRequest, cloudStorageObjectDto);
    }

    public void putObjectRequestPublicRead(CloudStorageObjectDto cloudStorageObjectDto) {
        PutObjectRequest putObjectRequest = getObjectRequestBuilder(cloudStorageObjectDto).acl(ObjectCannedACL.PUBLIC_READ).build();
        putObjectToS3(putObjectRequest, cloudStorageObjectDto);
    }

    public String getUrl(String objectKey) {
        GetUrlRequest getUrlRequest = GetUrlRequest
                .builder()
                .bucket(bucket)
                .key(objectKey)
                .region(Region.of(region))
                .build();
        return s3Client.utilities().getUrl(getUrlRequest).toString();
    }

    private void putObjectToS3(PutObjectRequest putObjectRequest, CloudStorageObjectDto cloudStorageObjectDto) {
        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(cloudStorageObjectDto.getObjectContent()));
    }

    private PutObjectRequest.Builder getObjectRequestBuilder(CloudStorageObjectDto cloudStorageObjectDto) {
        return PutObjectRequest
                .builder()
                .bucket(bucket)
                .key(cloudStorageObjectDto.getObjectKey())
                .metadata(cloudStorageObjectDto.getMetadata())
                .contentType(cloudStorageObjectDto.getContentType());
    }

}
