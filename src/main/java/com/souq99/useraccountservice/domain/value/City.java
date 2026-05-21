package com.souq99.useraccountservice.domain.value;

import lombok.Getter;

@Getter
public enum City {

    // PORTUGAL
    LISBON(Country.PORTUGAL,Region.LISBON, "enum.city.lisbon"),
    CASCAIS(Country.PORTUGAL,Region.LISBON, "enum.city.cascais"),
    SINTRA(Country.PORTUGAL,Region.LISBON, "enum.city.sintra"),
    AMADORA(Country.PORTUGAL,Region.LISBON, "enum.city.amadora"),

    PORTO(Country.PORTUGAL,Region.NORTE, "enum.city.porto"),
    BRAGA(Country.PORTUGAL,Region.NORTE, "enum.city.braga"),
    GUIMARAES(Country.PORTUGAL,Region.NORTE, "enum.city.guimaraes"),
    VILA_NOVA_DE_GAIA(Country.PORTUGAL,Region.NORTE, "enum.city.vila_nova_de_gaia"),

    COIMBRA(Country.PORTUGAL,Region.CENTRO, "enum.city.coimbra"),
    AVEIRO(Country.PORTUGAL,Region.CENTRO, "enum.city.aveiro"),
    LEIRIA(Country.PORTUGAL,Region.CENTRO, "enum.city.leiria"),
    VISEU(Country.PORTUGAL,Region.CENTRO, "enum.city.viseu"),

    EVORA(Country.PORTUGAL,Region.ALENTEJO, "enum.city.evora"),
    BEJA(Country.PORTUGAL,Region.ALENTEJO, "enum.city.beja"),

    FARO(Country.PORTUGAL,Region.ALGARVE, "enum.city.faro"),
    ALBUFEIRA(Country.PORTUGAL,Region.ALGARVE, "enum.city.albufeira"),
    LAGOS(Country.PORTUGAL,Region.ALGARVE, "enum.city.lagos"),
    PORTIMAO(Country.PORTUGAL,Region.ALGARVE, "enum.city.portimao"),

    FUNCHAL(Country.PORTUGAL,Region.MADEIRA, "enum.city.funchal"),

    PONTA_DELGADA(Country.PORTUGAL,Region.AZORES, "enum.city.ponta_delgada"),

    // EGYPT
    CAIRO(Country.EGYPT,Region.CAIRO, "enum.city.cairo"),
    NEW_CAIRO(Country.EGYPT,Region.CAIRO, "enum.city.new_cairo"),
    HELWAN(Country.EGYPT,Region.CAIRO, "enum.city.helwan"),

    GIZA(Country.EGYPT,Region.GIZA, "enum.city.giza"),
    SIXTH_OF_OCTOBER(Country.EGYPT,Region.GIZA, "enum.city.sixth_of_october"),
    SHEIKH_ZAYED(Country.EGYPT,Region.GIZA, "enum.city.sheikh_zayed"),

    ALEXANDRIA(Country.EGYPT,Region.ALEXANDRIA, "enum.city.alexandria"),

    MANSOURA(Country.EGYPT,Region.DAKAHLIA, "enum.city.mansoura"),

    ZAGAZIG(Country.EGYPT,Region.SHARQIA, "enum.city.zagazig"),

    TANTA(Country.EGYPT,Region.GHARBIA, "enum.city.tanta"),

    BENHA(Country.EGYPT,Region.QALYUBIA, "enum.city.benha"),

    MINYA_CITY(Country.EGYPT,Region.MINYA, "enum.city.minya_city"),

    ASYUT_CITY(Country.EGYPT,Region.ASYUT, "enum.city.asyut_city"),

    SOHAG_CITY(Country.EGYPT,Region.SOHAG, "enum.city.sohag_city"),

    QENA_CITY(Country.EGYPT,Region.QENA, "enum.city.qena_city"),

    LUXOR_CITY(Country.EGYPT,Region.LUXOR, "enum.city.luxor_city"),

    ASWAN_CITY(Country.EGYPT,Region.ASWAN, "enum.city.aswan_city"),

    HURGHADA(Country.EGYPT,Region.RED_SEA, "enum.city.hurghada"),

    SHARM_EL_SHEIKH(Country.EGYPT,Region.SOUTH_SINAI, "enum.city.sharm_el_sheikh"),

    EL_ARISH(Country.EGYPT,Region.NORTH_SINAI, "enum.city.el_arish"),

    SUEZ_CITY(Country.EGYPT,Region.SUEZ, "enum.city.suez_city"),

    PORT_SAID_CITY(Country.EGYPT,Region.PORT_SAID, "enum.city.port_said_city"),

    ISMAILIA_CITY(Country.EGYPT,Region.ISMAILIA, "enum.city.ismailia_city"),

    // SUDAN
    KHARTOUM_CITY(Country.SUDAN,Region.KHARTOUM, "enum.city.khartoum_city"),
    OMDURMAN(Country.SUDAN,Region.KHARTOUM, "enum.city.omdurman"),
    KHARTOUM_NORTH(Country.SUDAN,Region.KHARTOUM, "enum.city.khartoum_north"),

    PORT_SUDAN(Country.SUDAN,Region.RED_SEA_STATE, "enum.city.port_sudan"),

    WAD_MEDANI(Country.SUDAN,Region.AL_JAZIRAH, "enum.city.wad_medani"),

    ATBARA(Country.SUDAN,Region.RIVER_NILE, "enum.city.atbara"),

    DONGOLA(Country.SUDAN,Region.NORTHERN, "enum.city.dongola"),

    EL_OBEID(Country.SUDAN,Region.NORTH_KORDOFAN, "enum.city.el_obeid"),

    KADUGLI(Country.SUDAN,Region.SOUTH_KORDOFAN, "enum.city.kadugli"),

    EL_FULA(Country.SUDAN,Region.WEST_KORDOFAN, "enum.city.el_fula"),

    KOSTI(Country.SUDAN,Region.WHITE_NILE, "enum.city.kosti"),

    DAMAZIN(Country.SUDAN,Region.BLUE_NILE, "enum.city.damazin"),

    GEDAREF_CITY(Country.SUDAN,Region.GEDAREF, "enum.city.gedaref_city"),

    KASSALA_CITY(Country.SUDAN,Region.KASSALA, "enum.city.kassala_city"),

    SINJA(Country.SUDAN,Region.SENNAR, "enum.city.sinja"),

    EL_FASHER(Country.SUDAN,Region.DARFUR_NORTH, "enum.city.el_fasher"),

    NYALA(Country.SUDAN,Region.DARFUR_SOUTH, "enum.city.nyala"),

    EL_GENEINA(Country.SUDAN,Region.DARFUR_WEST, "enum.city.el_geneina");

    private final Region region;
    private final String messageKey;
    private final Country country;

    City(Country country,Region region, String messageKey) {
        this.region = region;
        this.messageKey = messageKey;
        this.country = country;
    }
}
