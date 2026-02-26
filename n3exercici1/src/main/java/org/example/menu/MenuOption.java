package org.example.menu;

import org.example.service.PersonService;

public enum MenuOption {
    ADD_PERSON(1, "Introduir persona.", null),
    SHOW_NAME_ASC(2, "Mostrar les persones ordenades per nom (A-Z).", PersonService.SortType.NAME_ASC),
    SHOW_NAME_DESC(3, "Mostrar les persones ordenades per nom (Z-A).", PersonService.SortType.NAME_DESC),
    SHOW_SURNAME_ASC(4, "Mostrar les persones ordenades per cognoms (A-Z).", PersonService.SortType.SURNAME_ASC),
    SHOW_SURNAME_DESC(5, "Mostrar les persones ordenades per cognoms (Z-A).", PersonService.SortType.SURNAME_DESC),
    SHOW_DNI_ASC(6, "Mostrar les persones ordenades per DNI (1-9).", PersonService.SortType.DNI_ASC),
    SHOW_DNI_DESC(7, "Mostrar les persones ordenades per DNI (9-1).", PersonService.SortType.DNI_DESC),
    EXIT(0, "Sortir.", null);

    private final int code;
    private final String label;
    private final PersonService.SortType sortType;

    MenuOption(int code, String label, PersonService.SortType sortType) {
        this.code = code;
        this.label = label;
        this.sortType = sortType;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public PersonService.SortType getSortType() {
        return sortType;
    }

    public static MenuOption fromCode(int code) {
        for (MenuOption option : values()) {
            if (option.code == code) {
                return option;
            }
        }
        return null;
    }
}
