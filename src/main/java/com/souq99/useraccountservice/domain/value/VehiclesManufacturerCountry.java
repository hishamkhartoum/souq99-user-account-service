package com.souq99.useraccountservice.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VehiclesManufacturerCountry {
    IT("enum.manufacturer_country.it"),
    JP("enum.manufacturer_country.jp"),
    FR("enum.manufacturer_country.fr"),
    US("enum.manufacturer_country.us"),
    CN("enum.manufacturer_country.cn"),
    UK("enum.manufacturer_country.uk"),
    DE("enum.manufacturer_country.de"),
    ES("enum.manufacturer_country.es"),
    RO("enum.manufacturer_country.ro"),
    RU("enum.manufacturer_country.ru"),
    BR("enum.manufacturer_country.br"),
    KR("enum.manufacturer_country.kr"),
    AU("enum.manufacturer_country.au"),
    IN("enum.manufacturer_country.in"),
    SE("enum.manufacturer_country.se"),
    MY("enum.manufacturer_country.my"),
    CZ("enum.manufacturer_country.cz"),
    TR("enum.manufacturer_country.tr"),
    VN("enum.manufacturer_country.vn");

    private final String messageKey;
}
