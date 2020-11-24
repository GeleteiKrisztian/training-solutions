package stringmethods;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        if (isEmptyAndBlank(str) ) {
            throw new IllegalArgumentException("Empty string!");
        }
            return str.trim().charAt(str.trim().length() - 1);
    }


    public String findFileExtension(String filename) {
        if (isInvalidFileName(filename)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
            return filename.substring(filename.lastIndexOf("."));
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (isInvalidFileName(ext) || isInvalidFileName(fileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
            return new FileNameManipulator().findFileExtension(fileName).equalsIgnoreCase("." + ext);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (isInvalidFileName(searchedFileName) || isInvalidFileName(actualFileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
            return searchedFileName.equalsIgnoreCase(actualFileName);
    }

    public String changeExtensionToLowerCase(String filename) {
        if(isEmptyAndBlank(filename)) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (isInvalidFileName(filename)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
            return filename.substring(0,filename.lastIndexOf(".")).concat(filename.substring(filename.lastIndexOf(".")).toLowerCase());
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isInvalidFileName(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (!fileName.contains(present)) {
            return fileName;
        }
        StringBuilder sb = new StringBuilder(fileName);
        while (sb.toString().contains(present)) {
        sb.insert(sb.indexOf(present), target);
        sb.delete(sb.indexOf(present),sb.indexOf(present) + present.length());
        }
        return sb.toString();
    }

    private boolean isEmptyAndBlank(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
    }

    private boolean isInvalidFileName(String s) {
        if ( s == null || s.isBlank() || s.charAt(0) == '.') {
            return true;
        }
        return false;
    }

}
