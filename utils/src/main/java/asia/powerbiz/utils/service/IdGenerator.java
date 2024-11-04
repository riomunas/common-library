package asia.powerbiz.utils.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IdGenerator {

    public String randomHashId() {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 30;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String randomNumber(Integer length){
        return randomString("1234567890", length);
    }

    public static String randomString(String pattern, Integer length){
        Random rand=new Random();
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randIndex=rand.nextInt(pattern.length());
            res.append(pattern.charAt(randIndex));
        }
        return res.toString();
    }

    public static String buildWorkspaceId(String workspaceName){
        return workspaceName.trim().toUpperCase().substring(0,1).concat(randomString(workspaceName.trim().toUpperCase().substring(1,4), 3)).concat(randomNumber(4));
    }
}