package com.epam.izh.rd.online.service;

public class SimpleTextService implements TextService {

    @Override
    public String removeString(String base, String remove) {
        return base.replaceAll(remove, ""); //TODO
    }

    @Override
    public boolean isQuestionString(String text) {
        return text.endsWith("?"); //TODO
    }

    @Override
    public String concatenate(String... elements) {
        StringBuilder concatenation = new StringBuilder();
        for (String element : elements) {
            concatenation.append(element);
        }
        return concatenation.toString(); //TODO
    }

    @Override
    public String toJumpCase(String text) {
        StringBuilder jumpCase = new StringBuilder();
        for (int i = 0; i < text.length() - 1; i += 2) {
            jumpCase.append(text.substring(i, i + 1).toLowerCase()).append(text.substring(i + 1, i + 2).toUpperCase());
        }
        return jumpCase.toString(); //TODO
    }

    @Override
    public boolean isPalindrome(String string) {
        if (!string.isEmpty()) {
            return string.replaceAll("\\s", "").equalsIgnoreCase(new StringBuilder(string.replaceAll("\\s", "")).reverse().toString());
        }
        return false; //TODO
    }
}
