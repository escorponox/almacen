package jpa.enums;

import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.text.WordUtils.capitalizeFully;

public enum RoleTypeEnum {
    ROLE_ADMIN,
    ROLE_SELLER,
    ROLE_STORE;

    public static List<RoleTypeEnum> asList() {
        RoleTypeEnum[] all = RoleTypeEnum.values();
        return Arrays.asList(all);
    }

    @Override
    public String toString() {
        return capitalizeFully(name().replace('_', ' '));
    }
}
