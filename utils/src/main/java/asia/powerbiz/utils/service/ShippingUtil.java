package asia.powerbiz.utils.service;

import io.micrometer.common.util.StringUtils;

import java.util.HashMap;

public class ShippingUtil {

    public static String getCourierLogo(String courier) {
        if (StringUtils.isBlank(courier))
            return null;

        HashMap<String, String> courierLogoMap = new HashMap<>() {
            {
                put("Antaraja", "https://ik.imagekit.io/powerbiz/courier/kurir-anteraja.png?updatedAt=1700207258468");
                put("GoSend", "https://ik.imagekit.io/powerbiz/courier/GoSend%20(1).svg?updatedAt=1700209935424");
                put(
                        "GrabExpress",
                        "https://ik.imagekit.io/powerbiz/courier/grab-express_pcs1Bnmca?updatedAt=1700215097081"
                );
                put(
                        "ID Express",
                        "https://ik.imagekit.io/powerbiz/courier/Courier%20New%20Logo.png?updatedAt=1723697240362"
                );
                put("J&T", "https://ik.imagekit.io/powerbiz/courier/J&T%20Express%20logo.svg?updatedAt=1723697330339");
                put("JNE", "https://ik.imagekit.io/powerbiz/courier/kurir-jne.png?updatedAt=1700207258914");
                put("Ninja", "https://ik.imagekit.io/powerbiz/courier/kurir-ninja.png?updatedAt=1700207259099");
                put("POS", "https://ik.imagekit.io/powerbiz/courier/kurir-pos-aja.png?updatedAt=1700207258542");
                put(
                        "Sentral Cargo",
                        "https://ik.imagekit.io/powerbiz/courier/Sentral%20Cargo.png?updatedAt=1723697711642"
                );
                put("SiCepat", "https://ik.imagekit.io/powerbiz/courier/Courier%20sicepat.png?updatedAt=1723698236869");
                put("SPX", "https://ik.imagekit.io/powerbiz/courier/kurir-spx.svg?updatedAt=1723690768157");
            }
        };

        for (String key : courierLogoMap.keySet()) {
            if (key.equalsIgnoreCase(courier)) {
                return courierLogoMap.get(key);
            }
        }

        return null;
    }
}
