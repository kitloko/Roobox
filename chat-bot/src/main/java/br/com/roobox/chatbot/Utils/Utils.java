package br.com.roobox.chatbot.Utils;


import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Utils {

    public static String aplicaRegex(String texto, Pattern REGEX) {
        return Optional.ofNullable(texto)
                .map(String::toString)
                .map(REGEX::matcher)
                .filter(Matcher::find)
                .map(Matcher::group)
                .map(String::valueOf)
                .map(String::trim)
                .map(s -> s.replace("\"", ""))
                .orElse("");
    }
}