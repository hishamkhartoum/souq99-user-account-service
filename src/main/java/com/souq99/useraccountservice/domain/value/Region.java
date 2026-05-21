package com.souq99.useraccountservice.domain.value;

import lombok.Getter;

@Getter
public enum Region {

    // PORTUGAL
    LISBON(Country.PORTUGAL, "enum.region.lisbon"),
    NORTE(Country.PORTUGAL, "enum.region.norte"),
    CENTRO(Country.PORTUGAL, "enum.region.centro"),
    ALENTEJO(Country.PORTUGAL, "enum.region.alentejo"),
    ALGARVE(Country.PORTUGAL, "enum.region.algarve"),
    MADEIRA(Country.PORTUGAL, "enum.region.madeira"),
    AZORES(Country.PORTUGAL, "enum.region.azores"),

    // EGYPT
    CAIRO(Country.EGYPT, "enum.region.cairo"),
    GIZA(Country.EGYPT, "enum.region.giza"),
    ALEXANDRIA(Country.EGYPT, "enum.region.alexandria"),
    DAKAHLIA(Country.EGYPT, "enum.region.dakahlia"),
    SHARQIA(Country.EGYPT, "enum.region.sharqia"),
    GHARBIA(Country.EGYPT, "enum.region.gharbia"),
    QALYUBIA(Country.EGYPT, "enum.region.qalyubia"),
    MINYA(Country.EGYPT, "enum.region.minya"),
    ASYUT(Country.EGYPT, "enum.region.asyut"),
    SOHAG(Country.EGYPT, "enum.region.sohag"),
    QENA(Country.EGYPT, "enum.region.qena"),
    LUXOR(Country.EGYPT, "enum.region.luxor"),
    ASWAN(Country.EGYPT, "enum.region.aswan"),
    RED_SEA(Country.EGYPT, "enum.region.red_sea"),
    SOUTH_SINAI(Country.EGYPT, "enum.region.south_sinai"),
    NORTH_SINAI(Country.EGYPT, "enum.region.north_sinai"),
    SUEZ(Country.EGYPT, "enum.region.suez"),
    PORT_SAID(Country.EGYPT, "enum.region.port_said"),
    ISMAILIA(Country.EGYPT, "enum.region.ismailia"),

    // SUDAN
    KHARTOUM(Country.SUDAN, "enum.region.khartoum"),
    RED_SEA_STATE(Country.SUDAN, "enum.region.red_sea_state"),
    AL_JAZIRAH(Country.SUDAN, "enum.region.al_jazirah"),
    RIVER_NILE(Country.SUDAN, "enum.region.river_nile"),
    NORTHERN(Country.SUDAN, "enum.region.northern"),
    NORTH_KORDOFAN(Country.SUDAN, "enum.region.north_kordofan"),
    SOUTH_KORDOFAN(Country.SUDAN, "enum.region.south_kordofan"),
    WEST_KORDOFAN(Country.SUDAN, "enum.region.west_kordofan"),
    WHITE_NILE(Country.SUDAN, "enum.region.white_nile"),
    BLUE_NILE(Country.SUDAN, "enum.region.blue_nile"),
    GEDAREF(Country.SUDAN, "enum.region.gedaref"),
    KASSALA(Country.SUDAN, "enum.region.kassala"),
    SENNAR(Country.SUDAN, "enum.region.sennar"),
    DARFUR_NORTH(Country.SUDAN, "enum.region.darfur_north"),
    DARFUR_SOUTH(Country.SUDAN, "enum.region.darfur_south"),
    DARFUR_WEST(Country.SUDAN, "enum.region.darfur_west"),
    DARFUR_EAST(Country.SUDAN, "enum.region.darfur_east"),
    DARFUR_CENTRAL(Country.SUDAN, "enum.region.darfur_central");

    private final Country country;
    private final String messageKey;

    Region(Country country, String messageKey) {
        this.country = country;
        this.messageKey = messageKey;
    }
}
