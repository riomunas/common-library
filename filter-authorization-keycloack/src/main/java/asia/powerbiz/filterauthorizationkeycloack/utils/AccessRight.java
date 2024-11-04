package asia.powerbiz.filterauthorizationkeycloack.utils;

import asia.powerbiz.filterauthorizationkeycloack.constant.AccessTypeEnum;
import asia.powerbiz.filterauthorizationkeycloack.constant.RestrictionData;
import asia.powerbiz.filterauthorizationkeycloack.models.AccessListDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccessRight {

    public static boolean hasReadAccess(AccessListDto accessList){
        return hasAccess(accessList, AccessTypeEnum.READ);
    }

    public static boolean hasCreateAccess(AccessListDto accessList){
        return hasAccess(accessList, AccessTypeEnum.CREATE);
    }

    public static boolean hasUpdateAccess(AccessListDto accessList){
        return hasAccess(accessList, AccessTypeEnum.UPDATE);
    }

    public static boolean hasDeleteAccess(AccessListDto accessList){
        return hasAccess(accessList, AccessTypeEnum.DELETE);
    }

    public static boolean hasAccess(AccessListDto accessList, AccessTypeEnum type){
        List<String> rightList = accessList.getAccessType().stream().filter(at -> at.equals(type.name())).toList();
        return !rightList.isEmpty();
    }

    public static List<String> getAllowedBusiness(AccessListDto accessList) throws IllegalAccessException {
        List<String> allowedBusiness = new ArrayList<>();
        if (!accessList.getRestrictionLevel().equalsIgnoreCase(RestrictionData.WORKSPACE_LEVEL)) {
            if (accessList.getRestrictionList() != null && !accessList.getRestrictionList().isEmpty()) {
                if (accessList.getRestrictionBase().equalsIgnoreCase("business")) {
                    allowedBusiness = accessList.getRestrictionList().stream()
                            .distinct()
                            .filter(accessList.getBusinessId()::contains)
                            .collect(Collectors.toList());
                } else if (accessList.getRestrictionBase().equalsIgnoreCase("warehouse")) {
                    allowedBusiness = accessList.getBusinessId();
                }
            } else {
                throw new IllegalAccessException("Access denied");
            }
        }
        return allowedBusiness;
    }

    public static List<UUID> getAllowedWarehouses(AccessListDto accessList) {
        List<UUID> allowedWarehouses = new ArrayList<>();
        if (!accessList.getRestrictionLevel().equalsIgnoreCase("workspace")) {
            if (accessList.getRestrictionBase().equalsIgnoreCase("warehouse")) {
                if (accessList.getRestrictionList() != null && !accessList.getRestrictionList().isEmpty()) {
                    allowedWarehouses.addAll(accessList.getRestrictionList().stream().map(UUID::fromString).toList());
                }
            }
        }
        return allowedWarehouses;
    }
}
