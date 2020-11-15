package stringmethods;


public class UrlManager {

    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public UrlManager(String url) {
        if (!isNullOrEmpty(url)) {
            protocol = protocolMaker(url);
            port = portMaker(url);
            host = hostMaker(url);
            path = pathMaker(url);
            query = queryMaker(url);
        }
    }

    public boolean hasProperty(String key) {
        isNullOrEmpty(key);
        return query.startsWith(key + "=") || query.contains("&" + key + "=");
    }

    public String getProperty(String key) {
        isNullOrEmpty(key);
        String[] properties = query.split("&");
        for (String str : properties) {
            String[] prop = str.split("=");
            if (prop[0].equals(key)) {
                return prop[1];
            }
        }
        return null;
    }

    private String protocolMaker(String s) {
        int endIndex = s.indexOf("://");
        if (endIndex == -1 || s.substring(0,endIndex).isBlank()) {
            throw new IllegalArgumentException("Invalid url");
        }
        String protocol = s.substring(0,s.indexOf(":")).toLowerCase();
        return protocol;
    }

    private String hostMaker(String url) {
            String host;
            int startIndex = url.indexOf("://") + 3;
            int endIndex = url.indexOf(":", startIndex);
            if (endIndex == -1) {
                endIndex = url.indexOf("/", startIndex);
            }
            if (endIndex == -1) {
                host = url.substring(startIndex).toLowerCase();
            } else {
                host = url.substring(startIndex, endIndex).toLowerCase();
            }
            if (host.isEmpty()) {
                throw new IllegalArgumentException("Invalid url");
            }
            return host;
        }

    private String pathMaker(String url) {
        int startIndex = url.indexOf("://") + 3;
        startIndex = url.indexOf("/", startIndex);
        if (startIndex == -1) {
            return "";
        }
        int endIndex = url.indexOf("?");
        if (endIndex == -1) {
            return url.substring(startIndex);
        }
        return url.substring(startIndex, endIndex);
    }

    private Integer portMaker(String url) {
        int startIndex = url.indexOf("://") + 3;
        startIndex = url.indexOf(":", startIndex);
        if (startIndex == -1) {
            return null;
        }
        int endIndex = url.indexOf("/", startIndex);
        if (endIndex == -1) {
            return Integer.valueOf(url.substring(startIndex + 1));
        }
        return Integer.valueOf(url.substring(startIndex + 1, endIndex));
    }

    private String queryMaker(String s) {
        return s.substring(s.indexOf("?") + 1);
    }

    private String[] queryToKeyValuePairs(String query) {
        return queryMaker(query).split("&");
    }

    private boolean isNullOrEmpty(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("");
        }
        return false;
    }

