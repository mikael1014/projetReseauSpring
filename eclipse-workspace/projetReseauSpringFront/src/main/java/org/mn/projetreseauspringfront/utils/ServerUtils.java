package org.mn.projetreseauspringfront.utils;


import javax.servlet.http.HttpServletRequest;

import org.mn.projetreseauspringfront.dto.UtilisateurDTO;

import static org.mn.projetreseauspringfront.constants.Constants.PROFILE_IMAGES;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerUtils {

    public static UtilisateurDTO getUtilisateurFromSession(HttpServletRequest request){
        return (UtilisateurDTO) request.getSession().getAttribute("utilisateur");
    }

    public static Path getProfileImagesPath() {
        return Paths.get(".").resolve(PROFILE_IMAGES);
    }
}
