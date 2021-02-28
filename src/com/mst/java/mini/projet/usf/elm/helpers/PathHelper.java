package com.mst.java.mini.projet.usf.elm.helpers;

public class PathHelper {

    public static String toCurrentOSPathSyntax(String unixPathSyntax){
        if(isWindows()) {

            return unixPathSyntax.replaceAll("/","\\");
        }
        return unixPathSyntax;
    }



    private static boolean isWindows()
    {
        String OSName;
        OSName = System.getProperty("os.name");
        return OSName.startsWith("Windows");
    }
}
