package org.mn.projetreseauspringfront.entiy.enum_;

public enum Sexe {
	MASCULIN(1),
    FEMININ(2),
    INCONNU(3);

    private final int sexe;

    Sexe(int sex) {
        sexe = sex;
    }

    public static Sexe getSexeById(Integer id) {
        if (id == null)
            return INCONNU;

        switch (id) {
            case 1:
                return MASCULIN;
            case 2:
                return FEMININ;
            default:
                return INCONNU;
        }
    }

    public static int getSexeByName(String name) {
        if (name == null)
            return INCONNU.sexe;

        switch (name) {
            case "Masculin":
                return MASCULIN.sexe;
            case "Feminin":
                return FEMININ.sexe;
            default:
                return INCONNU.sexe;
        }
    }
}
