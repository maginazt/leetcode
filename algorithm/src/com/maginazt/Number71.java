package com.maginazt;

/**
 * Created by Administrator on 2016/7/29.
 */
public class Number71 {

    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        int dirStartIndex = -1;
        for(int i=0;i<path.length();i++){
            if(path.charAt(i) == '/'){
                if(dirStartIndex != -1){
                    String dir = path.substring(dirStartIndex, i);
                    switch (dir){
                        case "/..":
                            if(sb.length()>0)
                                sb.delete(sb.lastIndexOf("/"), sb.length());
                            break;
                        case "/.":
                        case "/":
                            break;
                        default:
                            sb.append(dir);
                    }
                }
                dirStartIndex = i;
            }
        }
        String dir = path.substring(dirStartIndex, path.length());
        switch (dir){
            case "/..":
                if(sb.length()>0)
                    sb.delete(sb.lastIndexOf("/"), sb.length());
                break;
            case "/.":
            case "/":
                break;
            default:
                sb.append(dir);
        }
        if(sb.length() == 0)
            return "/";
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number71().simplifyPath("/home//foo/"));
    }
}
